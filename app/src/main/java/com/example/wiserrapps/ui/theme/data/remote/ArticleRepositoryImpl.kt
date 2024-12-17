package com.example.wiserrapps.ui.theme.data.remote

import coil.network.HttpException
import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponseItem

import com.example.wiserrapps.ui.theme.data.remote.retrofit.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
class ArticleRepositoryImpl(
    private val api: Api
) : ArticleRepository {
    override suspend fun getArticleList(): Flow<Result<List<ArticlessResponseItem>>> {
        return flow {
            try {
                val articles = api.getArticleList()
                emit(Result.Success(articles))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Network error"))
                println("IOException: ${e.message}")
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "HTTP error"))
                println("HttpException: ${e.message}")
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Unknown error"))
                println("Exception: ${e.message}")
                return@flow
            }
        }
    }
}
