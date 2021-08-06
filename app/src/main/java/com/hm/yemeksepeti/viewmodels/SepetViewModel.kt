package com.hm.yemeksepeti.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.yemeksepeti.MainActivity
import com.hm.yemeksepeti.entities.Yemekler

class SepetViewModel : ViewModel() {
    var sepetListesi = MutableLiveData<List<Yemekler>>()
}