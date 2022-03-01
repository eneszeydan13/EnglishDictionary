package com.eneszeydan.englishdictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eneszeydan.englishdictionary.model.Word
import com.eneszeydan.englishdictionary.repo.WordDaoRepository

class HomepageFragmentViewModel: ViewModel() {

    var word = MutableLiveData<Word>()
    var wrepo = WordDaoRepository()

    init {
        word = wrepo.getWord()
    }

    fun getWordInfo(key:String){
        wrepo.getWordInfo(key)
    }

}