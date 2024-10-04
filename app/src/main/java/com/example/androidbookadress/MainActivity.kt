package com.example.androidbookadress

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var person: Person? = null
    private var listPerson = arrayListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun exit(view: View) {
        finish()
    }

    fun addToList(view: View) {
        val intent = Intent(this, AddToList::class.java)
        launchSomeActivity.launch(intent)
    }

    fun openList(view: View) {
        if (listPerson.size != 0) {
            val intent = Intent(this, OpenList::class.java)
            intent.putExtra("listPerson", listPerson)
            startActivity(intent)
        }else {
            Toast.makeText(
                this,
                "Ошибка, лист пустой.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == RESULT_OK) {
            //val person = intent.extras?.getSerializable(Person::class.java.simpleName) as Person

            person = result.data?.getParcelableExtra("Person") as Person?
            //listPerson.add(person!!)
            Toast.makeText(
                this,
                "${person?.firstName}\n" +
                        "${person?.secondName}\n" +
                        "${person?.adress}\n" +
                        "${person?.numPhone}",
                Toast.LENGTH_SHORT
            ).show()
            Toast.makeText(
                this,
                "Успешно.",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                this,
                "Данные не добавлены.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}