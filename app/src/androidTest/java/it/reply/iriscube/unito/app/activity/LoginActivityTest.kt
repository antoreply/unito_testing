package it.reply.iriscube.unito.app.activity

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import it.reply.iriscube.unito.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Reply on 2020-04-18.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun emptyCredentials() {
        onView(withId(R.id.userNameErrorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.passwordErrorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        onView(withId(R.id.loginButton)).perform(click())

        onView(withId(R.id.userNameErrorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.passwordErrorView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

    @Test
    fun wrongCredentials() {
        onView(withId(R.id.wrongCredential)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        onView(withId(R.id.userNameTextView)).perform(typeText("username"))
        onView(withId(R.id.userNameTextView)).perform(pressImeActionButton())
        onView(withId(R.id.passwordTextView)).perform(typeText("password"))
        onView(withId(R.id.passwordTextView)).perform(pressImeActionButton())

        onView(withId(R.id.loginButton)).perform(click())

        onView(withId(R.id.wrongCredential)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

    @Test
    fun correctCredentials() {
        onView(withId(R.id.userNameTextView)).perform(typeText("vjhff"))
        onView(withId(R.id.userNameTextView)).perform(pressImeActionButton())
        onView(withId(R.id.passwordTextView)).perform(typeText("fcjhdjf"))
        onView(withId(R.id.passwordTextView)).perform(pressImeActionButton())

        onView(withId(R.id.loginButton)).perform(click())

        intended(
            allOf(
                hasComponent(WelcomeActivity::class.java.name),
                hasExtra(LoginActivity.USERNAME, "vjhff")

            )
        )


    }


}