/*
이 클래스는 메뉴에 관련된 비즈니스 로직을 수행하는 서비스 클래스입니다.
이 클래스의 메소드들은 메뉴의 조회, 등록 등을 담당합니다.
메뉴를 등록할 때는 입력된 카테고리와 가격을 검증하여 유효한 경우에만 메뉴를 등록합니다.
 */

package com.ohgiraffers.restaurant.service; // 패키지 선언

import com.ohgiraffers.restaurant.model.dao.MenuDAO; // 메뉴 DAO 클래스 import
import com.ohgiraffers.restaurant.model.dto.MenuDTO; // 메뉴 DTO 클래스 import
import com.ohgiraffers.restaurant.model.vo.MenuVo; // 메뉴 VO 클래스 import

import java.sql.Connection; // SQL 연결을 위한 클래스 import
import java.util.List; // List 클래스 import
import java.util.Objects; // Objects 클래스 import

import static com.ohgiraffers.restaurant.common.JDBCTemplate.*; // JDBCTemplate 클래스의 static 메소드를 import

public class MenuService { // 메뉴 서비스 클래스 선언

    private MenuDAO menuDAO; // 메뉴 DAO 객체를 담을 변수 선언

    public MenuService(String url) { // 클래스 생성자
        this.menuDAO = new MenuDAO(url); // 메뉴 DAO 객체 생성
    }

    public List<MenuVo> findMenu(){ // 모든 메뉴를 조회하는 메소드
        Connection con = getConnection(); // DB 연결
        List<MenuVo> list = menuDAO.findAllMenu(con); // 모든 메뉴 조회
        close(con); // DB 연결 해제
        return list; // 조회된 메뉴 리스트 반환
    }

    public int registMenu(MenuDTO menuDTO) { // 메뉴를 등록하는 메소드
        Connection con = getConnection(); // DB 연결
        List<String> category = menuDAO.findAllCategoryCode(con); // 모든 카테고리 코드 조회

        // 카테고리 검증
        if(!category.contains(menuDTO.getCategory())){
            return 0;
        }

        // 가격 검증
        if(menuDTO.getPrice() <= 1000){
            return 0;
        }

        int result = menuDAO.registMenu(con, menuDTO); // 메뉴 등록

        close(con); // DB 연결 해제

        return result; // 등록된 메뉴의 개수 반환
    }
}
