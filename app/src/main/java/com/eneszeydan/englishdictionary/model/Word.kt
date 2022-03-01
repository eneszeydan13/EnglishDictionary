package com.eneszeydan.englishdictionary.model

import com.google.gson.annotations.SerializedName


data class Word (

    @SerializedName("word"      ) var word      : String,
    @SerializedName("phonetic"  ) var phonetic  : String,
    @SerializedName("phonetics" ) var phonetics : ArrayList<Phonetics>,
    @SerializedName("origin"    ) var origin    : String,
    @SerializedName("meanings"  ) var meanings  : ArrayList<Meanings>

)