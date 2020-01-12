package com.example.gvilavadb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*

class InfoActivity : AppCompatActivity() {
    private val db : DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val city1 = dataSnapshot.child("city").child("city1").value.toString()
                val city2 = dataSnapshot.child("city").child("city2").value.toString()
                val city3 = dataSnapshot.child("city").child("city3").value.toString()
                chveneba.setOnClickListener {
                    var listview = findViewById<ListView>(R.id.listView)
                    var list = mutableListOf<Model>()
                    list.add(Model("ქალაქები",city1,city2,city3))
                    listview.adapter = MyAdapter(this@InfoActivity,R.layout.row,list)
                    listview.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->}

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w( "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })


    }
}
