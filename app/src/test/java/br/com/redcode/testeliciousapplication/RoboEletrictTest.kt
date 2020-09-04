package br.com.redcode.testeliciousapplication

import android.os.Build
import androidx.test.core.app.ActivityScenario
import br.com.redcode.testeliciousapplication.robot.main
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class RoboEletrictTest {

    private lateinit var activity: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        activity = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun `test my app`() {
        main(activity) {
            inputText(text = "Hello World!")
            callToAction()
            showMessage()
        }
    }

}