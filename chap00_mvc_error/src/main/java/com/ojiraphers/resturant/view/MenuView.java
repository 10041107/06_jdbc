package com.ojiraphers.resturant.view;

import com.ojiraphers.resturant.controller.MenuCtr;
import com.ojiraphers.resturant.model.dto.MenuDTO;
import com.ojiraphers.resturant.model.vo.MenuVo;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    /*
    view계층을 예시로 만듬
    이후 해당 페이지는 html로 변경됨
     */
    public static void runApplication(){
        Scanner sc = new Scanner(System.in);
        MenuCtr menuCtr = new MenuCtr(new MenuView());


        프로그램: while (true){
            System.out.println("메뉴 관리 프로그램입니다.");
            System.out.println("1.조회 \n 2.수정 \n 3.등록 \n 4,삭제");
            System.out.println("원하는 기능을 입력해주세요 :");

        // 1. 사용자가 원하는 기능을 선택함 - while로 반복되는 어플리케이션을 만듬. 실행할까요?true일시 계속하므로
        int step = sc.nextInt();
        // 2. 기능에 따라 동작됨

            switch (step){
//                2-1: 메뉴 조회 = indAllmenu메뉴 전체를 입력한다
                case 1 : viewMenu(menuCtr.findAllmenu()); break;

//                2-2: 메뉴 수정
                case 2 : break;

//                2-3: 메뉴 등록
                case 3 :
                    System.out.println(menuCtr.registMenu(registMenu())); break;

//                2-4: 메뉴 삭제
                case 4 : break;

//                default: 프로그램 종료
                default: break 프로그램;
            }

        }

    }

    public  static void viewMenu (List<MenuVo> menuList){
        if(Objects.isNull(menuList)){ // int인지 확인
            System.out.println("조회중 오류가 발생됨");
        }else if(menuList.size() < 0){
            System.out.println("등록된 메뉴가 없습니다.");
        }else {
            for (MenuVo menu:menuList){
                System.out.println(menu);
            }
        }
    }

    public static MenuDTO registMenu(){
        MenuDTO newMenu = new MenuDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("=============");
        System.out.println();
        System.out.println("등록할 메뉴 이름: [문자] ");
        newMenu.setMenuName(sc.nextLine());
        System.out.println("등록할 가격: [숫자] ");
        newMenu.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println("카테고리 코드 이름: [문자] ");
        newMenu.setCategory(sc.nextLine());
        System.out.println("판매여부: [Y/N] ");
        newMenu.setStatus(sc.nextLine());

        // 일반적으로 front에서 js를 이용하여 1차 유효성 검사를 진행한다.

        return newMenu;

    }



}




