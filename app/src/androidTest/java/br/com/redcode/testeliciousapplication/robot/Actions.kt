package br.com.redcode.testeliciousapplication.robot

interface Actions {

    fun inputText(text: String): MrRobot
    fun callToAction(): MrRobot
    fun finalize(code: ResultMrRobot.() -> Unit): ResultMrRobot

}