package br.com.redcode.testeliciousapplication.robot

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import br.com.redcode.testeliciousapplication.R
import org.hamcrest.Matchers

class MrRobot(private val rule: ActivityTestRule<*>) : Actions {

    private lateinit var text: String

    override fun inputText(text: String): MrRobot {
        this.text = text

        Espresso.onView(ViewMatchers.withId(R.id.editText)).run {
            perform(ViewActions.clearText(), ViewActions.typeText(text))
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(ViewMatchers.withText(text)))
        }
        return this
    }

    override fun callToAction(): MrRobot {
        Espresso.onView(ViewMatchers.withId(R.id.button)).run {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            perform(ViewActions.click())
        }
        return this
    }

    override infix fun finalize(code: ResultMrRobot.() -> Unit): ResultMrRobot {
        Thread.currentThread()

        Thread.sleep(500)

        Espresso.onView(ViewMatchers.withText(text))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(rule.activity.window.decorView)))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        return ResultMrRobot().apply { code() }
    }

}