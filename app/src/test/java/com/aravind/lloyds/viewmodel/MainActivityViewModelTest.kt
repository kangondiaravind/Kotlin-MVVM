package com.aravind.lloyds.viewmodel

import androidx.lifecycle.MutableLiveData
import com.aravind.lloyds.model.ApiResponse
import com.aravind.lloyds.model.Item
import com.aravind.lloyds.model.Owner
import com.aravind.lloyds.repository.RetroRepository
import com.aravind.lloyds.network.RetroService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.mock

class MainActivityViewModelTest {

    @Mock
    lateinit var repository: RetroRepository
    lateinit var viewModel: MainActivityViewModel
    lateinit var retroService: RetroService

    @Before
    fun setUp() {
        retroService = mock(RetroService::class.java)
        repository = RetroRepository(retroService)
        viewModel = MainActivityViewModel(repository)
    }

    @Test
    fun `testSuccessfulFetch`() {
        val list = ArrayList<Item>()
        val apidata = ApiResponse(list)
        val data = MutableLiveData<List<Item>>(
            listOf(Item("name", "desc", Owner("avatar1")))
        )
        Mockito.`when`(viewModel.getRecylerListObserver()).thenReturn(
            MutableLiveData<List<Item>>(
                listOf(Item("name", "desc", Owner("avatar1")))
            )
        )
        viewModel.loadListofData()

        viewModel.apiResponseLiveData.observeForever {
            assertEquals("true", data, apidata.items)
        }
    }

    @Test
    fun `testFailedFetch`() {
        val apidata = ApiResponse(emptyList())
        doNothing().`when`(apidata).items
        Mockito.`when`(viewModel.loadListofData()).thenReturn(null)
        viewModel.loadListofData()
        viewModel.apiResponseLiveData.observeForever {
            assertEquals("true", null, apidata.items)
        }
    }
}