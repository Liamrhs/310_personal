package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    ArrayList<Book> listOfBooks;
    TableLayout displayBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting user Key



        BookList lOB = new BookList();
        lOB.read(getApplicationContext());

        ArrayList<Book> LOBARRAY=lOB.getBookList();
        listOfBooks = lOB.getBookList();

        displayBooks= (TableLayout) findViewById(R.id.displayBooks);//casting table

        for(int i=0;i<listOfBooks.size();i++){//creating table
           Book fill=listOfBooks.get(i);//iterating through books
            TableRow row=new TableRow(this);//creating row

            String title=fill.title;//creating title view
            TextView titleView=new TextView(this);
            titleView.setText(""+title);

            String author=fill.author;//creating author view
            TextView authorView=new TextView(this);
            authorView.setText(""+author);

            String genre=fill.genre;//creating genre view
            TextView genreView=new TextView(this);
            genreView.setText(""+genre);

            row.addView(titleView);
            row.addView(authorView);
            row.addView(genreView);
            displayBooks.addView(row);

        }
    }



    public void returnHome(View V){
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String key=bundle.getString("key"); //placeholder for checking username
        if(key.equals("user")) {
            Intent intentuser = new Intent(this, UserMain.class);
            startActivity(intentuser);
        }

    }

}