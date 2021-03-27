package it.reply.iriscube.unito

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.reply.iriscube.unito.activity.ProfileActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileActivityTest {

    /**
     * Check if the values shown are what you expected
     */
    @Test
    fun verifyNoEmptyFields(){
        ActivityScenario.launch(ProfileActivity::class.java)

        onView(withId(R.id.profileNameTxt))
            .check(matches(withText("Mario")))

        onView(withId(R.id.profileSurnameTxt))
            .check(matches(withText("Rossi")))

        onView(withId(R.id.profileEmailTxt))
            .check(matches(withText("m.rossi@reply.it")))

    }

    /**
     * Check that the profileBornCityTxt is visible
     */
    @Test
    fun verifyBirthPlaceDisplayed(){
        ActivityScenario.launch(ProfileActivity::class.java)

        onView(withId(R.id.profileBornCityTxt))
            .check(matches(isDisplayed()))

    }

}