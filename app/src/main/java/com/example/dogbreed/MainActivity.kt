package com.example.dogbreed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = mAuth.currentUser

        if(user != null){
            tv_userInfo.text = "Hello: " + user.uid!!.toString()
        } else {
            startActivity(Intent(this, Login::class.java))
        }

        btn_test.setOnClickListener {
            signOut()
        }
    }

    private fun signOut(){
        mAuth.signOut()
        Toast.makeText(this, "Signed out", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, Login::class.java))
    }
}
