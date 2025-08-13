import dao.ProductDAO;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n OrderEase Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(name, price);
                    productDAO.addProduct(product);
                    break;

                case 2:
                    List<Product> products = productDAO.getAllProducts();
                    System.out.println("\n📋 Product List:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("👋 Exiting OrderEase. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid option. Try again.");
            }
        }
    }
}