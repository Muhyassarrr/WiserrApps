package com.example.wiserrapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wiserrapps.ui.theme.NewAppWiserrTheme
import com.example.wiserrapps.ui.theme.data.remote.ArticleRepositoryImpl
import com.example.wiserrapps.ui.theme.data.remote.RetrofitInstance
import com.example.wiserrapps.ui.theme.data.remote.response.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ArticleViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ArticleViewModel(ArticleRepositoryImpl(RetrofitInstance.api))
                        as T
            }
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewAppWiserrTheme {

                AppWiserr()
            }
        }
    }
}
