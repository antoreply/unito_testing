package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.reply.iriscube.unito.activity.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
     val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun verifyLayoutLabelContent() {
        onView(withId(R.id.userNameLabel))
            .check(matches(withText(R.string.username)))

        onView(withId(R.id.passwordLabel))
            .check(matches(withText(R.string.password)))

        onView(withId(R.id.loginButton))
            .check(matches(withText(R.string.entra)))
    }

    @Test
    fun showErrorViewsOnWrongCredentials(){
        onView(withId(R.id.wrongCredential))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        onView(withId(R.id.userNameTextView))
            .perform(typeText("username"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView))
            .perform(typeText("password"), closeSoftKeyboard())

        onView(withId(R.id.loginButton))
            .perform(click())

        onView(withId(R.id.wrongCredential))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun showErrorsViewOnEmptyCredentials(){
        onView(withId(R.id.userNameErrorView))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.passwordErrorView))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

        onView(withId(R.id.loginButton))
            .perform(click())

        onView(withId(R.id.userNameTextView))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.passwordErrorView))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }


}