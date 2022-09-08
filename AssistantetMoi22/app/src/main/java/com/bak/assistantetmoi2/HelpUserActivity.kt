package com.bak.assistantetmoi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bak.assistantetmoi2.R
import com.bak.assistantetmoi2.fragments.HomeFragment
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions

class HelpUserActivity : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var boutonRegisterBackUser : Button

    lateinit var boutonMesAppels : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_user)

        //injecter le fragment dans notre boite (fragment_container)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_containerHelper, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()

        //initialisation
        boutonRegisterBackUser = findViewById(R.id.back_button)
        boutonMesAppels = findViewById(R.id.buttonHistory)

        // creation de notre intent
        val monIntentUserOneBack : Intent =  Intent(this,RegisterTwoUserActivity::class.java)
        val monIntentCallHistory : Intent = Intent(this, HistorytActivity::class.java)

        //clic sur le bouton
        boutonRegisterBackUser.setOnClickListener {
            startActivity(monIntentUserOneBack)
        }

        boutonMesAppels.setOnClickListener{startActivity(monIntentCallHistory)}
    }

    fun onButtonClick(view: View?) {
        val text="Aide Assistant et Moi"
        if (text.isNotEmpty()){
            val options= JitsiMeetConferenceOptions.Builder()
                .setRoom(text)
                .setFeatureFlag("pip.enabled",false)
                .setFeatureFlag("live-streaming.enabled",false)
                .setFeatureFlag("video-share.enabled",false)
                .setFeatureFlag("chat.enabled",false)
                .setFeatureFlag("invite.enabled",false)
                .setFeatureFlag("raise-hand.enabled",false)
                .setFeatureFlag("tile-view.enabled", false)
                .setFeatureFlag("help.enabled", false)
                .setFeatureFlag("meeting-password.enabled",false)
                .setFeatureFlag("call-integration.enabled",false)
                .setFeatureFlag("add-people.enabled", false)
                .setFeatureFlag("overflow-menu.enabled",false)
                .build()
            JitsiMeetActivity.launch(this,options)
        }
    }
}