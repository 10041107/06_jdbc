/*
이 클래스는
사용자의 요청을 받아 유효성 체크를 하고 요청을 service로 전달하며,
이후 service의 반환 값을 페이지로 반환하는 역할을 합니다.
 */

package com.ohgiraffers.restaurant.controller; // 패키지 선언

import com.ohgiraffers.restaurant.model.dto.MenuDTO; // 메뉴 정보를 담는 DTO
import com.ohgiraffers.restaurant.model.vo.MenuVo; // 메뉴 정보를 담는 VO
import com.ohgiraffers.restaurant.service.MenuService; // 메뉴 관련 서비스

import java.util.List; // List 클래스
import java.util.Objects; // 객체 비교를 위한 Objects 클래스

/*
 * 사용자의 요청을 받아
 * 유효성 체크를 하고 요청을 service로 전달하고
 * 이후 service의 반환 값을 페이지로 반환한다.
 * */
public class MenuCtr { // 메뉴 컨트롤러 클래스 선언

    private MenuService menuService; // 메뉴 서비스 객체

    public MenuCtr(MenuService menuService) { // 생성자
        this.menuService = menuService; // 메뉴 서비스 객체 초기화
    }

    public List<MenuVo> findAllMenu(){ // 모든 메뉴 조회 메소드
        // 값을 확인한다.
        List<MenuVo> list = menuService.findMenu(); // 서비스를 통해 메뉴 조회

        // 반환값 확인 후 응답 값을 지정
        if(Objects.isNull(list)){ // 메뉴가 없다면
            return null; // null 반환
        }

        return list; // 메뉴 리스트 반환
    }

    public int modifyMenu(int code){ // 메뉴 수정 메소드
        System.out.println("modify code : " + code); // 수정할 메뉴의 코드 출력
        return 0;
    }

    public String registMenu(MenuDTO menuDTO){ // 메뉴 등록 메소드
        // 다양한 유효성 검사 후
        // 메뉴 등록 요청을 서비스로 전달

        int result = menuService.registMenu(menuDTO); // 메뉴 등록 결과

        if(result <= 0){ // 등록 실패
            return "등록중 오류가 발생됨"; // 오류 메시지 반환
        }else{ // 등록 성공
            return "등록완료"; // 성공 메시지 반환
        }
    }

    public String DeleteMenu(MenuDTO menuDTO){ // 메뉴 삭제 메소드
        int result = menuService.registMenu(menuDTO); // 메뉴 등록 결과

        if(result <= 0){ // 등록 실패
            return "등록중 오류가 발생됨"; // 오류 메시지 반환
        }else{ // 등록 성공
            return "등록완료"; // 성공 메시지 반환
        }
    }
}
