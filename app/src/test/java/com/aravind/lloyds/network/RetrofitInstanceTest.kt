/*
package com.aravind.lloyds.network

import okhttp3.ResponseBody
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import retrofit2.Call

class RetrofitInstanceTest {

    @Test
    fun `it should GET with query`() {

        val remoteApi = RetrofitInstance.getRetrofitInstance()

        val baseUrl = "http://some.api"
        val givenSearchQuery = "given search phrase"

        val call: Call<ResponseBody> = RetroService.fetchDataFromApi(givenSearchQuery)

        expectThat(call.request()) {
            assertThat("is GET method") {
                it.method() == "GET"
            }
            assertThat("has given search query") {
                it.url().queryParameterValues("search") == listOf(givenSearchQuery)
            }
        }
    }
}*/
