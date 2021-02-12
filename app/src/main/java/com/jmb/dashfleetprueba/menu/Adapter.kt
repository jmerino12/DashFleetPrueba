package com.jmb.dashfleetprueba.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmb.dashfleetprueba.Ruta
import com.jmb.dashfleetprueba.databinding.ItemRutaBinding

class Adapter(private val context: Context, private val list: List<Ruta>) :RecyclerView.Adapter<Adapter.MainViewHolder>() {

    inner class MainViewHolder(private val viewBinding:ItemRutaBinding):RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(ruta: Ruta){
            viewBinding.title.text = ruta.title;
            viewBinding.km.text = ruta.km;

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewBinding  = ItemRutaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = list[position]
        holder.bindView(user)
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}