package com.hm.yemeksepeti.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hm.yemeksepeti.databinding.YemekCardBinding
import com.hm.yemeksepeti.entities.Yemekler
import com.hm.yemeksepeti.fragments.AnasayfaFragmentDirections
import com.hm.yemeksepeti.viewmodels.AnasayfaViewModel
import com.squareup.picasso.Picasso

class YemekAdapter(var mContext: Context, var yemekListesi:List<Yemekler>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YemekAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: YemekCardBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarim:YemekCardBinding = cardTasarimBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = YemekCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemekListesi.get(position)

        holder.cardTasarim.yemekNesnesi = yemek

        holder.cardTasarim.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemek)

            Navigation.findNavController(it).navigate(gecis)
        }

        val img = yemek.yemek_resim_adi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$img"
        Picasso.get().load(url).into(holder.cardTasarim.yemekResim)


    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}