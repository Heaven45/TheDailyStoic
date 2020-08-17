package com.example.thedailystoic;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import java.io.IOException;

public class PageActivity extends AppCompatActivity {

    private static final String TAG = "DATE";
    TextView textViewDate;
    TextView textViewName;
    TextView textViewQuote;
    TextView textViewAuthor;
    TextView textViewDescription;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    int dayOfTheYear = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        textViewDate = findViewById(R.id.textViewDate);
        textViewName = findViewById(R.id.textViewName);
        textViewQuote = findViewById(R.id.textViewQuote);
        textViewAuthor = findViewById(R.id.textViewAuthor);
        textViewDescription = findViewById(R.id.textViewDescription);

        loadDate();
        loadName();
        loadQuote();
        loadAuthor();
        loadDescription();

        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        Toast.makeText(this, "Day number is: " + dayOfYear, Toast.LENGTH_LONG).show();
    }

    public void loadDate(){
        String date = "";

        Cursor cursor = mDb.rawQuery("SELECT date FROM pages WHERE _id = " + dayOfTheYear, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            date += cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        textViewDate.setText(date);
    }

    public void loadName(){
        String name = "";

        Cursor cursor = mDb.rawQuery("SELECT name FROM pages WHERE _id = " + dayOfTheYear, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name += cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        textViewName.setText(name);
    }

    public void loadQuote(){
        String quote = "";

        Cursor cursor = mDb.rawQuery("SELECT quote FROM pages WHERE _id = " + dayOfTheYear, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            quote += cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        textViewQuote.setText(quote);
    }

    public void loadAuthor(){
        String author = "";

        Cursor cursor = mDb.rawQuery("SELECT author FROM pages WHERE _id = " + dayOfTheYear, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            author += cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        textViewAuthor.setText(author);
    }

    public void loadDescription(){
        String description = "";

        Cursor cursor = mDb.rawQuery("SELECT description FROM pages WHERE _id = " + dayOfTheYear, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            description += cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        textViewDescription.setText(description);
    }
}