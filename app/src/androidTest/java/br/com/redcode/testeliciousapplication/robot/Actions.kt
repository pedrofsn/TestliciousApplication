package br.com.redcode.testeliciousapplication.robot

interface Actions {

    fun inputText(text: String): MrRobot
    fun callToAction(): MrRobot
    fun showToast(text: String): ResultMrRobot

}