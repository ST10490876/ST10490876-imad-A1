package za.co.varsitycollege.st10490876

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Variables
        val resetButton = findViewById<Button>(R.id.resetButton)
        val editTextView = findViewById<EditText>(R.id.editTextText)
        val accButton = findViewById<Button>(R.id.AccButton)
        val textView2 = findViewById<TextView>(R.id.textView2)


        //when the text is correct the button reacts
        accButton?.setOnClickListener {

            when {
                //responds for correct input text
                editTextView.text.toString() == "Morning" -> textView2.text =
                    "eggs and toast with coffee"

                editTextView.text.toString() == "Mid Morning" -> textView2.text =
                    "Fruit and vegetable"

                editTextView.text.toString() == "Afternoon" -> textView2.text = "Sandwich and water"
                editTextView.text.toString() == "Mid Afternoon" -> textView2.text =
                    "Water and bread"

                editTextView.text.toString() == "Dinner" -> textView2.text = "Chicken and rice"
                //incorrect text response
                else -> Toast.makeText(this, "Incorrect input", Toast.LENGTH_LONG).show()
            }


            //button Response
            resetButton?.setOnClickListener {
                editTextView.text.clear()
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}