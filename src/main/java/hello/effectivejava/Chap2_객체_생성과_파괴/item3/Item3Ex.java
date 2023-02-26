package hello.effectivejava.Chap2_객체_생성과_파괴.item3;

import java.sql.Connection;
import java.util.function.Supplier;

public class Item3Ex {

    public static void main(String[] args) {
        // 정적 팩토리 메서드 방식의 싱글턴
        // RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();// 컴파일 에러, 생성자가 private이므로 인스턴스 생성 불가
        Supplier<Integer> randomNumberSupplier = RandomNumberGenerator::generateRandomNumber;

        // 열거 타입 방식의 싱글턴
        // DatabaseConnection databaseConnection = new DatabaseConnection(); // 컴파일 에러, 생성자가 private이므로 인스턴스 생성 불가
        final Connection connection = DatabaseConnection.INSTANCE.getConnection();
    }
}
