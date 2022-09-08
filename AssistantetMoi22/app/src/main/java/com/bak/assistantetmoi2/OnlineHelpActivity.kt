package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bak.assistantetmoi2.R
import com.bak.assistantetmoi2.MainActivity

class OnlineHelpActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var boutonRegisterBackUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_help)

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