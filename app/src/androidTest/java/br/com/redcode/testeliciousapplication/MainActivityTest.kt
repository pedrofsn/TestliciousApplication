package br.com.redcode.testeliciousapplication


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.redcode.testeliciousapplication.robot.MrRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testMyApp() {
        val robot = MrRobot(rule = mActivityTestRule)
        val text = "Hello World!"

        robot.inputText(text = text)
            .callToAction()
            .showToast(text = text)
            .isSuccess()
    }

}