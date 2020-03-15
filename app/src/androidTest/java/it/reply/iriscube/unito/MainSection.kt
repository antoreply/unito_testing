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

    private fun doLogin(){
        // Type text and then press the button.
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "userNameTextView")).setText("Test")
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "passwordTextView")).setText("123456789")
        //device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "loginButton")).click();

        val entraButton: UiObject = device.findObject(
            UiSelector().text("ENTRA").className("android.widget.Button")
        )

        // Simulate a user-click on the OK button, if found.
        if (entraButton.exists() && entraButton.isEnabled) {
            entraButton.click()
        }
    }

    private fun gotoUserList() {
        device.findObject(By.res(BASIC_SAMPLE_PACKAGE, "nextIcn")).click()
    }

    @Test
    fun checkProfileLabel(){
        doLogin()
        gotoUserList()

        val textview = device.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "profileTxt")),500)
        ViewMatchers.assertThat(
            textview.getText(),
            CoreMatchers.equalTo("Il mio profilo")
        )

    }

    @Test
    fun checkCompanyLabel() {
        doLogin()
        gotoUserList()

        val textview =
            device.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "companyTxt")), 500)
        ViewMatchers.assertThat(
            textview.getText(),
            CoreMatchers.equalTo("La mia azienda")
        )

    }

    @Test
    fun checkAddressbookLabel() {
        doLogin()
        gotoUserList()

        val appViews1 = UiScrollable(UiSelector().scrollable(true))
        appViews1.scrollForward();

        val textview = device.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "addressbookTxt")), 500)

        ViewMatchers.assertThat(
            textview.getText(),
            CoreMatchers.equalTo("La mia rubrica")
        )

    }
}