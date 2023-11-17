/*
이 클래스는 JDBC를 이용해
데이터베이스와 연결을 관리하고, SQL 질의를 종료하며,
결과 집합을 종료하는 메소드들을 포함하고 있습니다.
 */

package com.ohgiraffers.restaurant.common; // 패키지 선언

import java.io.FileReader; // 파일 읽기를 위한 클래스
import java.io.IOException; // 입출력 예외 처리를 위한 클래스
import java.sql.*; // SQL 처리를 위한 클래스들
import java.util.Properties; // 프로퍼티 값들을 처리하기 위한 클래스

public class JDBCTemplate { // JDBCTemplate 클래스 선언

    public static Connection getConnection(){ // DB 연결을 위한 메소드
        Properties prop = new Properties(); // Properties 객체 생성
        Connection con = null; // DB 연결 객체 초기화
        try {
            prop.load(new FileReader("src/main/resources/config/connection-info.properties")); // 프로퍼티 파일 로드
            String driver = prop.getProperty("driver"); // 드라이버 정보 가져오기
            String url = prop.getProperty("url"); // DB URL 정보 가져오기
            con = DriverManager.getConnection(url, prop); // DB 연결 시도
        } catch (IOException e) { // 파일 입출력 예외 처리
            throw new RuntimeException(e);
        } catch (SQLException e) { // SQL 예외 처리
            throw new RuntimeException(e);
        }

        return con; // DB 연결 객체 반환
    }

    public static void close(Connection con ){ // DB 연결 종료 메소드
        try {
            con.close(); // 연결 종료
        } catch (SQLException e) { // SQL 예외 처리
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement statement ){ // SQL 문장 종료 메소드
        try {
            statement.close(); // 문장 종료
        } catch (SQLException e) { // SQL 예외 처리
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){ // 결과 집합 종료 메소드
        try {
            rset.close(); // 결과 집합 종료
        } catch (SQLException e) { // SQL 예외 처리
            throw new RuntimeException(e);
        }
    }
}
