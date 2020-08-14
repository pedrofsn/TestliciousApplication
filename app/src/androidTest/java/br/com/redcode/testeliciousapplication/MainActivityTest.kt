package br.com.redcode.testeliciousapplication


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private val string = "Hello World!"

    @Test
    fun verifyInputtedValueInEditText() {
        onView(withId(R.id.editText)).run {
            perform(ViewActions.clearText(), ViewActions.typeText(string))
            check(matches(isDisplayed()))
            check(matches(withText(string)))
        }
    }

    @Test
    fun verifyClick() {
        verifyInputtedValueInEditText()

        onView(withId(R.id.button)).run {
            check(matches(isDisplayed()))
            perform(ViewActions.click())
        }
    }

    @Test
    fun verifyToast() {
        verifyClick()

        Thread.currentThread()
        try {
            Thread.sleep(500)

            onView(withText(string))
                .inRoot(withDecorView(`is`(mActivityTestRule.activity.window.decorView)))
                .check(matches(isDisplayed()))

        } catch (ex: InterruptedException) {

        }
    }

}
