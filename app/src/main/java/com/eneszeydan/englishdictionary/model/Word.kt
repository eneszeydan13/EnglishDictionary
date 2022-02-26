package com.eneszeydan.englishdictionary.model

import com.google.gson.annotations.SerializedName


data class Word (

    @SerializedName("word"      ) var word      : String?              = null,
    @SerializedName("phonetic"  ) var phonetic  : String?              = null,
    @SerializedName("phonetics" ) var phonetics : ArrayList<Phonetics> = arrayListOf(),
    @SerializedName("origin"    ) var origin    : String?              = null,
    @SerializedName("meanings"  ) var meanings  : ArrayList<Meanings>  = arrayListOf()

)