package com.example.wiserrapps.ui.theme.data.remote

import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponseItem
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getArticleList(): Flow<Result<List<ArticlessResponseItem>>>
}