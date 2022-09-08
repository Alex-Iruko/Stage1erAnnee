package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterTwoHelperActivity : AppCompatActivity() {

    //Declaration de mes variables pour le required
    private lateinit var iDHelper : EditText
    private lateinit var passwordHelper : EditText
    private lateinit var confirmPasswordHelper : EditText


    //Declaration de mon bouton
    lateinit var boutonRegisterBackHelper : Button

    //Declaration de mon bouton
    lateinit var boutonHelpHelper : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_two_user)

        //initialisation required
        iDHelper = findViewById(R.id.input_register_ID)
        passwordHelper = findViewById(R.id.input_register_password)
        confirmPasswordHelper = findViewById(R.id.input_register_confirm_password)

        //initialisation
        boutonRegisterBackHelper = findViewById(R.id.back_button)

        // creation de notre intent
        val monIntentUserOneBack : Intent =  Intent(this,RegisterHelperActivity::class.java)

        //clic sur le bouton
        boutonRegisterBackHelper.setOnClickListener {
            startActivity(monIntentUserOneBack)
        }

        //initialisation
        boutonHelpHelper = findViewById(R.id.buttonValideTwoUser)

        // creation de notre intent
        val monIntentHelpUSer : Intent =  Intent(this,DisponibilityHelperActivity::class.java)

        //clic sur le bouton
        boutonHelpHelper.setOnClickListener {

            val id = iDHelper.text.toString().trim()
            val password = passwordHelper.text.toString().trim()
            val confirmPassword = confirmPasswordHelper.text.toString().trim()

            if (id.isEmpty()){
                iDHelper.error = "Identifiant obligatoire"
                return@setOnClickListener
            }
            else if (password.isEmpty()){
                passwordHelper.error = "Mot de passe obligatoire"
                return@setOnClickListener
            }
            else if (confirmPassword.isEmpty()){
                confirmPasswordHelper.error = "Confirmation du mot de passe obligatoire"
                return@setOnClickListener
            }
            else {
                Toast.makeText(this, "Validation effectuée", Toast.LENGTH_SHORT).show()
                startActivity(monIntentHelpUSer)
            }
        }
    }
}