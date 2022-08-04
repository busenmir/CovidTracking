package com.example.covidapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.covidapp.databinding.ActivityMainBinding
import com.example.covidapp.databinding.FragmentHomeBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = resources.getString(R.string.app_name)

        LoadLanguage()

        binding.Language.setOnClickListener {
            ShowLanguageDialog()
        }
    }

    private fun ShowLanguageDialog() {

        val ListItems = arrayOf("English", "Türkçe")
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Dil Seçiniz")
        builder.setItems(ListItems) { dialog, which ->

            when (which) {
                0 -> {
                    SetLocale("en")
                    recreate()
                }
                1 -> {
                    SetLocale("tr")
                    recreate()
                }
            }
            dialog.dismiss()
        }
        val mDialog: AlertDialog = builder.create()
        mDialog.show()
    }

    private fun SetLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        config.setLocale(locale)

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor: SharedPreferences.Editor =
            getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }

    private fun LoadLanguage() {
        val pref: SharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language: String? = pref.getString("My_Lang", "")
        SetLocale(language!!)
    }
}