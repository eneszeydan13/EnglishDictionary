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
        wdao.getWordInfo(key).enqueue(object : Callback<List<Word>>{
            override fun onResponse(call: Call<List<Word>>?, response: Response<List<Word>>?) {
                val w = response?.body()?.get(0)
                wordObject.value = w
            }

            override fun onFailure(call: Call<List<Word>>?, t: Throwable) {
                Log.d("Failure", t.localizedMessage)
            }


        })
    }

}