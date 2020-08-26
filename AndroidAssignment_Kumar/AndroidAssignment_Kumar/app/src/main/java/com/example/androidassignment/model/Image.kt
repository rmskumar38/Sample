package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("size")
    @Expose
    var size: Size? = null

}