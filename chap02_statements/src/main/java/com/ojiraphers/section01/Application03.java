package com.ojiraphers.section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Stack;

import static com.ojiraphers.common.JDBCTemplate.*;

public class Application03 {

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Scanner scanner = new Scanner(System.in);

        try {
            stmt = con.createStatement();
            System.out.println("조회하고자 하는 이름을 입력해주세요");
            String empname = scanner.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME = '" + empname + "'";


            rset = stmt.executeQuery(query);
            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(stmt);
            close(rset);
            scanner.close();
        }


    }


}



