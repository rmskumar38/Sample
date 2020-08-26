package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attributes {
    @SerializedName("text_color")
    @Expose
    var textColor: String? = null
    @SerializedName("font")
    @Expose
    var font: Font? = null

}