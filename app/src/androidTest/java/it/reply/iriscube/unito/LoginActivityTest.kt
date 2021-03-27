package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.reply.iriscube.unito.activity.LoginActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {


    // TODO Define the correct rule to check for the intent using IntentsTestRule


    /**
     * Check that the login is successful and that the WelcomeActivity intent starts correctly
     */
    @Test
    fun successfulLoginShouldOpenMainScreen() {

        // TODO (1) type a username and password inside the correct EdiText

        // TODO (2) perform a click to login

        // TODO (3) validate intent using intended() and IntentMatchers

    }
}