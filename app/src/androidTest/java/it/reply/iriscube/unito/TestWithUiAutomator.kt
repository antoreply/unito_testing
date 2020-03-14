package it.reply.iriscube.unito

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val BASIC_SAMPLE_PACKAGE = "it.reply.iriscube.unito"
private const val LAUNCH_TIMEOUT = 5000L
private const val USERNAME_TO_BE_TYPED = "Marco"

@RunWith(AndroidJUnit4::class)
class TestWithUiAutomator {

    lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen(){
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE).apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun testUserLogin(){
        // Type text and then press the button.
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "userNameTextView")).setText(USERNAME_TO_BE_TYPED)
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "passwordTextView")).setText("123456789")
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "loginButton")).click();

        // Verify the test is displayed in the Ui
        var changedText = device.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "nameTxt")),500)
        assertThat(changedText.getText(), equalTo(USERNAME_TO_BE_TYPED))
    }


}