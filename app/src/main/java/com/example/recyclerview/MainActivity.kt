package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.CustomAdapter
import com.example.recyclerview.adapter.Data
import com.example.recyclerview.adapter.OnclickListener
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,OnclickListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var customAdapter: CustomAdapter
    private lateinit var list: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= arrayListOf()
        addDataTorecycle()
        customAdapter= CustomAdapter(list,this)

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=customAdapter
    }

    private fun addDataTorecycle() {
        list.add(Data("Orange"))
        list.add(Data("Apple"))
        list.add(Data("Grapes"))
        list.add(Data("Pineapple"))
        list.add(Data("Pomegranate"))
        list.add(Data("Cherry"))
        list.add(Data("Watermelon"))
        list.add(Data("Apricot"))
        list.add(Data("Mango"))
        list.add(Data("Coconut"))
        list.add(Data("Strawberry"))
        list.add(Data("Plum"))
        list.add(Data("Gooseberry"))
    }

    override fun OnItemClick(item:Data,position: Int) {
        Toast.makeText(this,"Fruit Clicked"+item,Toast.LENGTH_SHORT).show()
    }
}