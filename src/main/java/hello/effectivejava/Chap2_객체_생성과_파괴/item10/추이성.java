package hello.effectivejava.Chap2_객체_생성과_파괴.item10;

import java.awt.*;

public class 추이성 {

    public static void main(String args[]) {
        ColorPoint p1 = new ColorPoint(1, 2, "RED");
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, "BLUE");
        final boolean 컬러포인트와_포인트의_x_y가_같다 = p1.equals(p2);// true
        System.out.println("컬러포인트와_포인트의_x_y가_같다면_두_변수는_같다 = " + 컬러포인트와_포인트의_x_y가_같다);
        final boolean 포인트와_컬러포인트의_x_y가_같다 = p2.equals(p3);// true
        System.out.println("포인트와_컬러포인트의_x_y가_같다면_두_변수는_같다 = " + 포인트와_컬러포인트의_x_y가_같다);
        final boolean 컬러포인트와_컬러포인트의_x_y가_같고_색상은_다르면_두_변수는_다르다 = p1.equals(p3);// false
        System.out.println("컬러포인트와_컬러포인트의_x_y가_같고_색상은_다르면_두_변수는_다르다 = " + 컬러포인트와_컬러포인트의_x_y가_같고_색상은_다르면_두_변수는_다르다);

    }
}
