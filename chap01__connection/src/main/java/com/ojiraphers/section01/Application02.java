package main.java.com.ojiraphers.section01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application02 {

    public static void main(String[] args) {
        String driver = "driver=com.mysql.cj.jdbc.Driver";
        String url = "url=jdbc:mysql://localhost:3306/employee";
        String user = "guro";
        String password = "guro";
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

