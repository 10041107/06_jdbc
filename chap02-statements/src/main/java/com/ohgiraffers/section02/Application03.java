package com.ohgiraffers.section02;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static main.java.com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {

    public static void main(String[] args){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;


        Properties props = null;
        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            Scanner sc = new Scanner(System.in);
            System.out.println("등록할 메뉴를 입력해주세요 : ");
            String menu = sc.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME " +
                    " FROM EMPLOYEE " +
                    " WHERE EMP_NAME LIKE CONCAT(?, '%')";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu);
            System.out.println(pstmt + "메뉴가 등록되었습니다.");
            rset = pstmt.executeQuery();
            while (rset.next()){
                System.out.println(rset.getString(1) + " " + rset.getString(2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(rset);
            close(pstmt);
        }
    }
}
