package br.com.redcode.testeliciousapplication.robot

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import br.com.redcode.testeliciousapplication.R
import org.robolectric.shadows.ShadowToast


class MrRobot(override val scenario: ActivityScenario<*>) : Actions {

    private lateinit var text: String

    override fun inputText(text: String) {
        this.text = text

        withActivity {
            findViewById<EditText>(R.id.editText).run {
                assert(View.VISIBLE == visibility)

                setText(text)
                val input = editableText.toString()

                assert(text == input)
            }
        }
    }

    override fun callToAction() {
        withActivity {
            findViewById<Button>(R.id.button).run {
                assert(View.VISIBLE == visibility)
                assert(performClick())
            }
        }
    }

    override fun showMessage() {
        assert(ShadowToast.getTextOfLatestToast() == text)
    }

}