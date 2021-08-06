package com.hm.yemeksepeti.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hm.yemeksepeti.MainActivity
import com.hm.yemeksepeti.R
import com.hm.yemeksepeti.adapters.SepetAdapter
import com.hm.yemeksepeti.databinding.SepetFragmentBinding
import com.hm.yemeksepeti.viewmodels.SepetViewModel


class SepetFragment : Fragment() {
    private lateinit var tasarim: SepetFragmentBinding
    private val viewModel: SepetViewModel by viewModels()
    private lateinit var adapter: SepetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.sepet_fragment, container, false)
        tasarim.sepetFragment= this


        val sepet_array = ((activity as MainActivity)).getArray()

        adapter = SepetAdapter(requireContext(), sepet_array,viewModel)
        tasarim.adapter = adapter


        var toplamFiyat = 0

        for (i in sepet_array.indices) {
            toplamFiyat += sepet_array[i].yemek_fiyat.toInt()
        }

        val toplam = toplamFiyat.toString()
        tasarim.textView5.text = toplam


        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Sepet"


        return tasarim.root
    }

}