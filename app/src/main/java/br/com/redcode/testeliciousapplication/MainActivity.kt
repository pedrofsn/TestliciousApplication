package br.com.redcode.testeliciousapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val input = getInputText()
            toast(input)
        }
    }

    private fun toast(input: String) {
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }

    private fun getInputText() = editText.text?.trim().toString()

}