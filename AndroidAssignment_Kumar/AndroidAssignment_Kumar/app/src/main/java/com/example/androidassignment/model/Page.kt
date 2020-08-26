package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Page {
    @SerializedName("cards")
    @Expose
    var cards: ArrayList<Card>? = null

}