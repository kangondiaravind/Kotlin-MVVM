package com.aravind.lloyds.network

import com.aravind.lloyds.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retro service
 *
 * @constructor Create empty Retro service
 */
interface RetroService {

    /**
     * Fetch data from api
     * Url : https://api.github.com/search/repositories?q=india
     * @param query
     * @return
     */
    @GET("repositories")
    suspend fun fetchDataFromApi(@Query("q") query: String): ApiResponse
}