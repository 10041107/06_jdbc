/*
이 클래스는 메뉴 관리 어플리케이션의 사용자 인터페이스를 담당하는 뷰 클래스입니다.
이 클래스의 메소드들은 메뉴의 조회, 등록 등을 담당하며,
사용자로부터 입력을 받아 해당 기능을 수행합니다.
메뉴를 등록할 때는 사용자로부터 메뉴의 정보를 입력받아 등록합니다.
 */

package com.ohgiraffers.restaurant.view; // 패키지 선언

import com.ohgiraffers.restaurant.controller.MenuCtr; // 메뉴 컨트롤러 클래스 import
import com.ohgiraffers.restaurant.model.dto.MenuDTO; // 메뉴 DTO 클래스 import
import com.ohgiraffers.restaurant.model.vo.MenuVo; // 메뉴 VO 클래스 import
import com.ohgiraffers.restaurant.service.MenuService; // 메뉴 서비스 클래스 import

import java.util.List; // List 클래스 import
import java.util.Objects; // Objects 클래스 import
import java.util.Scanner; // Scanner 클래스 import

public class MenuView { // 메뉴 뷰 클래스 선언

    /*
     * view 계층을 예시로 만듬
     * 이후 해당 페이지는 html로 변경된다.
     * */
    public static void runApplication(){ // 어플리케이션 시작 메소드
        Scanner scanner = new Scanner(System.in);
        MenuCtr menuCnt = new MenuCtr(new MenuService("src/main/resources/mapper/menu-query.xml"));

        프로그램: while (true){ // 무한 루프로 메뉴를 계속 출력
            System.out.println("메뉴관리 프로그램입니다.");
            System.out.println(" 1. 조회
            2. 수정
            3. 등록
            4. 삭제");
            System.out.print("원하는 기능을 입력해주세요 :");

            //1. 사용자가 원하는 기능을 선택함
            int step = scanner.nextInt();

            //2. 기능에 따라 동작됨

            switch (step){ // 선택한 기능에 따라 동작
                //2-1 : 메뉴 조회
                case 1 : viewMenu(menuCnt.findAllMenu()); break;

                //2-2 : 메뉴 수정
                case 2 : break;

                //2-3 : 메뉴 등록
                case 3 : System.out.println(menuCnt.registMenu(registMenu())); break;

                //2-4 : 메뉴 삭제
                case 4 : break;

                //default : 프로그램 종료
                default: break 프로그램;
            }


        }
    }

    public static void viewMenu(List<MenuVo> menuList){ // 메뉴 리스트를 출력하는 메소드
        if(Objects.isNull(menuList)){ // 메뉴 리스트가 null인 경우
            System.out.println("조회중 오류가 발생됨");
        } else if (menuList.size() < 0) { // 메뉴 리스트가 비어있는 경우
            System.out.println("등록된 메뉴가 없네요~");
        }else{ // 메뉴 리스트 출력
            for (MenuVo menu:menuList) {
                System.out.println(menu);
            }
        }
    }

    public static MenuDTO registMenu(){ // 메뉴를 등록하는 메소드
        MenuDTO newMenu = new MenuDTO(); // 새 메뉴 객체 생성
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println();
        System.out.print("등록할 메뉴 이름을 입력해주세요 : " );
        newMenu.setMenuName(sc.nextLine());
        System.out.print("가격을 입력해주세요 : " );
        newMenu.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.print("카테고리 코드를 입력해주세요 : " );
        newMenu.setCategory(sc.nextLine());
        System.out.print("판매여부를 입력해주세요 : " );
        newMenu.setStatus(sc.nextLine());

        // 일반적으로 front에서 js를 이용하여 1차 유효성 검사를 진행한다.
        return newMenu; // 새 메뉴 반환
    }
}
