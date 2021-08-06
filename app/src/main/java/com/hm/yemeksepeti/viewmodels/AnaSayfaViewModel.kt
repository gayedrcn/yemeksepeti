package com.hm.yemeksepeti.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.yemeksepeti.entities.Yemekler
import com.hm.yemeksepeti.repo.YemekDaoRepository

class AnasayfaViewModel : ViewModel() {
    //Live data dinleme işlemi sağlar.
    var yemekListesi = MutableLiveData<List<Yemekler>>()
    val yemekDao = YemekDaoRepository()

    init {
        yemeklerYukle()
        yemekListesi = yemekDao.yemekleriGetir()
    }
    fun yemeklerYukle(){
        yemekDao.tumYemekleriAl()
    }

}