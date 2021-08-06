package com.hm.yemeksepeti.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hm.yemeksepeti.databinding.SepetCardBinding
import com.hm.yemeksepeti.entities.Yemekler
import com.hm.yemeksepeti.viewmodels.SepetViewModel
import com.squareup.picasso.Picasso

class SepetAdapter (var mContext: Context, var sepetListesi:List<Yemekler>, var viewModel: SepetViewModel)
    : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: SepetCardBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarim: SepetCardBinding = cardTasarimBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = sepetListesi.get(position)

        holder.cardTasarim.sepetNesnesi = yemek

        val img = yemek.yemek_resim_adi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$img"
        Picasso.get().load(url).into(holder.cardTasarim.sepetYemekResim)
    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}