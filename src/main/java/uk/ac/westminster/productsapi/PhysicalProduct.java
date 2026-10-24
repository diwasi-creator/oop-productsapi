package uk.ac.westminster.productsapi;

// A PhysicalProduct IS-A Product because it is a kind of product the shop sells, with a name and a price.
// ShoppingCart would NOT pass this test: a cart HAS products, it isn't one (HAS-A, so use a field).
public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);   // must be the first line
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }
}