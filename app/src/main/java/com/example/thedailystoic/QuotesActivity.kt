package com.example.thedailystoic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.thedailystoic.databinding.ActivityQuotesBinding

class QuotesActivity : AppCompatActivity(),QuotesAdapter.OnItemClickListener{

    private lateinit var binding: ActivityQuotesBinding
    private lateinit var quotesAdapter: QuotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rwQuotes.adapter = QuotesAdapter(fillList(), this)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, PageActivity::class.java)
        startActivity(intent)
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (1..30).forEach { i -> data.add("$i января") }
        return data
    }

    fun onClickGoBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}