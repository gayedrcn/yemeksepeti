package com.hm.yemeksepeti.repo

import androidx.lifecycle.MutableLiveData
import com.hm.yemeksepeti.entities.Yemekler
import com.hm.yemeksepeti.entities.YemeklerCevap
import com.hm.yemeksepeti.retrofit.ApiUtils
import com.hm.yemeksepeti.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemekDaoRepository {

    private val yemekListesi: MutableLiveData<List<Yemekler>> = MutableLiveData()
    private val yemekInterface: YemeklerDaoInterface = ApiUtils.getYemeklerDaoInterface()

    fun yemekleriGetir():MutableLiveData<List<Yemekler>>{
        return yemekListesi
    }

    fun tumYemekleriAl(){
        yemekInterface.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemekListesi.value = liste
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }
}

