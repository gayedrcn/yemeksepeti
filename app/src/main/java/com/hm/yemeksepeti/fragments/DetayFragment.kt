package com.hm.yemeksepeti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.hm.yemeksepeti.MainActivity
import com.hm.yemeksepeti.R
import com.hm.yemeksepeti.databinding.FragmentDetayBinding
import com.hm.yemeksepeti.viewmodels.DetayViewModel
import com.squareup.picasso.Picasso

class DetayFragment : Fragment() {

    private lateinit var tasarim:FragmentDetayBinding
    private val viewModel: DetayViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false)
        tasarim.detayFragment= this


        val b:DetayFragmentArgs by navArgs()
        tasarim.yemekNesnesi = b.yemekNesnesi

        (activity as MainActivity).supportActionBar?.title = b.yemekNesnesi.yemek_adi
        ((activity as MainActivity)).getMyTextView()?.text = ""

        val img = b.yemekNesnesi.yemek_resim_adi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$img"
        Picasso.get().load(url).into(tasarim.yemekDetayResim)


        tasarim.button.setOnClickListener{

            Snackbar.make(it,"Sepete eklemek istiyor musunuz ?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){

                    ((activity as MainActivity)).getArray().add(b.yemekNesnesi)
                    Snackbar.make(it,"Eklendi", Snackbar.LENGTH_SHORT).show()}.show()
        }

        return tasarim.root
    }

}