package com.example.androidbookadress

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddToList : AppCompatActivity() {

    private lateinit var firstName:EditText
    private lateinit var secondName:EditText
    private lateinit var adress:EditText
    private lateinit var numPhone:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_to_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstName = findViewById(R.id.firstNameET)
        secondName = findViewById(R.id.secondNameET)
        adress = findViewById(R.id.adressET)
        numPhone = findViewById(R.id.numPhoneET)
    }

    fun save(view: View) {
        val person = Person(
            firstName.text.toString(),
            secondName.text.toString(),
            adress.text.toString(),
            numPhone.text.toString()
        )
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(
            this,
            "${person.firstName}\n" +
                    "${person.secondName}\n" +
                    "${person.adress}\n" +
                    "${person.numPhone}",
            Toast.LENGTH_SHORT
        ).show()
        intent.putExtra("Person", person)
        setResult(RESULT_OK)
        finish()
    }
    fun returnToMain(view: View) {
        setResult(RESULT_CANCELED)
        finish()
    }
}