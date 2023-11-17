package com.ojiraphers.resturant.controller;

import com.ojiraphers.resturant.model.dto.MenuDTO;
import com.ojiraphers.resturant.model.vo.MenuVo;
import com.ojiraphers.resturant.service.MenuService;
import com.ojiraphers.resturant.view.MenuView;

import java.util.List;
import java.util.Objects;

/*
사용자의 요청을 받아
유효성 체크 (사용자가 입력한 값이 유효한지를 검증함. ex.사용자가 코드를 안보냄: 오류값 출력하고 돌려보냄 등)
=정상적으로 돌리려면 서비스 로직에 맞는 값이 필요한데 니가 준 값이 맞냐? (int 입력란인데 String을 보낸다던가)
를 하고 요청을 service로 전달하고
이후 service의 반환 값을 페이지로 반환한다.
 */

public class MenuCtr {

    private MenuService menuService;

    public MenuCtr(MenuView menuView) {
        this.menuService = menuService;
    }

    public List<MenuVo> findAllmenu(){
        //값을 확인한다
        List<MenuVo> list = menuService.findMenu();

        // 반환값 확인 후 응답값을 지정
        if(Objects.isNull(list)){
            return null; // 널값 반환해라
        }
        return list; // 리스트의 값을 그대로 반환한다

    }

    public int modifyMenu(int code){
        System.out.println("modify code : " + code);
        return 0;
    }

    public String registMenu(MenuDTO menuDTO){
        if(Objects.isNull(menuDTO)){
            return "메뉴 정보가 존재하지 않음";
        }
        if (menuDTO.getMenuName() == null || menuDTO.getMenuName().equals("")){
            return "메뉴 이름을 등록해주세요";
        }
        if (menuDTO.getPrice() <= 0) {
            return "메뉴 가격은 음수일 수 없습니다.";
        }
        if(menuDTO.getMenuName() == null || menuDTO.getCategory().equals("")){ // 메뉴네임이 기본값(변경되지않음)이거나 공백이면
            return "카테고리를 입력해주세요";
        }
        if (menuDTO.getMenuName() == null || menuDTO.getStatus().equals("")){
            return "판매여부를 입력해주세요";
        }

        //유효성 검사가 끝난 메뉴
        int result = menuService.registMenu(menuDTO);

        if(result <= 0){
            return "등록중 오류가 발생됨";
        }else {
            return "등록완료";
        }
    }

    public int deleteMenu(int code) {
        System.out.println("code : " + code);
        return 0;
    }






}
