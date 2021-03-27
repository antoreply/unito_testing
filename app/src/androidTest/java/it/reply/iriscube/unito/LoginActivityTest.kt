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

    /**
     * The testing framework launches the activity under test before each test method
     * annotated with @Test and before any method annotated with @Before
     */
    @get:Rule
     val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    /**
     * Sample test to check the value inside the default label
     */
    @Test
    fun verifyLayoutLabelContent() {
        onView(withId(R.id.userNameLabel))
            .check(matches(withText(R.string.username)))

        onView(withId(R.id.passwordLabel))
            .check(matches(withText(R.string.password)))

        onView(withId(R.id.loginButton))
            .check(matches(withText(R.string.entra)))
    }

    /**
     * Entering the wrong credentials will show the error TextView wrongCredential
     */
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

    /**
     * Having not entered data in the TextViews (username and password), the relative error views will be shown
     */
    @Test
    fun showErrorsViewOnEmptyCredentials(){

        // TODO (1) check that userNameErrorView and passwordErrorView are not visible

        // TODO (2) Press the login button

        // TODO (3) check that userNameErrorView and passwordErrorView are now visible

    }


}