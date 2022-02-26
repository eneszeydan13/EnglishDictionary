package com.eneszeydan.englishdictionary.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://https://api.dictionaryapi.dev/api/v2/entries/"

        fun getWordsInterface():WordsInterface{
            return RetrofitClient.getClient(BASE_URL).create(WordsInterface::class.java)
        }
    }
}