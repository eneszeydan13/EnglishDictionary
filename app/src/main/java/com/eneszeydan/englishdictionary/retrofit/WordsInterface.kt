package com.eneszeydan.englishdictionary.retrofit

import com.eneszeydan.englishdictionary.model.Word
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WordsInterface {

    @GET("en/{word}")
    fun getWordInfo(@Path("word")word: String): Call<Word>

}