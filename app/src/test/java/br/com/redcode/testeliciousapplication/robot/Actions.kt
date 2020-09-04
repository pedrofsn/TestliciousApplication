package br.com.redcode.testeliciousapplication.robot

import androidx.test.core.app.ActivityScenario

interface Actions {

    val scenario: ActivityScenario<*>

    fun inputText(text: String)
    fun callToAction()
    fun showMessage()

}