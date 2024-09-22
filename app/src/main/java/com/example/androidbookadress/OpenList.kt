package com.example.androidbookadress

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OpenList : AppCompatActivity() {

    private var persons = arrayListOf<Person>()
    private var adapter: ArrayAdapter<Person>? = null
    private lateinit var listLV:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_open_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listLV = findViewById(R.id.listPerson)
        persons = intent.getParcelableArrayListExtra("listPerson", Person::class.java)!!
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons)

    }

    fun returnToMain(view: View) {
        finish()
    }

}