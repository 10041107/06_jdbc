/*
이 클래스는
데이터베이스에서 메뉴에 관련된 작업을 수행하는 DAO(Data Access Object) 클래스입니다.
이 클래스의 메소드들은
메뉴의 조회, 등록 등을 담당합니다.
*/

package com.ohgiraffers.restaurant.model.dao; // 패키지 선언

import com.ohgiraffers.restaurant.model.dto.MenuDTO; // 메뉴 정보를 담는 DTO
import com.ohgiraffers.restaurant.model.vo.MenuVo; // 메뉴 정보를 담는 VO

import java.io.FileInputStream; // 파일의 내용을 바이트 단위로 읽어오는 클래스
import java.io.IOException; // 입출력 예외 처리를 위한 클래스
import java.sql.*; // SQL 처리를 위한 클래스들
import java.util.ArrayList; // ArrayList 클래스
import java.util.List; // List 클래스
import java.util.Properties; // 프로퍼티 값들을 처리하기 위한 클래스
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*; // JDBCTemplate 클래스의 static 메소드를 import

public class MenuDAO { // 메뉴 DAO 클래스 선언

    Properties prop =  new Properties(); // Properties 객체 생성

    public MenuDAO(String url) { // 클래스 생성자
        try {
            prop.loadFromXML(new FileInputStream(url)); // XML 파일을 읽어와 Properties 객체에 저장
        } catch (IOException e) { // 입출력 예외 처리
            e.printStackTrace();
        }
    }

    public List<MenuVo> findAllMenu(Connection con){ // 모든 메뉴를 조회하는 메소드
        Statement stmt = null; // SQL 문장을 실행하기 위한 객체
        ResultSet rset = null; // SQL 쿼리의 결과를 담는 객체
        List<MenuVo> resultList = new ArrayList<>(); // 결과를 담을 리스트 객체 생성
        // SQL 문장 실행 및 결과 처리 코드
        // 최종적으로 조회된 메뉴 리스트를 반환
        return resultList;
    }

    /**
     * 카테고리 코드가 존재하는지 확인한다.
     * @param  con Connection
     * @return List<Integer>
     * */
    public List<String> findAllCategoryCode(Connection con) { // 모든 카테고리 코드를 조회하는 메소드
        Statement stmt = null; // SQL 문장을 실행하기 위한 객체
        ResultSet rset = null; // SQL 쿼리의 결과를 담는 객체
        List<String> resultList = new ArrayList<>(); // 결과를 담을 리스트 객체 생성
        // SQL 문장 실행 및 결과 처리 코드
        // 최종적으로 조회된 카테고리 코드 리스트를 반환
        return resultList;
    }

    public int registMenu(Connection con, MenuDTO menuDTO) { // 메뉴를 등록하는 메소드
        PreparedStatement stmt = null; // SQL 문장을 실행하기 위한 객체
        int result = 0; // 결과를 담을 변수
        // SQL 문장 실행 및 결과 처리 코드
        // 최종적으로 등록된 메뉴의 개수를 반환
        return result;
    }
}
