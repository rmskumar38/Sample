package com.example.androidassignment

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.androidassignment.network.ApiFactory
import com.example.androidassignment.model.OffersResponse
import com.example.androidassignment.ui.OffersListActivity
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
import java.io.IOException


@RunWith(AndroidJUnit4ClassRunner::class)
class OffersActivityTest {

    @get:Rule
    public val mActivityRule: ActivityTestRule<OffersListActivity> = ActivityTestRule<OffersListActivity>(OffersListActivity::class.java)
    @Test
    fun get_offers() {
        val call = ApiFactory.apiService.getOffers()

        try { //Magic is here at .execute() instead of .enqueue()
            val response: Response<OffersResponse> = call.execute()
            val authResponse: OffersResponse? = response.body()
            assertTrue(response.isSuccessful && authResponse?.page?.cards?.size!! >0)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }





}