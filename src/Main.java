import bookshelf.Bookshelf;
import bookshelf.Book;

public class Main {

    public static void main(String[] args) {

        Bookshelf myBookshelf = new Bookshelf();

        myBookshelf.addBook(new Book("Lost Stars", "Claudia Gray", "Science Fiction"));
        myBookshelf.addBook(new Book("Animal Crossing", "Kelsey Lewin", "Gaming"));
        myBookshelf.addBook(new Book("XOXO, Cody: An Opinionated Guide to Life, Love, and Style",
                "Cody Rigsby", "Memoir"));
        myBookshelf.addBook(new Book("Live Learn Love Well: Lessons from a Life of Progress Not Perfection",
                "Emma Lovewell", "Memoir"));

        myBookshelf.displayBooks();

        System.out.println();
        myBookshelf.searchBooks("Memoir");
        myBookshelf.searchBooks("Claudia Gray");
        myBookshelf.searchBooks("Gaming");
    }
}