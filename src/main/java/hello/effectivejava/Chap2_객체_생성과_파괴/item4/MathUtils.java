package hello.effectivejava.Chap2_객체_생성과_파괴.item4;

public class MathUtils {
    private MathUtils() {} // private 생성자를 통해 인스턴스 생성을 막는다.

    public static int factorial(int n) {
        // n! = 1 * 2 * 3 * ... * n
        if (n < 0) {
            throw new IllegalArgumentException("n은 0보다 커야 합니다.");
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        // 유클리드 호제법 (최대 공약수 구하는 방법)
        // a와 b의 최대공약수는 b와 a를 b로 나눈 나머지 r의 최대공약수와 같다.
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
