package com.hm.yemeksepeti.viewmodels

import androidx.lifecycle.ViewModel

import com.hm.yemeksepeti.repo.YemekDaoRepository

class DetayViewModel : ViewModel() {
    val yemekDao = YemekDaoRepository()



}