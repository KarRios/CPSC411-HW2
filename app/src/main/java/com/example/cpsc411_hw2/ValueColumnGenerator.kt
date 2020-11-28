package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(private val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.CYAN)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.bottomMargin = 5

        var value = EditText(ctx)
        value.id = R.id.claim
        value.hint = "Enter Claim Title"
        value.gravity = Gravity.CENTER_VERTICAL
        value.setBackgroundColor(Color.WHITE)
        value.setTextColor(Color.BLACK)
        layoutObj.addView(value, vParams)

        value = EditText(ctx)
        value.id = R.id.date
        value.hint = "Enter Date (MM/DD/YYYY)"
        value.gravity = Gravity.CENTER_VERTICAL
        value.setBackgroundColor(Color.WHITE)
        value.setTextColor(Color.BLACK)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}
