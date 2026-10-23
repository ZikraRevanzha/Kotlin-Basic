package com.kotlin.basic.trpl3c.recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.basic.trpl3c.R

class GridActivity : AppCompatActivity() {
    private lateinit var rvGrid: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvGrid = findViewById(R.id.recyclerView)
        rvGrid.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onStart() {
        super.onStart()
        showGRid()
    }

    private fun showGRid() {
        val listGrid = listOf<GridModel>(
            GridModel(
                R.drawable.img_grid1,
                "VICLOOK Easy Install Tempered glass Anti SPY HD Clear Fit for iPhone 11/12/13/14/15/16/17/X/XR/XS Mini Max Pro Plus",
                "Rp 69.000",
                4.8f,
                "10k",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam volup."
            ),
            GridModel(
                R.drawable.img_grid2,
                "SPEEDS Kursi Lipat Outdoor Portable Kursi Camping Folding Chair Gunung Kemah Mudah LX 031-14",
                "Rp 62.149",
                4.9f,
                "3.5k",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam volup."
            ),
            GridModel(
                R.drawable.img_grid3,
                "HUAWEI Band 10 Smartband | Sleek Aluminum Alloy Case | Pro-Level Sleep Analysis | Emotional Wellbeing Assistant",
                "Rp 469.000",
                5f,
                "2.1k",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam volup."
            ),
            GridModel(
                R.drawable.img_grid4,
                "Paus Biru - Wallpaper Dinding Motif Vinyl Marble Foam Roll Sticker Kamar Dekorasi PET 120 x 244cm/120 x 280cm/60x244cm",
                "Rp 67.999",
                4.6f,
                "1.8k",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam volup."
            ),
            GridModel(
                R.drawable.img_grid5,
                "Octarine - Elixir One Aroma Fresh Fruity Woody | Parfum Perfume Minyak Wangi Pria Wanita Tahan Lama",
                "Rp 74.500",
                4.4f,
                "2.9k",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam volup."
            )
        )
        rvGrid.adapter = GridAdapter(listGrid)
    }
}