package com.example.fusha.translate

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface LibreApi {
    @FormUrlEncoded
    @POST("translate")
    fun translate(
        @Field("q") q: String,
        @Field("source") source: String,
        @Field("target") target: String,
        @Field("format") format: String = "text"
    ): Call<LibreResponse>
}
