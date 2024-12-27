package com.ridvanozcan.chatbotaibootcamp.model
import com.google.gson.annotations.SerializedName

data class ChatGptResponseModel (
    val id: String,
    @SerializedName("object")
    val objectType: String,
    val created: Long,
    val model: String,
    val choices: List<Choices>,
    val usage: Usage
)

data class Choices(
    val index: Int,
    val message: Message,
    @SerializedName("finish_reason")
    val finish_reason: String
)

data class Usage(
    @SerializedName("prompt_token")
    val prompt_token: Int,
    @SerializedName("completion_tken")
    val completion_token: Int,
    @SerializedName("total_tokens")
    val total_tokens: Int
)