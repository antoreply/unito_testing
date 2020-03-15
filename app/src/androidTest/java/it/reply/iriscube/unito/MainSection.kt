package it.reply.iriscube.unito

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


private const val BASIC_SAMPLE_PACKAGE = "it.reply.iriscube.unito"
private const val LAUNCH_TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
class MainSection {

    lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen(){
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        ViewMatchers.assertThat(launcherPackage, CoreMatchers.notNullValue())
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

    // TODO goto MainSection

    @Test
    fun checkProfileLabel(){
        // TODO Verify the first textview content
    }

    @Test
    fun checkCompanyLabel() {
        // TODO Verify the second textview content
    }

    @Test
    fun checkAddressbookLabel() {
        // TODO Verify the third textview content
    }
}