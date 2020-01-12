package com.example.gvilavadb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resources: Int, var items: List<Model>) :ArrayAdapter<Model>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)
        val personTextView: TextView = view.findViewById(R.id.textView1)
        val nameTextView: TextView = view.findViewById(R.id.textView2)
        val sernameTextView: TextView = view.findViewById(R.id.textView3)
        val ageTextView: TextView = view.findViewById(R.id.textView4)
        var mItem: Model = items[position]
        personTextView.text = mItem.person
        nameTextView.text = mItem.namee
        sernameTextView.text = mItem.sername
        ageTextView.text = mItem.age

        return view
    }
}