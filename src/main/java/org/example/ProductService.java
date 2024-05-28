package org.example;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> filterProdsByPrice(double minPrice, double maxPrice) {
        return products.stream().filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    public List<Product> sortProdsByName() {
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    public Map<String, Integer> groupProdsByQuantity() {
        return products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getQuantity)));
    }

    public double totalStockValue() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public Product mostExpensiveProd() {
        return products.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public List<Product> getProdsWithFutExpDate() {
        return products.stream().filter(product -> product.getExpirationDate().isAfter(LocalDate.now())).collect(Collectors.toList());
    }
}