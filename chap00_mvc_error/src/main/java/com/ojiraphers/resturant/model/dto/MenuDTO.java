package com.ojiraphers.resturant.model.dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ojiraphers.resturant.common.JDBCTemplate.close;

public class MenuDTO {
    private String menuName;
    private int price;
    private String category;
    private String status;
    private Properties properties;

    public MenuDTO() {
    }

    public MenuDTO(String menuName, int price, String category, String status) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public List<Integer> registMenu(Connection con, MenuDTO menuDTO) {

        Statement stmt = null;
        ResultSet rset = null;
        List<Integer> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(properties.getProperty("findAllCategory"));

            while (rset.next()) {
                resultList.add(rset.getInt(1));
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