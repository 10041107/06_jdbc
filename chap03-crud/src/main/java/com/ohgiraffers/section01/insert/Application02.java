package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application02 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmtInsert = null;
        PreparedStatement pstmtSelect = null;
        ResultSet rset = null;
        Properties props = new Properties();

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴를 입력하세요: ");
        String menu = sc.nextLine();

        try {
            con = getConnection();
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));

            try {
                pstmtInsert = con.prepareStatement(props.getProperty("insertMenu"));
                pstmtInsert.setString(1, menu);
                int rowsAffected = pstmtInsert.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("메뉴가 등록되었습니다");
                } else {
                    System.out.println("메뉴가 등록되지 않았습니다. 다시 실행해주세요.");
                }

                pstmtSelect = con.prepareStatement("SELECT * FROM TBL_MENU WHERE MENU_NAME = ?");
                pstmtSelect.setString(1, menu);
                System.out.println(pstmtSelect);

                rset = pstmtSelect.executeQuery();
                while (rset.next()) {
                    System.out.println(rset.getString("MENU_ID") + " " + rset.getString("MENU_NAME"));
                }

            } catch (SQLException ex) {
                throw new RuntimeException("Error", ex);
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmtInsert);
            close(pstmtSelect);
            close(con);
        }
    }
}
