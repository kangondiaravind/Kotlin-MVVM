package com.aravind.lloyds.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit instance
 *
 * @constructor Create Retrofit instance
 */
class RetrofitInstance {

    companion object {

        private val BASEURL: String = "https://api.github.com/search/"

        /**
         * Get retrofit instance
         *
         * @return Retrofit
         */
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}