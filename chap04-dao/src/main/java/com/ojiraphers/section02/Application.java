package com.ojiraphers.section02;

import com.ojiraphers.section02.controller.MenuController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuController menu = new MenuController();

        loop: while (true) {
            System.out.println("사용할 기능을 선택해주세요");
            System.out.println("1. 가장 최근에 등록된 메뉴");
            System.out.println("2. 모든 카테고리 메뉴");
            System.out.println("3. 매뉴 등록");
            System.out.println("9. 프로그램 종료");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menu.findMaxCode();
                    break;
                case 2: menu.FindCategory(); break;
                case 3: menu.insertMenu(); break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    break loop;
            }
        }
    }
}
