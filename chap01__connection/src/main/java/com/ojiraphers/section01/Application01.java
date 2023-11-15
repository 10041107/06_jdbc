package main.java.com.ojiraphers.section01;

import java.sql.*;

public class Application01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection con = null;

//        Driver driver = new OracleDriver();
//        driver = new com.mysql.jdbc.Driver();

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "guro", "guro");
            System.out.println(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

