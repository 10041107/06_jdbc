package com.ojiraphers.section03;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ojiraphers.common.JDBCTemplate.*;

public class Application01 {
    public static void main(String[] args) {
        /*
        transaction
        데이터베이스 모든트렌지션의 묶음 : 롤백을 시키기 위한 백업기록
         */

        Connection con = getConnection();
        try {
            con.setAutoCommit(false);
//            insert 1
//            if(result < 0){
//                con.rollback();
//            }
//            insert 2
//            insert 3
//             ======= 스킵됨
            con.commit();
            System.out.println("autocommit의 전체 값 : ");

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }


    }


}


// m:모델계층 d:데이터베이스엑세스계층 v:뷰=사용자상호작용(서비스)계층
// mvc페턴, 싱글톤페턴...