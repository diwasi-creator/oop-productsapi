package uk.ac.westminster.productsapi;

//Fields: the data every product has.
// private means only this class can touch them directly (encapsulation).

public abstract class Product {
    private Long id;
    private String name;
    private double price;

    public Product() {} // no-argument constructor: Jackson creates an empty object first, then fills it in.

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // No body: Product cannot answer this, so every subclass MUST.
    public abstract String getSummary();

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    //Getters and setters: the public way to read and change private fields.
    // Jackson uses getters to build the JSON.
}