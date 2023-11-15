package com.ojiraphers.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ojiraphers.common.JDBCTemplate.*;

public class Application04 {

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        ResultSet rrset = null;

        try {
            stmt = con.createStatement();
            System.out.println("급여를 가장 많이 받는 사원");

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE ORDER BY SALARY DESC LIMIT 1 ");
            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
            }

            rrset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '선동일'");
            if (rrset.next()) {
                String jobCode = rrset.getString("JOB_CODE");

                System.out.println("사원 번호 : " + rrset.getString("EMP_ID"));
                System.out.println("사원 이름 : " + rrset.getString("EMP_NAME"));
                System.out.println("사원 전화번호 : " + rrset.getString("PHONE"));
                System.out.println("사원 이메일 : " + rrset.getString("EMAIL"));

                String jobTitleQuery = "SELECT JOB_NAME FROM JOB WHERE JOB_CODE = '" + jobCode + "'";
                ResultSet jobTitleResultSet = stmt.executeQuery(jobTitleQuery);

                if (jobTitleResultSet.next()) {
                    System.out.println("사원 직급: " + jobTitleResultSet.getString("JOB_NAME"));
                }

                close(jobTitleResultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rrset);
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
