package com.mansao.droidcafee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mansao.droidcafee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var list: ArrayList<Desserts> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.droid_cafe)

        list.addAll(DessertData.listData)

        showDessert()
    }

    private fun showDessert() {
        binding.rvDessert.layoutManager = LinearLayoutManager(this)
        val listDessertAdapter = ListDessertsAdapter(list)
        binding.rvDessert.adapter = listDessertAdapter

        listDessertAdapter.setOnItemClickCallBack(object : ListDessertsAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Desserts) {
                showSelectedItem(data)
            }
        })
    }

    private fun showSelectedItem(data: Desserts) {
        val toOrderActivity = Intent(this, OrderActivity::class.java)
        toOrderActivity.putExtra(OrderActivity.EXTRA_DATA, data)
        startActivity(toOrderActivity)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.contact -> {
                Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show()
            }
            R.id.order -> {
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show()
            }
            R.id.status -> {
                Toast.makeText(this, "Status", Toast.LENGTH_SHORT).show()
            }
            R.id.favorite -> {
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}