package com.example.wiserrapps.ui.theme.data.remote.response

import com.google.gson.annotations.SerializedName

data class ArticlessResponse(

	@field:SerializedName("ArticlessResponse")
	val articlessResponse: List<ArticlessResponseItem>
)

data class ArticlessResponseItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("Desc")
	val desc: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)
