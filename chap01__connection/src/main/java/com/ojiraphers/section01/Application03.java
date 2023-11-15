package main.java.com.ojiraphers.section01;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application03 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/ojiraphers/config/connection-info.properties"));
            System.out.println(prop.getProperty("driver"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url"); // db connection path
            String user = prop.getProperty("user"); // db id
            String password = prop.getProperty("password"); // id password

            // Now you can use the retrieved properties for the database connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}