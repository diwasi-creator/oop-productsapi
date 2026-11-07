package uk.ac.westminster.productsapi;

// A PhysicalProduct IS-A Product because it is a kind of product the shop sells, with a name and a price.
// ShoppingCart would NOT pass this test: a cart HAS products, it isn't one (HAS-A, so use a field).
public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);   // must be the first line
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price; // starts at the normal price
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | weight: " + weightKg;
    }

    // Shipping is never discounted, so the discount is capped at 20%.
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }
}