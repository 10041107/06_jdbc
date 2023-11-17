package com.ojiraphers.resturant.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    private static Connection con;

    public static Connection getConnection(){
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/resources/config/connection-info.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            con = DriverManager.getConnection(url,prop);
                } catch (SQLException e) {
                throw new RuntimeException(e);
                } catch (IOException e) {
                throw new RuntimeException(e);
              }
        return con;

    }
    public static void close(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
