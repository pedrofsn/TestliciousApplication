package br.com.redcode.testeliciousapplication.robot

import android.app.Activity
import androidx.test.core.app.ActivityScenario

/*
    CREATED BY @PEDROFSN IN 04/09/20 10:59
*/

inline fun main(rule: ActivityScenario<*>, code: MrRobot.() -> Unit): MrRobot {
    return MrRobot(scenario = rule).apply { code() }
}

fun Actions.withActivity(block: Activity.() -> Unit) {
    scenario.onActivity { block.invoke(it) }
}