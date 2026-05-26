package model;

public class Book {

    private String title;
    private String author;
    private String genre;
    private String isbn;

    public Book(String title,
                String author,
                String genre,
                String isbn) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book(int id, String title, String author,
                String genre, String isbn) {

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }
}