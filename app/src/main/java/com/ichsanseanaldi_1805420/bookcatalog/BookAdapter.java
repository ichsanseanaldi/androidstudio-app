package com.ichsanseanaldi_1805420.bookcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class BookAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Book> books = new ArrayList<>();

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public BookAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View itemView = view;

        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.book_listview,viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Book book = (Book) getItem(i);

        viewHolder.bind(book);

        return itemView;

    }

    private static class ViewHolder{

        private TextView txtJudul, txtAuthor, txtGenre;
        private ImageView imgCover;

        ViewHolder(View view) {
           txtJudul = view.findViewById(R.id.judul_buku);
           txtAuthor = view.findViewById(R.id.penulis_buku);
           txtGenre = view.findViewById(R.id.genre_buku);
           imgCover = view.findViewById(R.id.cover_book);
        }

        void bind(Book book){
            txtJudul.setText(book.getJudulBook());
            txtAuthor.setText(book.getAuthorBook());
            txtGenre.setText(book.getGenreBook());
            imgCover.setImageResource(book.getCoverBook());
        }


    }
}
