package com.example.gvilavadb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val db : DatabaseReference = FirebaseDatabase.getInstance().reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        atvirtvaGadasvla.setOnClickListener {
            val hashMap = HashMap<String,String>()
            hashMap.put("city1",name.text.toString())
            hashMap.put("city2",sername.text.toString())
            hashMap.put("city3",age.text.toString())
            db.child("city").setValue(hashMap)
            startActivity(Intent(this,InfoActivity::class.java))

        }
    }
}
