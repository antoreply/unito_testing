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
    fun verifyFieldValidation() {
        onView(withId(R.id.userNameTextView))
            .check(matches(withText("")))
        onView(withId(R.id.passwordTextView))
            .check(matches(withText("")))
    }

    @Test
    fun verifyErrorLabelsDisplayed(){
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

        gotoDetails()

        onView(withId(R.id.profileEmailTxt))
            .check(matches(withText("m.rossi@reply.it")))

    }

    @Test
    fun verifyBirthPlace(){

        gotoDetails()

        onView((withId(R.id.profileBornCityTxt)))
            .check(matches(withText("Torino")))

    }

   @Test
   fun verifyLoginCredentialRetain(){

       val username = "myPublicUsername"

       onView(withId(R.id.userNameTextView))
           .perform(typeText(username), closeSoftKeyboard())
       onView((withId(R.id.passwordTextView)))
           .perform(typeText("test"), closeSoftKeyboard())

       onView(withId(R.id.loginButton))
           .perform(click())
       onView(withId(R.id.logoutIcn))
           .perform(click())

       onView(withId(R.id.userNameTextView))
           .check(matches(withText(username)))

   }

    private fun gotoDetails(){
        onView(withId(R.id.userNameTextView))
            .perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView))
            .perform(typeText("test"), closeSoftKeyboard())

        onView(withId(R.id.loginButton))
            .perform(click())
        onView(withId(R.id.nextIcn))
            .perform(click())
        onView(withId(R.id.profileContainer))
            .perform(click())
    }

}