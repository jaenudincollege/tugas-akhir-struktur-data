public class Book {
    private String name;
    private String author;
    private String category;
    private String isbn;

    // Constructor
    public Book(String name, String author, String category, String isbn) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
    }

    // Getters and Setters (optional)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
