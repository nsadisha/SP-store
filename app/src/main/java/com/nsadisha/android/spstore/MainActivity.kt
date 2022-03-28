package com.nsadisha.android.spstore

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = getSharedPreferences("SP STORE", Context.MODE_PRIVATE)

        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val showBtn = findViewById<Button>(R.id.showBtn)

        val stringInput = findViewById<EditText>(R.id.stringInput)
        val boolInput = findViewById<Switch>(R.id.boolInput)

        saveBtn.setOnClickListener {
            val editPrefs = sharedPrefs.edit()

            editPrefs.putString("strValue",stringInput.text.toString().trim())
            editPrefs.putBoolean("boolValue", boolInput.isChecked)

            editPrefs.apply()
        }

        showBtn.setOnClickListener {
            stringInput.setText(sharedPrefs.getString("strValue",""))
            boolInput.isChecked = sharedPrefs.getBoolean("boolValue", false)
        }
    }
}