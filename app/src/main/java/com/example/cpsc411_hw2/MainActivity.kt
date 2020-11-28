package com.example.cpsc411_hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson

import com.example.cpsc411_hw2.ClaimService
import java.lang.Boolean.TRUE
import kotlin.concurrent.thread

class MainActivity() : AppCompatActivity() {

    lateinit var claimServ: ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addButtonClicked(view: View){
        // Fired upon button click
        val inputClaimTitle = findViewById<EditText>(R.id.editClaimTitle)
        val inputDate = findViewById<EditText>(R.id.editDate)

        claimServ = ClaimService(this)

        val readyClaim = Claim(inputClaimTitle.text.toString(), inputDate.text.toString())
        claimServ.addClaim(readyClaim)

        // Clear editText boxes
        inputClaimTitle.setText("")
        inputDate.setText("")
    }
    fun addSuccess(){
        claimServ = ClaimService(this)
        var outputStatus = findViewById<TextView>(R.id.statusMsgDisp)
        val inputClaimTitle = findViewById<EditText>(R.id.editClaimTitle)
        outputStatus.setText("Claim ${inputClaimTitle.text.toString()} was successfully created.")
    }

    fun addFail(){
        claimServ = ClaimService(this)
        var outputStatus = findViewById<TextView>(R.id.statusMsgDisp)
        val inputClaimTitle = findViewById<EditText>(R.id.editClaimTitle)
        outputStatus.setText("Claim ${inputClaimTitle.text.toString()} failed to be created.")
    }
}