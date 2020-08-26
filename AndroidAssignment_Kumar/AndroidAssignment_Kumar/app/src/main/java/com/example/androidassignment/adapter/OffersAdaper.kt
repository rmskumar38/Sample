package com.example.androidassignment.adapter

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.androidassignment.R
import com.example.androidassignment.model.Card
import com.example.androidassignment.utils.Constants


class StoreAdapter(val items: ArrayList<Card>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        when (viewType) {
            0 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.title_row, parent, false)
                return TextTypeViewHolder(view)
            }
            1 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.title_description_row, parent, false)
                return TextDescTypeViewHolder(view)
            }
            2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_title_description_row, parent, false)
                return ImageTypeViewHolder(view)
            }
            else -> {
                //  returning default view
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.title_row, parent, false)
                return TextTypeViewHolder(view)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (items.get(position).cardType) {
            Constants.CardType.TEXT.cardType -> 0
            Constants.CardType.TITLE_DESCRIPTION.cardType -> 1
            Constants.CardType.IMAGE_TITLE_DESCRIPTION.cardType -> 2
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {

        // Get item
        val card = items[listPosition]

        // Assign default values
        var titleSize: Float = context.resources.getDimension(R.dimen.list_title_text_size)
        var descTextSize: Float = context.resources.getDimension(R.dimen.list_title_offer_desc_size)
        var titleTextColor: Int = ContextCompat.getColor(context, R.color.colorBlack)
        var descTextColor: Int = ContextCompat.getColor(context, R.color.colorBlack)

        // Set data to views

        if (card != null) {
            when (card.cardType) {
                Constants.CardType.TEXT.cardType -> {
                    if (card.card?.attributes?.font?.size != null) {
                        titleSize = card.card?.attributes?.font?.size!!.toFloat()
                    }

                    if (!card.card?.attributes?.textColor.isNullOrBlank()) {
                        titleTextColor = Color.parseColor(card.card?.attributes?.textColor)
                    }
                    (holder as TextTypeViewHolder).title.text = card.card?.value
                    holder.title.setTextColor(titleTextColor)
                    // Assuming that the font received in sp, so setting font in SP format
                    holder.title.setTextSize(
                        TypedValue.COMPLEX_UNIT_SP,
                        titleSize
                    )
                }

                Constants.CardType.TITLE_DESCRIPTION.cardType -> {

                    if (card.card?.title?.attributes?.font?.size != null) {
                        titleSize = card.card?.title?.attributes?.font?.size!!.toFloat()
                    }


                    if (card.card?.description?.attributes?.font?.size != null) {
                        descTextSize = card.card?.description?.attributes?.font?.size!!.toFloat()
                    }


                    if (!card.card?.title?.attributes?.textColor?.isBlank()!!) {
                        titleTextColor = Color.parseColor(card.card?.title?.attributes?.textColor)
                    }

                    if (!card.card?.description?.attributes?.textColor?.isBlank()!!) {
                        descTextColor =
                            Color.parseColor(card.card?.description?.attributes?.textColor)
                    }


                    (holder as TextDescTypeViewHolder).title.text = card.card?.title?.value
                    holder.title.setTextColor(titleTextColor)
                    holder.title.setTextSize(
                        TypedValue.COMPLEX_UNIT_SP,
                        titleSize
                    )
                    holder.desc.text = card.card?.description?.value
                    holder.desc.setTextSize(
                        TypedValue.COMPLEX_UNIT_SP,
                        descTextSize
                    )
                    holder.desc.setTextColor(descTextColor)
                }

                Constants.CardType.IMAGE_TITLE_DESCRIPTION.cardType -> {

                    if (card.card?.title?.attributes?.font?.size != null) {
                        titleSize = card.card?.title?.attributes?.font?.size!!.toFloat()
                    }


                    if (card.card?.description?.attributes?.font?.size != null) {
                        descTextSize = card.card?.description?.attributes?.font?.size!!.toFloat()
                    }


                    if (!card.card?.title?.attributes?.textColor?.isBlank()!!) {
                        titleTextColor = Color.parseColor(card.card?.title?.attributes?.textColor)
                    }

                    if (!card.card?.description?.attributes?.textColor?.isBlank()!!) {
                        descTextColor =
                            Color.parseColor(card.card?.description?.attributes?.textColor)
                    }
                    var width: Int? = 200
                    var height: Int? = 200
                    if (card.card?.image?.size?.width != null) {
                        width = card.card?.image?.size?.width
                        height = card.card?.image?.size?.height
                    }
                    (holder as ImageTypeViewHolder).title.text = card.card?.title?.value
                    holder.title.setTextSize(
                        TypedValue.COMPLEX_UNIT_SP,
                        titleSize
                    )
                    holder.title.setTextColor(titleTextColor)
                    holder.desc.text = card.card?.description?.value
                    holder.desc.setTextSize(
                        TypedValue.COMPLEX_UNIT_SP,
                        descTextSize
                    )
                    holder.desc.setTextColor(descTextColor)
                    Glide.with(context)
                        .load(card.card?.image?.url)
                        .override(width!!, height!!)
                        .into(holder.image)
                }


            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TextTypeViewHolder(itemView: View) : ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<View>(R.id.tv_title_title) as TextView

    }

    class ImageTypeViewHolder(itemView: View) : ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<View>(R.id.tv_image_title_dec_title) as TextView
        var desc: TextView = itemView.findViewById<View>(R.id.tv_image_title_desc_desc) as TextView
        var image: ImageView =
            itemView.findViewById<View>(R.id.iv_image_title_dec_image) as ImageView

    }

    class TextDescTypeViewHolder(itemView: View) : ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<View>(R.id.tv_title_dec_title) as TextView
        var desc: TextView = itemView.findViewById<View>(R.id.tv_title_desc_desc) as TextView

    }
}
