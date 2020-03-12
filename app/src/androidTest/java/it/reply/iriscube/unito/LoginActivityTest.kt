package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.reply.iriscube.unito.activity.LoginActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test


class LoginActivityTest {

    @get:Rule
    val mIntentrule = IntentsTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun successfulLoginShouldOpenMainScreen() {
        onView(withId(R.id.userNameTextView)).perform(typeText("Marco"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView)).perform(typeText("123456789"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        intended(allOf(
            hasExtraWithKey(LoginActivity.USERNAME)
        ))
    }
}

