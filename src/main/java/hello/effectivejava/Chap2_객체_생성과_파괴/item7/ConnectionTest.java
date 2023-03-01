package hello.effectivejava.Chap2_객체_생성과_파괴.item7;

import hello.effectivejava.Chap2_객체_생성과_파괴.item7.connection.CacheDatabaseManager;
import hello.effectivejava.Chap2_객체_생성과_파괴.item7.connection.Connection;
import hello.effectivejava.Chap2_객체_생성과_파괴.item7.connection.CustomDatabaseManager;
import hello.effectivejava.Chap2_객체_생성과_파괴.item7.vo.DBConnection;

public class ConnectionTest {

    public static void main(String[] args) {
        final CustomDatabaseManager customDatabaseManager = new CustomDatabaseManager(new Connection() {
            @Override
            public DBConnection getDBConnection() {
                return new DBConnection();
            }
        });

        customDatabaseManager.execute("SELECT * FROM TABLE");

        // 기존 Connection 을 null 처리
        customDatabaseManager.deconnect();

        // WeakHashMap을 사용한 CacheDatabaseManager
        final CacheDatabaseManager cacheDatabaseManager = new CacheDatabaseManager(new Connection() {
            @Override
            public DBConnection getDBConnection() {
                return new DBConnection();
            }
        });

        cacheDatabaseManager.execute("SELECT * FROM TABLE");
        // CacheDatabaseManager는 WeakHashMap을 사용하고 있기 때문에 Connection을 null 처리하지 않아도 된다.
    }

}
