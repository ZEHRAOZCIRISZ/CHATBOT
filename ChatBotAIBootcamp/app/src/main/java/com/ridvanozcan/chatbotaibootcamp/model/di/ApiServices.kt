package com.ridvanozcan.chatbotaibootcamp.model.di
import com.ridvanozcan.chatbotaibootcamp.model.ChatGptRequestModel
import com.ridvanozcan.chatbotaibootcamp.model.ChatGptResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiServices {

    @Headers("Content-Type: application/json")
    @POST("/v1/chat/completions")
    suspend fun createMessage(@Header("Authorization") apiKey: String, @Body requestBody: ChatGptRequestModel) : Response<ChatGptResponseModel>
}