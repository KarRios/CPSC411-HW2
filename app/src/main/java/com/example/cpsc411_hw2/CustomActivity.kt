package com.example.cpsc411_hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class CustomActivity : AppCompatActivity() {
    lateinit var cList: MutableList<Claim>
    lateinit var cService: ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        //
        val claimView: EditText = findViewById(R.id.claim)
        val dateView: EditText = findViewById(R.id.date)
        val bView: Button = findViewById(R.id.add_btn)
        val statusView : TextView = findViewById(R.id.statusMsg)

        bView.setOnClickListener {
            var packClaim = Claim(claimView.text.toString(), dateView.text.toString())
            cService.addClaim(packClaim)
            claimView.text.clear()
            dateView.text.clear()
            statusView.text = "Status Message: Claim Added"
        }
        cService = ClaimService(this)
        cService.getAll()
    }
}