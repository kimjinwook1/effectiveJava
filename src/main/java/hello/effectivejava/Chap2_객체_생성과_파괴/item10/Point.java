package hello.effectivejava.Chap2_객체_생성과_파괴.item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point p))
            return false;
        return p.x == x && p.y == y;
    }
}
