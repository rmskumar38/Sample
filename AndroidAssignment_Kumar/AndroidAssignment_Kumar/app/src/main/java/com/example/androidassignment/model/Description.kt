package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Description {
    @SerializedName("value")
    @Expose
    var value: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes? = null

}