package com.example.standardbankapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sgbapp.R

class MyAdapter (var mycontext: Context, var recources : Int, var item: List<String>) : ArrayAdapter<String>(mycontext, recources, item) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(recources, null)

        val description: TextView = view.findViewById(R.id.list_header)

        var item : String = item[position]
        description.text = item
        return view
    }
}