package com.ichsanseanaldi_1805420.bookcatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private int coverBook;
    private String authorBook, judulBook, genreBook;

    public Book() {

    }

    protected Book(Parcel in) {
        coverBook = in.readInt();
        authorBook = in.readString();
        judulBook = in.readString();
        genreBook = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getCoverBook() {

        return coverBook;
    }

    public void setCoverBook(int coverBook) {

        this.coverBook = coverBook;
    }

    public String getAuthorBook() {

        return authorBook;
    }

    public void setAuthorBook(String authorBook) {

        this.authorBook = authorBook;
    }

    public String getJudulBook() {
        return judulBook;
    }

    public void setJudulBook(String judulBook) {

        this.judulBook = judulBook;
    }

    public String getGenreBook() {

        return genreBook;
    }

    public void setGenreBook(String genreBook) {

        this.genreBook = genreBook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(coverBook);
        parcel.writeString(authorBook);
        parcel.writeString(judulBook);
        parcel.writeString(genreBook);
    }
}
