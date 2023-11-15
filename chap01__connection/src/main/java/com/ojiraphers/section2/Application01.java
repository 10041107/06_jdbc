package main.java.com.ojiraphers.section2;

import java.sql.Connection;

import static main.java.com.ojiraphers.section2.JDBCTemplate.close;
import static main.java.com.ojiraphers.section2.JDBCTemplate.getConnection;

public class Application01 {

    public static void main(String[] args) {

        Connection con = getConnection();

        System.out.println(con);
        close(con);

    }




}
