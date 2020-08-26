package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Title {
    @SerializedName("value")
    @Expose
    var value: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes? = null

}