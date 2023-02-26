package hello.effectivejava.Chap2_객체_생성과_파괴.item1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DATABASE_USER = "test";
    private static final String DATABASE_PASSWORD = "test";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
