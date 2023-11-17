package com.ojiraphers.section02.controller;

import com.google.protobuf.MapField;
import com.ojiraphers.section02.model.dao.MenuDAO;
import com.ojiraphers.section02.model.dto.MenuDTO;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ojiraphers.common.JDBCTemplate.*;
public class MenuController {

    private MenuDAO menuDAO = new MenuDAO("src/main/resources/mapper/menu-query.xml");

    public void findMaxCode(){


        System.out.println(result);

    }

    public void FindCategory() {
        List<Map<Integer, String>> result = menuDAO.selectAllCategory(getConnection());
        for (Map<Integer, String> category : allCategory) {
            System.out.println(category.get(1));
        }
    }

    public void insertMenu(){
        MenuDTO menuDTO = new MenuDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴 이름을 입력해주세요");
        menuDTO.menuName(sc.nextLine());
        System.out.println("메뉴 가격을 입력해주세요");
        menuDTO.price(sc.nextInt());
        sc.nextLine();
        System.out.println("카테고리 번호를 입력해주세요");
        menuDTO.categoryCode(sc.nextLine());
        System.out.println("상태 코드를 입력해주세요");
        menuDTO.status(sc.nextLine());

        int result = menuDAO.insertMenu(getConnection(), menuDTO);
        if(result > 0) {
            System.out.println("메뉴 등록 성공");
        }else {
            System.out.println("메뉴 등록 실패");
        }


    }

}

