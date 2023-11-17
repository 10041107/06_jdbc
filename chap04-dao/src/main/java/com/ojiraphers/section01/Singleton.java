package com.ojiraphers.section01;

import java.sql.Connection;

import static com.ojiraphers.common.JDBCTemplate.getConnection;

public class Singleton {

    public static void main(String[] args) {


        Connection con = getConnection();
        Connection con2 = getConnection();

        System.out.println(con);
        System.out.println(con2);

        System.out.println("===============================");
        Connection con3 = getConnection();
        Connection con4 = getConnection();
        System.out.println(con3);
        System.out.println(con4);

    }


}
