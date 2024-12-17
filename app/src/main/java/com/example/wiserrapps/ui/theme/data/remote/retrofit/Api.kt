package com.example.wiserrapps.ui.theme.data.remote.retrofit

import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponse
import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponseItem
import retrofit2.http.GET

interface Api {
    @GET("articles")
    suspend fun getArticleList(): List<ArticlessResponseItem>

    companion object {
        const val BASE_URL = "https://5jzvkzbp-5000.asse.devtunnels.ms/api/"
    }
}
