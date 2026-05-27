package service;

import dao.IssuedBookDAO;

public class IssuedBookService {

    IssuedBookDAO issuedBookDAO =
            new IssuedBookDAO();

    // ISSUE BOOK
    public void issueBook(int userId, int bookId) {

        if(userId <= 0 || bookId <= 0) {

            System.out.println(
                    "Invalid IDs."
            );

            return;
        }

        issuedBookDAO.issueBook(userId, bookId);
    }

    // RETURN BOOK
    public void returnBook(int issueId) {

        if(issueId <= 0) {

            System.out.println(
                    "Invalid Issue ID."
            );

            return;
        }

        issuedBookDAO.returnBook(issueId);
    }
}
