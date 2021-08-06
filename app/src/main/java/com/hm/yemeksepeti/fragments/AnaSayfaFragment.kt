package com.hm.yemeksepeti.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hm.yemeksepeti.MainActivity
import com.hm.yemeksepeti.R
import com.hm.yemeksepeti.adapters.YemekAdapter
import com.hm.yemeksepeti.databinding.FragmentAnaSayfaBinding
import com.hm.yemeksepeti.viewmodels.AnasayfaViewModel


class AnasayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentAnaSayfaBinding
    private lateinit var adapter: YemekAdapter
    private val viewModel: AnasayfaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_ana_sayfa, container, false)
        tasarim.anasayfaFragment = this

        viewModel.yemekListesi.observe(viewLifecycleOwner, {
            adapter = YemekAdapter(requireContext(), it,viewModel)
            tasarim.adapter = adapter
        })


        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Yemekler"



        return tasarim.root
    }

}