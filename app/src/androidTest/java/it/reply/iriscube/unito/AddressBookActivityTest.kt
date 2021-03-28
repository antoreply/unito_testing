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
        activityRule.launchActivity(null)


        // TODO (1) check using custom assertion that the information displayed by the summary are correct (expected 3 items)

    }

    /**
     * Receive a internal server error and check if no items are shown in the recyclerview
     */
    @Test
    fun failingPeopleLoadingShouldNotDoAnything() {

        // TODO (2) simulate an Internal Server Error, code 500, on the mockWebServer


        activityRule.launchActivity(null)


        // TODO (3) check using custom assertion that the information displayed by the summary are correct (expected 0 items)

    }

    /**
     * After a server response correctly, select one item and check if the intent start as expected
     */
    @Test
    fun selectingPersonShouldStartDetailIntent() {

        // TODO (4) simulate a correct response, code 200, on the mockWebServer

        // TODO (5) start the activity as previous

        // TODO (6) select an item in the list of address book

        // TODO (7) verifying that the right intent is started (based on the item selected)


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
