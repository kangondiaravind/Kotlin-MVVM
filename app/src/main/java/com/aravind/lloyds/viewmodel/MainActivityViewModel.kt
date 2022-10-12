package com.aravind.lloyds.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aravind.lloyds.model.Item
import com.aravind.lloyds.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Main activity view model
 *
 * Create Main activity view model
 */

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val retroRepository: RetroRepository) :
    ViewModel() {

    lateinit var apiResponseLiveData: MutableLiveData<List<Item>>

    init {
        apiResponseLiveData = MutableLiveData()
    }

    /**
     * Get recyler list observer
     *
     * @return
     */
    fun getRecylerListObserver(): MutableLiveData<List<Item>> {
        return apiResponseLiveData
    }

    fun loadListofData() {
        val QUERY_PARAM = "India"
        retroRepository.makeApiCall(QUERY_PARAM, apiResponseLiveData)
    }
}