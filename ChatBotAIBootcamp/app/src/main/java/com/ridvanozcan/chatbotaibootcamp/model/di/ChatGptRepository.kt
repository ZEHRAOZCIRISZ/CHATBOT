package com.ridvanozcan.chatbotaibootcamp.model.di

import com.ridvanozcan.chatbotaibootcamp.model.ChatGptRequestModel
import com.ridvanozcan.chatbotaibootcamp.model.ChatGptResponseModel
import retrofit2.Response
import javax.inject.Inject


class ChatGptRepository @Inject constructor(private val apiServices: ApiServices) {
    suspend fun createMessage(apiKey:String, requestBody:ChatGptRequestModel):Response<ChatGptResponseModel> = apiServices.createMessage(apiKey, requestBody)
}