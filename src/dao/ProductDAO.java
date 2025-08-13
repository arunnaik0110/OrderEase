package dao;

import db.DBConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Add a product using Oracle sequence for ID
    public void addProduct(Product product) {
        String query = "INSERT INTO products (id, name, price) VALUES (product_seq.NEXTVAL, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());

            stmt.executeUpdate();
            System.out.println(" Product added successfully.");
        } catch (SQLException e) {
            System.out.println(" Error adding product: " + e.getMessage());
        }
    }

    // Fetch all products from the database
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching products: " + e.getMessage());
        }

        return products;
    }
}