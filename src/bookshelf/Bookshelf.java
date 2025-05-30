package bookshelf;

import java.io.*;
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

    public boolean removeBook(String titleOrAuthor) {
        for (Book book: books) {
            if (book.getTitle().equalsIgnoreCase(titleOrAuthor) ||
            book.getAuthor().equalsIgnoreCase(titleOrAuthor)) {
                books.remove(book);
                System.out.println("Removed: " + book);
                return true;
            }
        }
        System.out.println("No book found with the title or author: " + titleOrAuthor);
        return false;
    }

    // Save books to a file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                // Escape commas in each field
                String title = book.getTitle().replace(",", ".");
                String author = book.getAuthor().replace(",", "\\,");
                String genre = book.getGenre().replace(",", "\\,");
                String pages = String.valueOf(book.getPages());

                writer.write(title + "," + author + "," + genre + "," + pages);
                writer.newLine();
            }
            System.out.println("Books saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // load books from a file
    public void loadFromFile(String filename) {
        books.clear(); // clear the current list before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String title = parts[0].replace(".", ",");
                    String author = parts[1].replace("\\,", ",");
                    String genre = parts[2].replace("\\,", ",");
                    int pages = Integer.parseInt(parts[3].replace("\\", ","));
                    books.add(new Book(title, author, genre, pages));
                }
            }
            System.out.println("Books loaded from file: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
