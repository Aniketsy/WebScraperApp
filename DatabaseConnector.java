package com.webscraper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/WebScrapingDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void insertData(String title, String link) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO ScrapedData (title, link) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, link);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
