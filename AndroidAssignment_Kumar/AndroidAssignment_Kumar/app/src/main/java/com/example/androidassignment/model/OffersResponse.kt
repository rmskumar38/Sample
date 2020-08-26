package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OffersResponse {
    @SerializedName("page")
    @Expose
    var page: Page? = null

}