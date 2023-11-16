package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import  static com.ohgiraffers.common.JDBCTemplate.*;
public class Application01 {

    public static void main(String[] args){
        Connection con = null;
        try {
            con = getConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;
        int result= 0;
        Properties props = new Properties();
        ResultSet rset = null;
        try {
            props.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            System.out.println(props.getProperty("insertMenu"));

            pstmt = con.prepareStatement(props.getProperty("insertMenu"));
            pstmt.setString(1,"손가락맛 순대국밥");
            pstmt.setInt(2, 8000);
            pstmt.setInt(3,4);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();


            pstmt = con.prepareStatement("SELECT * FROM TBL_MENU WHERE MENU_NAME ='손가락맛 순대국밥'");
            System.out.println(pstmt);
            rset = pstmt.executeQuery();
            while (rset.next()){
                System.out.println(rset.getString(1) + " " + rset.getString(2) );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(pstmt);
            close(rset);
        }
    }
}
