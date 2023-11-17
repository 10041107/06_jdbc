/*
이 클래스는 메뉴 정보를 담는 VO(Value Object) 클래스로,
메뉴 코드, 메뉴 이름, 가격, 카테고리, 상태 등의 정보를 담고 있습니다.
이 클래스의 인스턴스는 주로
데이터베이스에서 조회한 메뉴 정보를 담는 데 사용됩니다.
 */
/*
DTO(Data Transfer Object):
데이터 전송 객체로, 계층간 데이터 교환을 위해 사용됩니다.
일반적으로 사용자의 요청 형태나 응답 형태, 또는 서비스 레이어와 데이터 접근 레이어 간에 데이터를 전달하는 데 사용됩니다.
예를 들어, 웹 어플리케이션에서 클라이언트가 서버에 데이터를 요청할 때,
그 요청 정보를 담은 객체가 DTO입니다.

VO(Value Object):
값 객체로, 실제 비즈니스 도메인을 표현하는 객체입니다.
VO는 변경 불가능하며, 동일성이 아닌 동등성을 기반으로 비교됩니다.
즉, VO의 모든 값(필드)이 같으면 같은 객체로 취급합니다.
예를 들어, 데이터베이스에서 조회한 결과를 표현하는 객체가 VO입니다.

본 코드에서 MenuDTO는 사용자의 요청 정보나 응답 정보를 표현하는 데 사용되며,
MenuVO는 데이터베이스에서 조회한 메뉴 정보를 표현하는 데 사용됩니다.
이는 한 가지 일반적인 패턴일 뿐,
실제로는 개발자나 팀의 컨벤션에 따라 DTO와 VO의 사용 방식이 다르게 적용될 수 있습니다.

 */

package com.ohgiraffers.restaurant.model.vo; // 패키지 선언

public class MenuVo { // 메뉴 정보를 담는 VO(Value Object) 클래스 선언

    private int menuCode; // 메뉴 코드
    private String menuName; // 메뉴 이름
    private int price; // 메뉴 가격
    private String category; // 메뉴 카테고리
    private String status; // 메뉴 상태

    public MenuVo() { // 기본 생성자
    }

    public MenuVo(int menuCode, String menuName, int price, String category, String status) { // 매개변수가 있는 생성자
        this.menuCode = menuCode; // 메뉴 코드 초기화
        this.menuName = menuName; // 메뉴 이름 초기화
        this.price = price; // 메뉴 가격 초기화
        this.category = category; // 메뉴 카테고리 초기화
        this.status = status; // 메뉴 상태 초기화
    }

    // 각 필드에 대한 getter와 setter 메소드들

    @Override
    public String toString() { // 객체를 문자열로 표현하는 메소드
        return "MenuVo{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
