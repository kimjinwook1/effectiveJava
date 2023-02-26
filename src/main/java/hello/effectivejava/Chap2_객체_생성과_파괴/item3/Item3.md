# private 생성자나 열거 타입으로 싱글턴임을 보증하라
싱글턴(singleton)이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.
클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다.

## 1. public static final 필드 방식의 싱글턴

```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
   
    public void leaveTheBuilding() { ... }
}
```

- public static final 필드 방식의 싱글턴은 간결하고, API를 바꾸지 않고는 싱글턴이 아니게 변경할 수 없다.
- 하지만, 이 방식은 리플렉션 API인 `AccessibleObject.setAccessible`를 사용해 private 생성자를 호출할 수 있으므로, 싱글턴이 아니게 만들 수 있다.
- 해당 클래스가 싱글턴임이 API에 명백히 드러난다.

## 2. 정적 팩터리 방식의 싱글턴

```java
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public static Elvis getInstance() { return INSTANCE; }
   
    public void leaveTheBuilding() { ... }
}
```

- 정적 팩터리 방식의 싱글턴은 API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
- 정적 팩터리를 제네릭 싱글턴 팩터리로 만들수 있다는 점이다.
- 정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다는 점이다.
  - `Supplier<Elvis> elvisSupplier = Elvis::getInstance;`

## 3. 열거 타입 방식의 싱글턴
    
```java
    public enum Elvis {
        INSTANCE;
        public void leaveTheBuilding() { ... }
    }
```

- 열거 타입은 싱글턴을 만드는 가장 좋은 방법이다.
- 싱글턴을 만드는 방법 중 가장 간결하고, 추가 노력 없이 직렬화할 수 있고, 리플렉션 공격에도 안전하다.
- 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
