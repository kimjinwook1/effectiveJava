# equals는 일반 규약을 지켜 재정의하라

### equals를 재정의 하면 안 되는 경우

- 각 인스턴스가 본질적으로 고유할 때
값 클래스(Integer나 String처럼 값을 표현하는 클래스)가 아닌 동작하는 개체를 표현하는 클래스  
ex) Thread

- 인스턴스의 '논리적 통치성'을 검사할 일이 없을 때  
ex) java.util.regax.Pattern은 equals를 재정의해 두 Pattern의 정규표현식을 비교  

- 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞을 때  
ex) Set은 AbstractSet이 구현한 equals를 상속, List는 AbstractList, Map은 AbstractMap  

- 클래스가 private이나 package-private이고 equals를 호출할 일이 없을 때
아래와 같이 구현해 equals가 실수로라도 호출되는 걸 막을 수 있다.
```java
@Override public boolean equals(Object o) {
    throw new AssertionError(); // 호출 금지
}
```

### equals 메서드 재정의 일반 규약: 동치관계

- 동치 클래스(equivalent class): 집합을 서로 같은 원소들로 이루어진 부분집합으로 나누는 연산  
  → equals 메서드가 쓸모 있으려면 모든 원소가 같은 동치류에 속한 어떤 원소와도 교환이 가능해야 한다.

- 반사성(reflexivity)
  : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.

- 대칭성(symmetry)
  : null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.

- 추이성(transitivity)
  : null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고, y.equals(z)도 true면 x.equals(z)도 true다.

- 일관성(consistency)
  : null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true이거나 false다.

- null-아님
  : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.

## 정리: 양질의 `equals` 메서드 구현 방법

1. `==`연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.  
   자기 자신이면 `true`를 반환한다. 단순한 성능 최적화용으로 비교 작업이 복잡한 상황일 때 값어치를 한다.
2. `instanceof` 연산자로 입력이 올바른 타입인지 확인한다.  
   가끔 해당 클래스가 구현한 특정 인터페이스를 비교할 수도 있다.  
   이런 인터페이스를 구현한 클래스라면 `equals`에서 (클래스가 아닌) 해당 인터페이스를 사용해야한다.  
   ex) `Set`, `List`, `Map`, `Map.Entry` 등 컬렉션 인터페이스들
3. 입력을 올바른 타입으로 형변환 한다.  
   2번에서 `instanceof` 연산자로 입력이 올바른 타입인지 검사 했기 때문에 이 단계는 100% 성공한다.
4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.  
   모두 일치해야 `true`를 반환한다.
