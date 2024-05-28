package org.example;

import java.time.LocalDate;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Lapte", 5, 25.5, true, LocalDate.of(2024, 6, 3)));
        products.add(new Product("Fanta", 10, 15.0, false, LocalDate.of(2034, 4, 30)));
        products.add(new Product("Suc", 13, 28.66, true, LocalDate.of(2024, 11, 15)));
        products.add(new Product("Snickers", 15, 27.3, true, LocalDate.of(2023, 12, 31)));

        ProductService ps = new ProductService(products);

        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tMeniu ");
            System.out.println("1. Filtrare dupa pret");
            System.out.println("2. Sortare dupa nume");
            System.out.println("3. Grupare dupa cantitate");
            System.out.println("4. Valoarea totala a stock-ului");
            System.out.println("5. Cel mai scump produs");
            System.out.println("6. Produse care au data de expirare in viitor");
            System.out.println("7. Parasiti aplicatia");

            Scanner sc = new Scanner(System.in);

            int key = sc.nextInt();

            switch(key) {
                case 1: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nIntrodu pret min si max: ");
                    double minPrice, maxPrice;
                    minPrice = sc.nextDouble();
                    maxPrice = sc.nextDouble();

                    products = ps.filterProdsByPrice(minPrice, maxPrice);

                    int i = 0;
                    for (Product product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                           + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 2: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nSortare dupa nume: ");

                    products = ps.sortProdsByName();

                    int i = 0;
                    for (Product product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 3: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nGrupare dupa cantitate: ");

                    Map<String, Integer> productsMap = new HashMap<>();
                    productsMap = ps.groupProdsByQuantity();

                    int i = 0;
                    for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                        String productName = entry.getKey();
                        Integer quantity = entry.getValue();
                        System.out.println(++i + ". " + productName + " " + quantity);
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 4: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nValoarea totala a stock-ului: ");

                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println(df.format(ps.totalStockValue()) + " lei");

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 5: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nCel mai scump produs: ");

                    Product mostExpensive = ps.mostExpensiveProd();

                    System.out.println(mostExpensive.getName() + " " + mostExpensive.getPrice() + "lei");

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 6: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nProduse care au data de expirare in viitor: ");

                    products = ps.getProdsWithFutExpDate();

                    int i = 0;
                    for (Product product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 7: {
                    System.exit(0);
                }

                default: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nIntroduceti cheia corecta!!! (1...7)");
                }
            }
        }
    }
}
