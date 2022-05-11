package com.mansao.droidcafee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mansao.droidcafee.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDesserts = intent.getParcelableExtra<Desserts>(EXTRA_DATA)

        val actionBar = supportActionBar
        actionBar?.title = dataDesserts?.name
        actionBar?.setDisplayHomeAsUpEnabled(true)



        binding.tvDessertDescription.text = dataDesserts?.description

        Glide.with(this)
            .load(dataDesserts?.image)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_priority_high_24)
            .into(binding.imgDessert)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}