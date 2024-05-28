package org.example;
import java.time.LocalDate;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private boolean available;
    private LocalDate expirationDate;

    public Product(String name, int quantity, double price, boolean available, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.available = available;
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailable() {
        return available;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}