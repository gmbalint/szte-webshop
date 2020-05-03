package hu.uszeged.stud.gmbalint;

public class Product {
    private double price;
    private String name;
    private int quantity;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //korbedobozoljuk a változokat (boxing)
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //konstr.
    //nem kéne itt lennie de azért fasza ha van:)
    //megmarad a lehetőség az üresre is.
    //overloading van
    public Product() {
    }

    public Product(double price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
}
