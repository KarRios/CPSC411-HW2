package com.example.cpsc411_hw2

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class ClaimService (private val ctx : CustomActivity){
    lateinit var claimList : MutableList<Claim>

    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            // JSON string
            if (responseBody != null) {
                val gson = Gson()
                val claimListType: Type = object : TypeToken<List<Claim>>() {}.type
                claimList = gson.fromJson(String(responseBody), claimListType)

                Log.d("Claim Service", "The Claim List: $claimList")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("Claim Service", "Error getting claim list")
        }
    }
    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Claim service response: ${respStr}")
            }
        }

        override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
        ) {
            Log.d("Claim Service", "Error from ClaimService.kt")
        }

    }

    fun addClaim(cObj : Claim) {
        // creates AsyncHttp client
        val client = AsyncHttpClient()

        // my personal IP address
        val requestUrl = "http://192.168.1.11:8080/ClaimService/add"

        // convert from Claim object to JSON string
        val claimJsonString = Gson().toJson(cObj)
        val entity = StringEntity(claimJsonString)

        // POST JSON string to server
        client.post(ctx, requestUrl, entity, "application/json", addServiceRespHandler())
    }

    fun getAll()  {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.11:8080/ClaimService/getAll"
        //
        Log.d("Claim Service", "About Sending the HTTP Request. ")
        //
        client.get(requestUrl, GetAllServiceRespHandler())
    }
}
}