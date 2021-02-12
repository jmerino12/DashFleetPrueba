package com.jmb.dashfleetprueba.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmb.dashfleetprueba.R
import com.jmb.dashfleetprueba.Ruta
import com.jmb.dashfleetprueba.databinding.FragmentBilleteraBinding


class BilleteraFragment : Fragment() {
    private lateinit var adapter: Adapter
    private var _binding: FragmentBilleteraBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBilleteraBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoriesRecycler()
    }

    private fun categoriesRecycler() {
        _binding!!.recycler.setHasFixedSize(true)
        _binding!!.recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        _binding!!.recycler.adapter = context?.let { Adapter(it,getCategories()) }

    }


    fun getCategories(): MutableList<Ruta> {
        var list: MutableList<Ruta> = ArrayList()
        list.add(Ruta("Ruta 1", "3 km"))
        list.add(Ruta("Ruta 2", "4 km"))
        list.add(Ruta("Ruta 3", "8 km"))
        list.add(Ruta("Ruta 6", "8 km"))


        return list
    }

}