package com.ojiraphers.resturant.model.dao;

import com.ojiraphers.resturant.model.vo.MenuVo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ojiraphers.resturant.common.JDBCTemplate.close;

public class MenuDAO {

    private Properties properties;

    public MenuDAO(String url) {
        try {
            this.properties = new Properties();
            this.properties.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MenuVo> findAllMenu(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<MenuVo> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(properties.getProperty("findAllMenu"));

            while (rset.next()) {
                resultList.add(new MenuVo(
                        rset.getInt(1),
                        rset.getString(2),
                        rset.getInt(3),
                        rset.getString(4),
                        rset.getString(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return resultList;
    }

    /**
     * 카테고리 코드가 존재하는지 확인한다.
     * @param con
     * @return List<Integer>
     */
    public List<String> findAllCategoryCode(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(properties.getProperty("findAllCategory"));

            while (rset.next()) {
                resultList.add(rset.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return resultList;

    }
}
