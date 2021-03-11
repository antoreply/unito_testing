package it.reply.iriscube.unito

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import it.reply.iriscube.unito.activity.LoginActivity
import org.junit.Rule
import org.junit.Test

/**
 * Created by Reply.
 */

class LoginActivityTest {

    @get:Rule
     val mActivityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

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
    fun verifyErrorLabelsDisplayed(){
        onView(withId(R.id.userNameTextView))
            .perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.passwordTextView))
            .perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.loginButton))
            .perform(click())

        onView(withId(R.id.userNameErrorView))
            .check(matches(isDisplayed()))

        onView(withId(R.id.passwordErrorView))
            .check(matches(isDisplayed()))

    }

    @Test
    fun verifyInputUsername(){
        val username = "MarioRossi123"

        onView(withId(R.id.userNameTextView))
            .perform(typeText(username), closeSoftKeyboard())

        onView(withId(R.id.passwordTextView))
            .perform(typeText("LaMIaPassWOrd"), closeSoftKeyboard())

        onView(withId(R.id.loginButton))
            .perform(click())

        onView(withId(R.id.nameTxt))
            .check(matches(withText(username)))

    }

    @Test
    fun verifyEmailDetail(){

        // TODO navigate to the detail view, inside "il mio profilo", and check the shown mail is "m.rossi@reply.it"

    }

    @Test
    fun verifyBirthPlace(){

        // TODO navigate to the detail view, inside "il mio profilo", and check the birth place is "Torino"

    }

   @Test
   fun verifyLoginCredentialRetain(){

       // TODO check that by pressing logout the credentials are kept

   }

}