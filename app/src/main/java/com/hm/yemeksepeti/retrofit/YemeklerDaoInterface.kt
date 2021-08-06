package com.hm.yemeksepeti.retrofit

import com.hm.yemeksepeti.entities.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDaoInterface {
    @GET("yemekler/tum_yemekler.php")
    fun tumYemekler(): Call<YemeklerCevap>
}