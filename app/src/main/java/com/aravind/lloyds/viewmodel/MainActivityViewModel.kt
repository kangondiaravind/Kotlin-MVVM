package com.aravind.lloyds.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aravind.lloyds.model.ApiResponse
import com.aravind.lloyds.network.RetroService
import com.aravind.lloyds.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Main activity view model
 *
 * Create Main activity view model
 */
class MainActivityViewModel : ViewModel() {

    private var apiResponseLiveData: MutableLiveData<ApiResponse>

    init {
        apiResponseLiveData = MutableLiveData()
    }

    /**
     * Make api call
     *
     */
    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroService =
                RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
            val response = retroService.fetchDataFromApi("india")
            Log.d("LOG", response.toString())
            apiResponseLiveData.postValue(response)
        }
    }

    /**
     * Get recyler list observer
     *
     * @return
     */
    fun getRecylerListObserver(): MutableLiveData<ApiResponse> {
        return apiResponseLiveData
    }
}