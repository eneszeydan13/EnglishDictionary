package com.eneszeydan.englishdictionary.model

import com.google.gson.annotations.SerializedName


data class Phonetics (

  @SerializedName("text"  ) var text  : String? = null,
  @SerializedName("audio" ) var audio : String? = null

)