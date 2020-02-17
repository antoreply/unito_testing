package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import it.reply.iriscube.unito.activity.LoginActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test

/**
 * Created by Reply.
 */

class LoginActivityTest {

    @get:Rule
     val mActivityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun verifyFieldValidation() {
        onView(withId(R.id.userNameTextView)).check(matches(not(withText(""))))
        onView(withId(R.id.passwordTextView)).check(matches(not(withText(""))))
    }
}