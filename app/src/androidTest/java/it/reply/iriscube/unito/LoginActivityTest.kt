package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.reply.iriscube.unito.activity.LoginActivity
import it.reply.iriscube.unito.activity.WelcomeActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun successfulLoginShouldOpenMainScreen() {
        val username = "ilMioUsername"

        onView(withId(R.id.userNameTextView))
            .perform(typeText(username), closeSoftKeyboard())

        onView(withId(R.id.passwordTextView))
            .perform(typeText("123456789"), closeSoftKeyboard())

        onView(withId(R.id.loginButton))
            .perform(click())

        intended(
            allOf(
                hasComponent(WelcomeActivity::class.java.name),
                hasExtra(LoginActivity.USERNAME, username)
            )
        )

    }
}

