package com.eneszeydan.englishdictionary.model

import com.google.gson.annotations.SerializedName


data class Definitions (

  @SerializedName("definition" ) var definition : String,
  @SerializedName("example"    ) var example    : String,
  @SerializedName("synonyms"   ) var synonyms   : ArrayList<String>,
  @SerializedName("antonyms"   ) var antonyms   : ArrayList<String>

)