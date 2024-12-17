package com.example.wiserrapps.ui.theme.data.remote.response

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wiserrapps.ui.theme.data.remote.ArticleRepository
import com.example.wiserrapps.ui.theme.data.remote.Result
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val articleRepository: ArticleRepository
): ViewModel() {

    private val _articles = MutableStateFlow<List<ArticlessResponseItem>>(emptyList())
    val articles = _articles.asStateFlow()

    private val _showErorToastChannel = Channel<Boolean> ()
    val showErorToastChannel = _showErorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            articleRepository.getArticleList().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErorToastChannel.send(true)
                        println("Error fetching articles: ${result.exception?.message}")
                    }
                    is Result.Success -> {
                        result.data?.let { articlesList ->
                            println("Fetched articles: $articlesList")
                            _articles.update { articlesList }
                        }
                    }
                }
            }
        }
    }
}