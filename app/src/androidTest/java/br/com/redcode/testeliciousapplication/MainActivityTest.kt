package br.com.redcode.testeliciousapplication


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.redcode.testeliciousapplication.robot.main
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
        main(mActivityTestRule) {
            inputText(text = "Hello World!")
            callToAction()
        } finalize {
            isSuccess()
        }
    }

}