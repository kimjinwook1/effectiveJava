package hello.effectivejava.Chap2_객체_생성과_파괴.item3;

import java.util.function.Supplier;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {}
    
    public static int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
