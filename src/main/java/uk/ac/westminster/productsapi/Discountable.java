package uk.ac.westminster.productsapi;

public interface Discountable {
    void applyDiscount(double rate);
    double getDiscountedPrice();
}