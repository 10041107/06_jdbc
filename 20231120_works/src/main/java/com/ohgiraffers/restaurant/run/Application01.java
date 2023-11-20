/*
이 클래스는 메뉴 관리 어플리케이션의 시작점입니다.
메인 메소드에서
MenuView 클래스의 runApplication 메소드를 호출하여 어플리케이션을 시작합니다.
 */

package com.ohgiraffers.restaurant.run; // 패키지 선언

import com.ohgiraffers.restaurant.view.MenuView; // 메뉴 뷰 클래스를 import

/**
 * 메뉴 관리 어플리케이션 만들기
 * */
public class Application01 { // 메인 클래스 선언
    public static void main(String[] args){ // 메인 메소드 선언
        MenuView.runApplication(); // 메뉴 관리 어플리케이션 시작 메소드 호출
    }
}