// Book.java
public class Book {
    // Attributes (fields)
    private String title;
    private String author;
    private double price;

    // Constructor to initialize the book object
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter methods (accessor methods)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    // Setter methods (mutator methods)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to display the information about the book
    public void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    // Main method to test the Book class
    public static void main(String[] args) {
        // Creating a book object
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        
        // Displaying book information
        book1.displayBookInfo();

        // Modifying book details
        book1.setPrice(12.99);

        // Displaying updated information
        System.out.println("\nUpdated Book Information:");
        book1.displayBookInfo();
    }
}
