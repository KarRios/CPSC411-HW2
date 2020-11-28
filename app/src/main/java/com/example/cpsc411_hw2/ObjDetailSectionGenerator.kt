package com.example.cpsc411_hw2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

class ObjDetailSectionGenerator(private val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        layoutObj = LinearLayout(ctx)

        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val lcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT)

        val colGenerator = LabelColumnGenerator(ctx)
        var lblView = colGenerator.generate()
        lcParams.weight = 1.0F
        layoutObj.addView(lblView, lcParams)

        val valGenerator = ValueColumnGenerator(ctx)
        val vcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblView = valGenerator.generate()
        vcParams.marginStart = 5
        vcParams.weight = 3.0F
        layoutObj.addView(lblView, vcParams)

        return layoutObj
    }
}