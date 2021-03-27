package it.reply.iriscube.unito

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import it.reply.iriscube.unito.app.activity.AddressBookActivity
import it.reply.iriscube.unito.app.activity.PersonDetailActivity
import it.reply.iriscube.unito.app.adapter.PeopleAdapter
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class AddressBookActivityTest {

    // activity under test is launched locally in each method (launchActivity == false)
    @get:Rule
    val activityRule = IntentsTestRule(AddressBookActivity::class.java, false, false)

    @get:Rule
    val mockWebServerRule: MockWebServerTestRule =
        MockWebServerTestRule()

    private val mockWebServer: MockWebServer
        get() = mockWebServerRule.mockWebServer


    /**
     * Load data from webserver and check if all three items are shown in the recyclerview
     */
    @Test
    fun successfulPeopleLoadingShouldPopulateRecyclerView() {
        // Preparing the response for the use case.
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(getResponsePayload())
        )

        // start activity local to avoid load data fail with mockWebServer
        activityRule.launchActivity(
            Intent(ApplicationProvider.getApplicationContext(), AddressBookActivity::class.java)
        )

        // Checking that the information displayed by the summary are correct.
        onView(withId(R.id.recyclerView))
            .check(RecyclerViewItemCountAssertion(3)
        )

    }

    /**
     * Receive a internal server error and check if no items are shown in the recyclerview
     */
    @Test
    fun failingPeopleLoadingShouldNotDoAnything() {

        mockWebServer.enqueue(
            MockResponse().setResponseCode(500)
        )

        activityRule.launchActivity(
            Intent(ApplicationProvider.getApplicationContext(), AddressBookActivity::class.java)
        )

        // Checking that the information displayed by the summary are as expected.
        onView(withId(R.id.recyclerView))
            .check(RecyclerViewItemCountAssertion(0))

    }

    /**
     * After a server response correctly, select one item and check if the intent start as expected
     */
    @Test
    fun selectingPersonShouldStartDetailIntent() {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(getResponsePayload())
                // .setBodyDelay(2, TimeUnit.SECONDS) --> test fails if you insert a delay on response
        )

        activityRule.launchActivity(
            Intent(ApplicationProvider.getApplicationContext(), AddressBookActivity::class.java)
        )

        // Selecting a user from the list
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PeopleAdapter.ViewHolder>(1, click())
            )

        // verifying that the right intent is started (based on the item selected)
        intended(
            allOf(
                IntentMatchers.hasComponent(PersonDetailActivity::class.java.name),
                IntentMatchers.hasExtra(PersonDetailActivity.PERSON_ID_EXTRA, 2L)
            )
        )

    }

    private fun getResponsePayload(): String{
        return """
                    {
                        "page": 1,
                        "per_page": 3,
                        "total": 12,
                        "total_pages": 4,
                        "data": [
                            {
                                "id": 1,
                                "email": "george.bluth@gmail.com",
                                "first_name": "George",
                                "last_name": "Bluth",
                                "avatar": ""
                            },
                            {
                                "id": 2,
                                "email": "janet.weaver@yahoo.com",
                                "first_name": "Janet",
                                "last_name": "Weaver",
                                "avatar": ""
                            },
                            {
                                "id": 3,
                                "email": "emma.wong@gmail.com",
                                "first_name": "Emma",
                                "last_name": "Wong",
                                "avatar": ""
                            }
                        ]
                    }
                """.trimIndent()
    }

}
