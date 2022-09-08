package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterUserActivity : AppCompatActivity() {

    //Declaration de mes variables pour le required
    private lateinit var nameUser : EditText
    private lateinit var usernameUser : EditText
    private lateinit var adressUser : EditText
    private lateinit var birthdateUser : EditText

    //Declaration de mon bouton
    lateinit var boutonRegisterTwoUSer : Button

    //Declaration de mon bouton
    lateinit var boutonRegisterBackUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        //initialisation required
        nameUser = findViewById(R.id.input_register_name)
        usernameUser = findViewById(R.id.input_register_username)
        adressUser = findViewById(R.id.input_register_adress)
        birthdateUser = findViewById(R.id.input_register_birthdate)

        //initialisation
        boutonRegisterTwoUSer = findViewById(R.id.buttonValideOneUser)

        // creation de notre intent
        val monIntentUserOne : Intent =  Intent(this,RegisterTwoUserActivity::class.java)

        //clic sur le bouton
        boutonRegisterTwoUSer.setOnClickListener {

            val name = nameUser.text.toString().trim()
            val username = usernameUser.text.toString().trim()
            val adress = adressUser.text.toString().trim()
            val birthdate = birthdateUser.text.toString().trim()

            if (name.isEmpty()){
                nameUser.error = "Nom obligatoire"
                return@setOnClickListener
            }
            else if (username.isEmpty()){
                usernameUser.error = "Prénom obligatoire"
                return@setOnClickListener
            }
            else if (adress.isEmpty()){
                adressUser.error = "Adresse obligatoire"
                return@setOnClickListener
            }
            else if (birthdate.isEmpty()){
                birthdateUser.error = "Date de naissance obligatoire"
                return@setOnClickListener
            }
            else{
                Toast.makeText(this,"Validation effectuée",Toast.LENGTH_SHORT).show()
                startActivity(monIntentUserOne)
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