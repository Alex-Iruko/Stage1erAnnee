package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterTwoUserActivity : AppCompatActivity() {

    //Declaration de mes variables pour le required
    private lateinit var iDUser : EditText
    private lateinit var passwordUser : EditText
    private lateinit var confirmPasswordUser : EditText


    //Declaration de mon bouton
    lateinit var boutonRegisterBackUser : Button

    //Declaration de mon bouton
    lateinit var boutonHelpUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_two_user)

        //initialisation required
        iDUser = findViewById(R.id.input_register_ID)
        passwordUser = findViewById(R.id.input_register_password)
        confirmPasswordUser = findViewById(R.id.input_register_confirm_password)

        //initialisation
        boutonRegisterBackUser = findViewById(R.id.back_button)

        // creation de notre intent
        val monIntentUserOneBack : Intent =  Intent(this,RegisterUserActivity::class.java)

        //clic sur le bouton
        boutonRegisterBackUser.setOnClickListener {
            startActivity(monIntentUserOneBack)
        }

        //initialisation
        boutonHelpUser = findViewById(R.id.buttonValideTwoUser)

        // creation de notre intent
        val monIntentHelpUSer : Intent =  Intent(this,HelpUserActivity::class.java)

        //clic sur le bouton
        boutonHelpUser.setOnClickListener {

            val id = iDUser.text.toString().trim()
            val password = passwordUser.text.toString().trim()
            val confirmPassword = confirmPasswordUser.text.toString().trim()

            if (id.isEmpty()){
                iDUser.error = "Identifiant obligatoire"
                return@setOnClickListener
            }
            else if (password.isEmpty()){
                passwordUser.error = "Mot de passe obligatoire"
                return@setOnClickListener
            }
            else if (confirmPassword.isEmpty()){
                confirmPasswordUser.error = "Confirmation du mot de passe obligatoire"
                return@setOnClickListener
            }
            else {
                Toast.makeText(this, "Validation effectuée", Toast.LENGTH_SHORT).show()
                startActivity(monIntentHelpUSer)
            }
        }
    }
}