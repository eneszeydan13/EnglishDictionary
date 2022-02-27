package com.eneszeydan.englishdictionary.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.eneszeydan.englishdictionary.model.Word
import com.eneszeydan.englishdictionary.retrofit.ApiUtils
import com.eneszeydan.englishdictionary.retrofit.WordsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WordDaoRepository {

    var wordObject : MutableLiveData<Word>
    var wdao : WordsInterface

    init{
        wordObject = MutableLiveData()
        wdao = ApiUtils.getWordsInterface()
    }

    fun getWord(): MutableLiveData<Word>{
        return wordObject
    }

    fun getWordInfo(key: String){
        wdao.getWordInfo(key).enqueue(object : Callback<Word>{
            override fun onResponse(call: Call<Word>?, response: Response<Word>) {
                val w = response.body()
                wordObject.value = w
            }

            override fun onFailure(call: Call<Word>?, t: Throwable) {
                wordObject.value = null
            }

        })
    }

}