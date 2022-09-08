package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bak.assistantetmoi2.OnlineHelpActivity
import com.bak.assistantetmoi2.R
import com.bak.assistantetmoi2.RegisterHelperActivity
import com.bak.assistantetmoi2.RegisterUserActivity
import com.bak.assistantetmoi2.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var boutonRegisterUSer : Button

    //Declaration de mon bouton
    lateinit var boutonRegisterHelper : Button

    //Declaration de mon bouton
    lateinit var boutonOnlineHelp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //injecter le fragment dans notre boite (fragment_container)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()

        //initialisation
        boutonRegisterUSer = findViewById(R.id.buttonUsager)

        // creation de notre intent
        val monIntentUser : Intent =  Intent(this,RegisterUserActivity::class.java)

        //clic sur le bouton
        boutonRegisterUSer.setOnClickListener {
            startActivity(monIntentUser)
        }

        //initialisation
        boutonRegisterHelper = findViewById(R.id.buttonAssistant)

        // creation de notre intent
        val monIntentHelper : Intent =  Intent(this,RegisterHelperActivity::class.java)

        //clic sur le bouton
        boutonRegisterHelper.setOnClickListener {
            startActivity(monIntentHelper)
        }

        //initialisation
        boutonOnlineHelp = findViewById(R.id.buttonAideEnLigne)

        // creation de notre intent
        val monIntentOnlineHelp : Intent =  Intent(this,OnlineHelpActivity::class.java)

        //clic sur le bouton
        boutonOnlineHelp.setOnClickListener {
            startActivity(monIntentOnlineHelp)
        }
    }
}