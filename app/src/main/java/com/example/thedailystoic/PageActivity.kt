package com.example.thedailystoic

import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.*

class PageActivity : AppCompatActivity() {
    var textViewDate: TextView? = null
    var textViewName: TextView? = null
    var textViewQuote: TextView? = null
    var textViewAuthor: TextView? = null
    var textViewDescription: TextView? = null
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null
    var dayOfTheYear = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        mDBHelper = DatabaseHelper(this)
        try {
            mDBHelper!!.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }
        mDb = try {
            mDBHelper!!.writableDatabase
        } catch (mSQLException: SQLException) {
            throw mSQLException
        }
        textViewDate = findViewById(R.id.textViewDate)
        textViewName = findViewById(R.id.textViewName)
        textViewQuote = findViewById(R.id.textViewQuote)
        textViewAuthor = findViewById(R.id.textViewAuthor)
        textViewDescription = findViewById(R.id.textViewDescription)
        loadDate()
        loadName()
        loadQuote()
        loadAuthor()
        loadDescription()
        val calendar = Calendar.getInstance()
        val dayOfYear = calendar[Calendar.DAY_OF_YEAR]
        Toast.makeText(this, "Day number is: $dayOfYear", Toast.LENGTH_LONG).show()
    }

    fun loadDate() {
        var date = ""
        val cursor = mDb!!.rawQuery("SELECT date FROM pages WHERE _id = $dayOfTheYear", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            date += cursor.getString(0)
            cursor.moveToNext()
        }
        cursor.close()
        textViewDate!!.text = date
    }

    fun loadName() {
        var name = ""
        val cursor = mDb!!.rawQuery("SELECT name FROM pages WHERE _id = $dayOfTheYear", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            name += cursor.getString(0)
            cursor.moveToNext()
        }
        cursor.close()
        textViewName!!.text = name
    }

    fun loadQuote() {
        var quote = ""
        val cursor = mDb!!.rawQuery("SELECT quote FROM pages WHERE _id = $dayOfTheYear", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            quote += cursor.getString(0)
            cursor.moveToNext()
        }
        cursor.close()
        textViewQuote!!.text = quote
    }

    fun loadAuthor() {
        var author = ""
        val cursor = mDb!!.rawQuery("SELECT author FROM pages WHERE _id = $dayOfTheYear", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            author += cursor.getString(0)
            cursor.moveToNext()
        }
        cursor.close()
        textViewAuthor!!.text = author
    }

    fun loadDescription() {
        var description = ""
        val cursor = mDb!!.rawQuery("SELECT description FROM pages WHERE _id = $dayOfTheYear", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            description += cursor.getString(0)
            cursor.moveToNext()
        }
        cursor.close()
        textViewDescription!!.text = description
    }

    companion object {
        private const val TAG = "DATE"
    }
}