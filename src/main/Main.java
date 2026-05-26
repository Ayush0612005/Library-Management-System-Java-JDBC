package main;

import dao.BookDAO;
import java.util.Scanner;
import model.Book;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();
        while(true) {
            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.println("===============================================");
            int choice;

            try {

                choice = Integer.parseInt(sc.nextLine());

            } catch(Exception e) {

                System.out.println("❌ Invalid Input!");
                continue;
            }
            sc.nextLine();
            switch(choice) {
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
                case 2:

                    dao.viewBooks();
                    break;

                case 3:

                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();

                    dao.searchBooks(keyword);

                    break;

                case 4:

                    System.out.print("Enter Book ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter New Genre: ");
                    String newGenre = sc.nextLine();

                    System.out.print("Enter New ISBN: ");
                    String newIsbn = sc.nextLine();

                    Book updatedBook = new Book(
                            updateId,
                            newTitle,
                            newAuthor,
                            newGenre,
                            newIsbn
                    );


                    dao.updateBook(updatedBook);

                    break;

                case 5:

                    System.out.print("Enter Book ISBN to delete: ");
                    String deleteIsbn = sc.nextLine();

                    dao.deleteBook(deleteIsbn);

                    break;



                case 6:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");

            }
        }

    }
}
