package hello.effectivejava.Chap2_객체_생성과_파괴.item1;

import java.sql.Connection;
import java.sql.SQLException;

public class Item1Ex {

    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcExample.getConnection();

    }
}
