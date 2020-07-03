package be.vdab;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public static void main(String[] args) {
        Author author = new Author("Luke Triton", "Luke.triton.future@gmail.com", 'm');
        Book book = new Book("The Eternal Diva",author,15.0,1);
        System.out.println(author);
        System.out.println(book);

    }



    public Book(String name, Author author, double price) {
        this(name,author,price,0);
    }
    public Book(String name, Author author, double price,int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString(){
        return ("Book[name=" + name + ",Author=" + author + ",price=" + price + ",qty=" + qty + "]" );
    }
}
