package hello.effectivejava.Chap2_객체_생성과_파괴.item5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LambdaFactory {
    private static final int TYPE_A = 1;
    private static final int TYPE_B = 2;
    private static final int TYPE_C = 3;
    private static final int TYPE_D = 4;

    // Supplier<? extends ITypeFactory>는 ITypeFactory를 상속받은 클래스를 반환한다.
    final static Map<Integer, Supplier<? extends ITypeFactory>> map = new HashMap<>();

    static {
        map.put(0, ITypeFactory::new);
        map.put(TYPE_A, A::new);
        map.put(TYPE_B, B::new);
        map.put(TYPE_C, C::new);
        map.put(TYPE_D, D::new);
        // A, B, C, D  클래스는 ITypeFactory를 상속받았기 때문에 ITypeFactory를 반환할 수 있다.
    }
}

class ITypeFactory {}

class A extends ITypeFactory {}

class B extends ITypeFactory {}

class C extends ITypeFactory {}

class D extends ITypeFactory {}
