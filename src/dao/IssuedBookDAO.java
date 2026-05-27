package dao;

import model.IssuedBook;
import database.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class IssuedBookDAO {

    public boolean issueBook(int userId, int bookId) {

        String checkBookQuery =
                "SELECT quantity FROM books WHERE id = ?";

        String issueQuery =
                "INSERT INTO issued_books " +
                        "(user_id, book_id, issue_date, due_date, status) " +
                        "VALUES (?, ?, ?, ?, ?)";

        String updateQuantityQuery =
                "UPDATE books SET quantity = quantity - 1 WHERE id = ?";

        Connection conn = null;

        try {

            conn = DBConnection.getConnection();

            // START TRANSACTION
            conn.setAutoCommit(false);

            // STEP 1 → Check quantity
            PreparedStatement checkStmt =
                    conn.prepareStatement(checkBookQuery);

            checkStmt.setInt(1, bookId);

            ResultSet rs = checkStmt.executeQuery();

            if(rs.next()) {

                int quantity = rs.getInt("quantity");

                if(quantity <= 0) {

                    System.out.println("Book not available.");
                    return false;
                }

            } else {

                System.out.println("Book not found.");
                return false;
            }

            // STEP 2 → Insert issue record
            PreparedStatement issueStmt =
                    conn.prepareStatement(issueQuery);

            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = issueDate.plusDays(7);

            issueStmt.setInt(1, userId);
            issueStmt.setInt(2, bookId);

            issueStmt.setDate(
                    3,
                    Date.valueOf(issueDate)
            );

            issueStmt.setDate(
                    4,
                    Date.valueOf(dueDate)
            );

            issueStmt.setString(5, "ISSUED");

            int rowsInserted =
                    issueStmt.executeUpdate();

            // STEP 3 → Reduce quantity
            if(rowsInserted > 0) {

                PreparedStatement updateStmt =
                        conn.prepareStatement(updateQuantityQuery);

                updateStmt.setInt(1, bookId);

                int rowsUpdated =
                        updateStmt.executeUpdate();

                if(rowsUpdated > 0) {

                    // SUCCESS
                    conn.commit();

                    System.out.println(
                            "Book issued successfully."
                    );

                    return true;

                } else {

                    // FAILURE
                    conn.rollback();

                    System.out.println(
                            "Issue failed."
                    );
                }
            }

        } catch(SQLException e) {

            try {

                if(conn != null) {

                    conn.rollback();
                }

            } catch(SQLException ex) {

                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {

                if(conn != null) {

                    conn.close();
                }

            } catch(SQLException e) {

                e.printStackTrace();
            }
        }

        return false;
    }

}
