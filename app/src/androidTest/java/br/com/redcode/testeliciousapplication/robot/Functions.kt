package br.com.redcode.testeliciousapplication.robot

import androidx.test.rule.ActivityTestRule

/*
    CREATED BY @PEDROFSN IN 04/09/20 10:59
*/

inline fun main(rule: ActivityTestRule<*>, code: MrRobot.() -> Unit): MrRobot {
    return MrRobot(rule = rule).apply { code() }
}