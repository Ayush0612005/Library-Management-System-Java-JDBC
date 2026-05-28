package main;

import dao.BookDAO;
import dao.UserDAO;

import service.IssuedBookService;
import model.Book;
import model.User;

import java.util.Scanner;

public class Main {

    // Global objects
    static Scanner sc = new Scanner(System.in);

    static BookDAO dao = new BookDAO();

    static UserDAO userDAO = new UserDAO();

    static IssuedBookService issuedBookService =
            new IssuedBookService();


    // MAIN METHOD
    public static void main(String[] args) {

        showAuthMenu();
    }


    // AUTH MENU
    public static void showAuthMenu() {

        while(true) {

            System.out.println("\n========= LIBRARY SYSTEM =========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            int choice;

            try {

                choice = Integer.parseInt(sc.nextLine());

            } catch(Exception e) {

                System.out.println("❌ Invalid Input!");
                continue;
            }

            switch(choice) {

                // REGISTER
                case 1:

                    handleRegister();
                    break;

                // LOGIN
                case 2:

                    handleLogin();
                    break;

                // EXIT
                case 3:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }


    // REGISTER METHOD
    public static void handleRegister() {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Role (ADMIN/MEMBER): ");
        String role = sc.nextLine();

        User user = new User(
                name,
                email,
                password,
                role
        );

        userDAO.registerUser(user);
    }


    // LOGIN METHOD
    public static void handleLogin() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean isLoggedIn =
                userDAO.loginUser(email, password);

        if(isLoggedIn) {

            showLibraryMenu();
        }
    }


    // LIBRARY MENU
    public static void showLibraryMenu() {

        while(true) {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Logout");
            System.out.println("===============================================");

            int choice;

            try {

                choice = Integer.parseInt(sc.nextLine());

            } catch(Exception e) {

                System.out.println("❌ Invalid Input!");
                continue;
            }

            switch(choice) {

                // ADD BOOK
                case 1:

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    if(title.isEmpty()) {

                        System.out.println("❌ Title cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Book Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Enter Book ISBN: ");
                    String isbn = sc.nextLine();

                    Book book = new Book(
                            title,
                            author,
                            genre,
                            isbn
                    );

                    dao.addBook(book);

                    break;


                // VIEW BOOKS
                case 2:

                    dao.viewBooks();
                    break;


                // SEARCH BOOKS
                case 3:

                    System.out.print("Enter keyword to search: ");

                    String keyword = sc.nextLine();

                    dao.searchBooks(keyword);

                    break;


                // UPDATE BOOK
                case 4:

                    System.out.print("Enter Book ISBN to update: ");
                    String updateIsbn = sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter New Genre: ");
                    String newGenre = sc.nextLine();

                    Book updatedBook = new Book(
                            newTitle,
                            newAuthor,
                            newGenre,
                            updateIsbn
                    );

                    dao.updateBook(updatedBook);

                    break;


                // DELETE BOOK
                case 5:

                    System.out.print("Enter Book ISBN to delete: ");

                    String deleteIsbn = sc.nextLine();

                    dao.deleteBook(deleteIsbn);

                    break;



                // ISSUE BOOK
                case 6:

                    System.out.print("Enter User ID: ");
                    int userId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Book ID: ");
                    int bookId =
                            Integer.parseInt(sc.nextLine());

                    issuedBookService.issueBook(userId, bookId);

                    break;


                // RETURN BOOK
                case 7:

                    System.out.print("Enter Issue ID: ");

                    int issueId =
                            Integer.parseInt(sc.nextLine());

                    issuedBookService.returnBook(issueId);

                    break;


                // LOGOUT
                case 8:

                    System.out.println("Logging out...");
                    return;


                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}
