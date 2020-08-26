package com.example.androidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Card {
    @SerializedName("card_type")
    @Expose
    var cardType: String? = null
    @SerializedName("card")
    @Expose
    var card: CardDetail? = null

}