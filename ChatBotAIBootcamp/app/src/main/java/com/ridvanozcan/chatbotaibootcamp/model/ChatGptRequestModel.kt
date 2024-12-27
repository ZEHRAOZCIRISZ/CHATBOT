package com.ridvanozcan.chatbotaibootcamp.model

import com.google.gson.annotations.SerializedName

data class ChatGptRequestModel(
    val model: String,
    val messages: List<com.ridvanozcan.chatbotaibootcamp.model.Message>,
    @SerializedName("max_tokens")
    val maxTokens:Int
)

data class Message(
    val role:String,
    val content:String
)