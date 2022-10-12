package com.aravind.lloyds.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aravind.lloyds.model.ApiResponse
import com.aravind.lloyds.model.Item
import com.aravind.lloyds.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class RetroRepository @Inject constructor(private val retroService: RetroService) {

    fun makeApiCall(query: String, liveData: MutableLiveData<List<Item>>) {
        val call: Call<ApiResponse> = retroService.fetchDataFromApi(query)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveData.postValue(response.body()?.items!!)
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("Error!", "onFailure:" + t.localizedMessage)
                liveData.postValue(null)
            }
        })
    }
}