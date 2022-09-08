package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterHelperActivity : AppCompatActivity() {

    //Declaration de mes variables pour le required
    private lateinit var nameHelper : EditText
    private lateinit var usernameHelper : EditText
    private lateinit var adressHelper : EditText
    private lateinit var birthdateHelper : EditText

    //Declaration de mon bouton
    lateinit var boutonRegisterTwoHelper : Button

    //Declaration de mon bouton
    lateinit var boutonRegisterBackUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_helper)

        //initialisation required
        nameHelper = findViewById(R.id.input_register_name)
        usernameHelper = findViewById(R.id.input_register_username)
        adressHelper = findViewById(R.id.input_register_adress)
        birthdateHelper = findViewById(R.id.input_register_birthdate)

        //initialisation
        boutonRegisterTwoHelper = findViewById(R.id.buttonValideOneHelper)

        // creation de notre intent
        val monIntentUser : Intent =  Intent(this,RegisterTwoHelperActivity::class.java)

        //clic sur le bouton
        boutonRegisterTwoHelper.setOnClickListener {
            val name = nameHelper.text.toString().trim()
            val username = usernameHelper.text.toString().trim()
            val adress = adressHelper.text.toString().trim()
            val birthdate = birthdateHelper.text.toString().trim()

            if (name.isEmpty()){
                nameHelper.error = "Nom obligatoire"
                return@setOnClickListener
            }
            else if (username.isEmpty()){
                usernameHelper.error = "Prénom obligatoire"
                return@setOnClickListener
            }
            else if (adress.isEmpty()){
                adressHelper.error = "Adresse obligatoire"
                return@setOnClickListener
            }
            else if (birthdate.isEmpty()){
                birthdateHelper.error = "Date de naissance obligatoire"
                return@setOnClickListener
            }
            else {
                Toast.makeText(this, "Validation effectuée", Toast.LENGTH_SHORT).show()
                startActivity(monIntentUser)
            }
        }

        //initialisation
        boutonRegisterBackUser = findViewById(R.id.back_button)

        // creation de notre intent
        val monIntentUserOneBack : Intent =  Intent(this,MainActivity::class.java)

        //clic sur le bouton
        boutonRegisterBackUser.setOnClickListener {
            startActivity(monIntentUserOneBack)
        }

    }
}