package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LabelColumnGenerator(private val ctx : Context) {
    fun generate() : LinearLayout {

        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        lbParams.weight = 1.0F
        lbParams.leftMargin = 50
        var lbl = TextView(ctx)
        lbl.text = "Claim Title"
        lbl.gravity = Gravity.CENTER_VERTICAL
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTextColor(Color.BLACK)
        lbl.textSize = 16F
        layoutObj.addView(lbl, lbParams)

        lbl = TextView(ctx)
        lbl.text = "Date"
        lbl.gravity = Gravity.CENTER_VERTICAL
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTextColor(Color.BLACK)
        lbl.textSize = 16F
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }
}