package com.ichsanseanaldi_1805420.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_OBJECT = "buku" ;
    private TextView detailJudul, detailGenre, detailAuthor;
    private ImageView detailCover;
    private String judulGet;
    private String genreGet;
    private String authorGet;
    private int coverGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        getView();
        getParcelabel();
        setDetail();

    }

    public void getParcelabel(){

        Book book = getIntent().getParcelableExtra(EXTRA_BOOK_OBJECT);

        assert book != null;

        authorGet   = book.getAuthorBook();
        genreGet    = book.getGenreBook();
        judulGet    = book.getJudulBook();
        coverGet    = book.getCoverBook();
    }

    public void setDetail(){
        detailJudul.setText(judulGet);
        detailAuthor.setText(authorGet);
        detailGenre.setText(genreGet);
        detailCover.setImageResource(coverGet);
    }

    public void getView(){
        detailJudul     = findViewById(R.id.detail_judul);
        detailGenre     = findViewById(R.id.detail_genre);
        detailAuthor    = findViewById(R.id.detail_author);
        detailCover     = findViewById(R.id.detail_cover);
    }


}