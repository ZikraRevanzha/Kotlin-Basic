package com.kotlin.basic.trpl3c.api

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R
import com.kotlin.basic.trpl3c.api.adapters.ProductAdapter
import com.kotlin.basic.trpl3c.api.config.ApiClient
import com.kotlin.basic.trpl3c.api.models.ProductModel
import com.kotlin.basic.trpl3c.databinding.ActivityProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        showProduct()
    }

    fun showProduct() {
        binding.pbProduct.visibility = View.VISIBLE
        binding.linearWarning.visibility = View.GONE
        ApiClient.apiService.getProduct().enqueue(object : Callback<ProductModel?> {
            override fun onResponse(
                call: Call<ProductModel?>,
                response: Response<ProductModel?>
            ) {
                binding.pbProduct.visibility = View.GONE
                if (response.isSuccessful) {
                    val listProduct = response.body()?.products
                    binding.rvProduct.adapter = ProductAdapter(listProduct)
                } else {
                    binding.linearWarning.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<ProductModel?>, t: Throwable) {
                binding.linearWarning.visibility = View.VISIBLE
                binding.pbProduct.visibility = View.GONE
            }
        })
    }
}
