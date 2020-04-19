package it.reply.iriscube.unito.app.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.activity.mock.AddressBookMockResponses
import it.reply.iriscube.unito.app.mock.MockWebServerTestRule
import it.reply.iriscube.unito.app.utils.EspressoIdlingRsource
import it.reply.iriscube.unito.app.viewassertion.RecyclerViewCounterViewAssertion
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Created by Reply on 2020-04-18.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class AddressBookActivityTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(
        AddressBookActivity::class.java,
        true,
        false)

    @get:Rule
    val mockWebServerTestRule = MockWebServerTestRule()

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingRsource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingRsource.countingIdlingResource)
    }

    val mockWebServer: MockWebServer
        get() = mockWebServerTestRule.mockWebServer

    @Test
    fun correctCountItems() {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(AddressBookMockResponses.getAddressBookResponse)
                .setBodyDelay(2, TimeUnit.SECONDS)
        )

        activityTestRule.launchActivity(null)

        onView(withId(R.id.recyclerView)).check(RecyclerViewCounterViewAssertion(3))

    }



}