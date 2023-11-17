package com.ojiraphers.section02.model.dao;

import com.ojiraphers.section02.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.ojiraphers.common.JDBCTemplate.close;

public class MenuDAO {

    private Properties prop = new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLastMenuCode(Connection con) {
        Statement statement = null;
        ResultSet rset = null;
        int maxCode = 0;

        String query = prop.getProperty("selectMenuCode");
        try {
            statement = con.createStatement();
            rset = statement.executeQuery(query);
            if (rset.next()) {
                maxCode = rset.getInt("MAX(A.MENU_CODE)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(statement);
            close(con);
        }

        return maxCode;
    }

    public List<Map<Integer, String>> selectAllCategory(Connection con) {
        Statement statement = null;
        ResultSet rset = null;
        List<Map<Integer, String>> categoryList = new ArrayList<>();

        String query = prop.getProperty("selectAllCategoryList");
        try {
            statement = con.createStatement();
            rset = statement.executeQuery(query);
            while (rset.next()) {
                Map<Integer, String> category = new HashMap<>();
                category.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(statement);
            close(con);
        }
        return categoryList;
    }

    public int insertMenu(Connection con, MenuDTO menuDTO) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setInt(2, menuDTO.getPrice());
            pstmt.setString(3, menuDTO.getCategoryCode());
            pstmt.setString(4, menuDTO.getStatus());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
        return result;
    }
}
