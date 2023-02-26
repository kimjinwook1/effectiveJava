package hello.effectivejava.Chap2_객체_생성과_파괴.item3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnection {
    //열거 타입 방식의 싱글턴
    INSTANCE;

    private final Connection connection;

    private DatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "test";
            String password = "test";

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("MYSQL DB 연결에 실패하였습니다. : ", e);
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
