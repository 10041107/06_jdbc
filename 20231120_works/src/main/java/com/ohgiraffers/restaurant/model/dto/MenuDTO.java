/*
이 클래스는
메뉴 정보를 담는 DTO(Data Transfer Object) 클래스로,
메뉴 이름, 가격, 카테고리, 상태 등의 정보를 담고 있습니다.
이 클래스의 인스턴스는
메뉴 정보를 다루는 작업에서 데이터 전달용으로 사용됩니다.
 */

package com.ohgiraffers.restaurant.model.dto; // 패키지 선언

public class MenuDTO { // 메뉴 정보를 담는 DTO(Data Transfer Object) 클래스 선언

    private String menuName; // 메뉴 이름
    private int price; // 메뉴 가격
    private String category; // 메뉴 카테고리
    private String status; // 메뉴 상태

    public MenuDTO() { // 기본 생성자
    }

    public MenuDTO(String menuName, int price, String category, String status) { // 매개변수가 있는 생성자
        this.menuName = menuName; // 메뉴 이름 초기화
        this.price = price; // 메뉴 가격 초기화
        this.category = category; // 메뉴 카테고리 초기화
        this.status = status; // 메뉴 상태 초기화
    }

    // 각 필드에 대한 getter와 setter 메소드들


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
    public String toString() { // 객체를 문자열로 표현하는 메소드
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
