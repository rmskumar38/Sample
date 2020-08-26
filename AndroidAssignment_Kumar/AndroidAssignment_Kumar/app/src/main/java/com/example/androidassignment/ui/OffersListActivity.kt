package com.example.androidassignment.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.network.ApiFactory
import com.example.androidassignment.adapter.StoreAdapter
import com.example.androidassignment.utils.Utils
import kotlinx.android.synthetic.main.activity_offers.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.androidassignment.R
import com.example.androidassignment.listeners.RecyclerItemClickListener
import com.example.androidassignment.model.Card
import com.example.androidassignment.model.OffersResponse


class OffersListActivity : BaseActivity() {

    lateinit var activity: Activity
    var storeList: ArrayList<Card>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers)
        activity = this
        if (Utils.checkNetwork(this)) {
            init()
        } else {
            showToastMessage(getString(R.string.no_internet))
        }
    }

    private fun init() {
        showProgressBar()
        val call = ApiFactory.apiService.getOffers()
        call.enqueue(object : Callback<OffersResponse> {
            override fun onFailure(call: Call<OffersResponse>, t: Throwable) {
                hideProgressBar()
            }

            override fun onResponse(call: Call<OffersResponse>, response: Response<OffersResponse>) {
                hideProgressBar()
                if (response.isSuccessful) {
                    val storeModel = response.body() as OffersResponse
                    rv_offers.layoutManager = LinearLayoutManager(activity)

                    val dividerItemDecoration = DividerItemDecoration(
                        rv_offers.context,
                        DividerItemDecoration.VERTICAL
                    )

                    rv_offers.addItemDecoration(dividerItemDecoration)
                    storeList = storeModel.page?.cards

                    if (!storeList.isNullOrEmpty())
                        rv_offers.adapter = StoreAdapter(storeList!!, activity)


                } else {
                    showToastMessage(getString(R.string.exception_while_getting_data))
                }
            }

        })

        rv_offers.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                rv_offers,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        // TODO: Navigate to detail page
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                    }

                })
        )


    }
}
