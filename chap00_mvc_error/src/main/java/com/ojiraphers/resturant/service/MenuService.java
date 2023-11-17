package com.ojiraphers.resturant.service;

import com.ojiraphers.resturant.model.dao.MenuDAO;
import com.ojiraphers.resturant.model.dto.MenuDTO;
import com.ojiraphers.resturant.model.vo.MenuVo;
import static com.ojiraphers.resturant.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class MenuService {

    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = menuDAO;
    }

    public List<MenuVo> findMenu() {
        //1. db연결
        Connection con = getConnection();
        //2. business logic ex) price > 0
        List<MenuVo> list = menuDAO.findAllMenu(con);
        close((Statement) con);
        return list;


    }

    public List<Integer> registMenu(MenuDTO menuDTO){
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        if(!category.contains(menuDTO.getCategory())){
            return 0;
        }
        if (menuDTO.getPrice() <= 1000){
            return 0;
        }
        List<Integer> result = menuDTO.registMenu(con, menuDTO);

        close((Statement) con);
        return result;



    }
}
