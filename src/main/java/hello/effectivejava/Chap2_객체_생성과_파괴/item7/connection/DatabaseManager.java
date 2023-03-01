package hello.effectivejava.Chap2_객체_생성과_파괴.item7.connection;

import hello.effectivejava.Chap2_객체_생성과_파괴.item7.vo.ResultSet;

public interface DatabaseManager {
    ResultSet execute(final String query);
}
