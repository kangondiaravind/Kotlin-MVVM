package com.aravind.lloyds.viewmodel

import com.aravind.lloyds.model.ApiResponse
import com.aravind.lloyds.model.Item
import com.aravind.lloyds.network.RetroService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit

@RunWith(JUnit4::class)
class MainActivityViewModelTest {

    lateinit var mainViewModel: MainActivityViewModel

    @Mock
    lateinit var retrofit: Retrofit

    @Mock
    lateinit var apiService: RetroService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    suspend fun makeApiCallTest() {
        mainViewModel = MainActivityViewModel()
        val list = ArrayList<Item>()

        val response = ApiResponse(list)
        if (retrofit != null) {

            if (apiService != null) {
                Mockito.`when`(apiService.fetchDataFromApi("India")).thenReturn(response)
            }
        }
        val apiResponse = mainViewModel.getRecylerListObserver()

        Assert.assertEquals("true", "Aravind", apiResponse.value?.items?.get(0)?.name)
        Assert.assertEquals("true", "description", apiResponse.value?.items?.get(0)?.description)
        Assert.assertEquals("true", "www.api.github.com", apiResponse.value?.items?.get(0)?.owner?.avatar_url)
    }
}