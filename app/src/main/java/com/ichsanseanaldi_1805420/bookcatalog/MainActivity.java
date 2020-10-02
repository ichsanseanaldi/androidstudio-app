package com.ichsanseanaldi_1805420.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BookAdapter adapter;
    private String[] dataTitle, dataAuthor, dataGenre;
    private TypedArray dataCover;
    private ArrayList<Book> books;
    public static final String EXTRA_BOOK_OBJECT = "buku";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_custom);
        adapter = new BookAdapter(this);
        listView.setAdapter(adapter);

        fetch();
        addData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);

                Book detail_book = new Book();
                detail_book.setJudulBook(dataTitle[i]);
                detail_book.setGenreBook(dataGenre[i]);
                detail_book.setAuthorBook(dataAuthor[i]);
                detail_book.setCoverBook(dataCover.getResourceId(i, -1));

                intent.putExtra(BookDetailActivity.EXTRA_BOOK_OBJECT, detail_book);
                startActivity(intent);
            }
        });
    }

    private void fetch(){
        dataTitle = getResources().getStringArray(R.array.title);
        dataAuthor = getResources().getStringArray(R.array.author);
        dataGenre = getResources().getStringArray(R.array.genre);
        dataCover = getResources().obtainTypedArray(R.array.cover);
    }

    private void addData(){

        books = new ArrayList<>();

        for (int i = 0; i < dataTitle.length ; i++){

            Book book = new Book();
            book.setJudulBook(dataTitle[i]);
            book.setGenreBook(dataGenre[i]);
            book.setAuthorBook(dataAuthor[i]);
            book.setCoverBook(dataCover.getResourceId(i, -1));

            books.add(book);
        }

        adapter.setBooks(books);
    }

}