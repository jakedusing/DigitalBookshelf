import bookshelf.Bookshelf;
import bookshelf.Book;

public class Main {

    public static void main(String[] args) {

        Bookshelf myBookshelf = new Bookshelf();

        myBookshelf.addBook(new Book("Lost Stars", "Claudia Gray", "Science Fiction", 300));
        myBookshelf.addBook(new Book("Animal Crossing", "Kelsey Lewin", "Gaming", 190));
        myBookshelf.addBook(new Book("Rebel Rising", "Beth Revis", "Science Fiction", 243));
        myBookshelf.addBook(new Book("Live Learn Love Well: Lessons from a Life of Progress Not Perfection",
                "Emma Lovewell", "Memoir", 203));

        myBookshelf.displayBooks();

        // save to file
        myBookshelf.saveToFile("books.txt");

        // clear and load from file
        myBookshelf.loadFromFile("books.txt");

        // display books to confirm
        myBookshelf.displayBooks();

        /*myBookshelf.displayBooks();

        System.out.println();
        myBookshelf.searchBooks("Memoir");
        myBookshelf.searchBooks("Claudia Gray");
        myBookshelf.searchBooks("Gaming");

        System.out.println("-------------");
        System.out.println("\nAttempting to remove a book....");
        myBookshelf.removeBook("Lost Stars");
        myBookshelf.removeBook("Emma Lovewell");

        System.out.println("\nBooks after removal");
        myBookshelf.displayBooks();*/
    }
}