package it.reply.iriscube.unito

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.reply.iriscube.unito.activity.LoginActivity
import it.reply.iriscube.unito.activity.ProfileActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileActivityTest {

    // TODO add the correct rule to launch the ProfileActivity before each test method

    /**
     * Check if the values shown are what you expected
     */
    @Test
    fun verifyNoEmptyFields(){

        // TODO (1) check that "Mario" is shown in the TextView with the profile name

        // TODO (2) check that "Rossi" is shown in the TextView with the profile surname

        // TODO (3) check that "m.rossi@reply.it" is shown in the TextView with the profile email

        // NOTE: see the LoginActivityTest as example

    }

    /**
     * Check that the profileBornCityTxt is visible
     */
    @Test
    fun verifyBirthPlaceDisplayed(){

        // TODO (4) check that the profileBornCityTxt is displayed
        // NOTE: use matches(isDisplayed())

    }

}