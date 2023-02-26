package hello.effectivejava.Chap2_객체_생성과_파괴.item4;

public class Item4Example {

    public static void main(String[] args) {
        //MathUtils utils = new MathUtils(); // 컴파일 에러, 생성자가 private이므로 인스턴스 생성 불가
        final int result = MathUtils.factorial(5);
        final int gcd = MathUtils.gcd(10, 5);
    }
}
