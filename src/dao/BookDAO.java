package dao;

import database.DBConnection;
import model.Book;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {

    public void addBook(Book book) {

        String query =
                "INSERT INTO books(title, author, genre, isbn) VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.setString(4, book.getIsbn());

            ps.executeUpdate();

            System.out.println("\n✅ Book Added Successfully!\n");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewBooks() {

        String query = "SELECT * FROM books";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("\n----------------------------------");
                System.out.println("Book ID : " + rs.getInt("id"));
                System.out.println("Title   : " + rs.getString("title"));
                System.out.println("Author  : " + rs.getString("author"));
                System.out.println("Genre   : " + rs.getString("genre"));
                System.out.println("ISBN    : " + rs.getString("isbn"));
                System.out.println("----------------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void searchBooks(String keyword) {

        String query =
                "SELECT * FROM books " +
                        "WHERE title LIKE ? " +
                        "OR author LIKE ? " +
                        "OR genre LIKE ? " +
                        "OR isbn LIKE ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getString("genre") + " | " +
                                rs.getString("isbn")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void deleteBook(String isbn) {

        String query =
                "DELETE FROM books WHERE isbn = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, isbn);

            int rowsAffected =
                    ps.executeUpdate();

            if(rowsAffected > 0) {

                System.out.println("\n✅ Book DELETED Successfully!\n");

            } else {

                System.out.println("Book Not Found!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void updateBook(Book book) {

        String query =
                "UPDATE books " +
                        "SET title=?, author=?, genre=? " +
                        "WHERE isbn=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.setString(4, book.getIsbn());

            int rowsAffected =
                    ps.executeUpdate();

            if(rowsAffected > 0) {

                System.out.println("\n✅ Book UPDATED Successfully!\n");

            } else {

                System.out.println("Book Not Found!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
