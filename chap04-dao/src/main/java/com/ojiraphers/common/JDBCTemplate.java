package com.ojiraphers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

    private static Connection con;


    public static Connection getConnection() {
        Properties pros = new Properties();
        try {
            if (con == null || con.isClosed() ) {

                try {
                    pros.load(new FileReader("src/main/resources/config/connection-info.properties"));
                    String driver = pros.getProperty("driver");
                    String url = pros.getProperty("url");
                    Class.forName(driver);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
    
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }


//    public static Connection getConnection2() {
//        Connection con2 = null;
//        Properties pros = new Properties();
//
//        if (con2 == null) {
//
//            try {
//                pros.load(new FileReader("src/main/resources/config/connection-info.properties"));
//                String driver = pros.getProperty("driver");
//                String url = pros.getProperty("url");
//                Class.forName(driver);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//
//        return con;
//    }

    public static void close(Connection connection){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}