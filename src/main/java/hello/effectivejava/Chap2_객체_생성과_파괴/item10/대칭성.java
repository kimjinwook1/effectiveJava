package hello.effectivejava.Chap2_객체_생성과_파괴.item10;

import java.util.Objects;

public class 대칭성 {

    private final String s;

    public 대칭성(String s){
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위배 -> 한방향으로만 작동한다.
    // String a = "Hello"; 대칭성 b = new 대칭성("Hello");
    // a.equals(b) -> true, b.equals(a) -> false
    @Override public boolean equals(Object o){
        if(o instanceof 대칭성)
            return s.equalsIgnoreCase(((대칭성) o).s);
        if(o instanceof String) // 한방향으로만 작동한다.
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}
