package bookshelf;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {

    private List<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<>();
    }

    // Add a book to the bookshelf
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Display all books on the bookshelf
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The bookshelf is empty");
        } else {
            System.out.println("Books on the bookshelf:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search for books by title, author, or genre
    public void searchBooks(String keyword) {
        System.out.println("Search results for: " + keyword);
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching the keyword");
        }
    }
}
