package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // 1. Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        var lbl = TextView(ctx)
        lbl.text = "Please Enter Claim Information"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTextColor(Color.BLACK)
        lbl.textSize = 18F
        layoutObj.addView(lbl, lParams)


        // 2. Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        // 3. Add Next Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.CYAN)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.id = R.id.add_btn
        nButton.setBackgroundColor(Color.WHITE)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nbParams.leftMargin = 5
        nbParams.rightMargin =5
        nbParams.topMargin = 2
        nbParams.bottomMargin = 2
        nLayout.addView(nButton, nbParams)
        //
        layoutObj.addView(nLayout, nParams)

        //
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        lbParams.leftMargin = 50
        lbl = TextView(ctx)
        lbl.text = "Status Message: NONE"
        lbl.gravity = Gravity.LEFT
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTextColor(Color.BLACK)
        lbl.textSize = 16F
        lbl.id = R.id.statusMsg
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }

}