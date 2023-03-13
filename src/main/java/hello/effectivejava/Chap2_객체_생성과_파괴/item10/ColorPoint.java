package hello.effectivejava.Chap2_객체_생성과_파괴.item10;

import java.awt.*;

public class ColorPoint extends Point {

    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point))
            return false;
        if(!(o instanceof ColorPoint))
            return o.equals(this);
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
