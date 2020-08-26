package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Size {
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null

}