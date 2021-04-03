package com.example.thedailystoic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.thedailystoic.databinding.ActivityQuotesBinding

class QuotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuotesBinding
    private lateinit var quotesAdapter: QuotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rwQuotes.adapter = QuotesAdapter(fillList())
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