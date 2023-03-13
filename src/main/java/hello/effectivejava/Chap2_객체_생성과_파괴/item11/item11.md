# equals를 재정의하려거든 hashoCode도 재정의하라

## `hashCode` 일반 규약

- **`equals` 비교에 사용되는 정보가 변경되지 않았다면, `hashCode` 도 변하면 안 된다.**  
  (애플리케이션을 다시 실행한다면 이 값이 달라져도 상관 없음)
- **`equals`가 두 객체가 같다고 판단했다면, 두 객체의  `hashCode`는 똑같은 값을 반환한다.**  
  → 논리적으로 같은 객체는 같은 해시코드를 반환해야 한다.
- **`equals`가 두 객체를 다르다고 판단했더라도, `hashCode`는 꼭 다를 필요는 없다.**  
  하지만, 다른 객체에 대해서는 다른 값을 반환해야 해시테이블의 성능이 좋아진다.

## `hashCode`의 캐싱과 지연 초기화

- 클래스가 불변이고 해시코드를 계산하는 비용이 크다면, 매번 새로 계산하기 보다 캐싱을 고려해야 한다.  
  → 이 타입의 객체가 주로 해시의 키로 사용될 것 같다면 인스턴스가 만들어질 때 해시코드를 계산해 둔다.
- 해시의 키로 사용되지 않는 경우라면 `hashCode`가 처음 불릴 때 계산한느 지연 초기화하면 좋다.  
  → 필드를 지연 초기화 하려면 그 클래스가 *thread-safe*가 되도록 동기화에 신경 쓰는 것이 좋다.

##### 해시코드를 지연 초기화하는 `hashCode` 메서드 - 스레드 안전성까지 고려해야 한다.

```java
private int hashCode;

@Override
public int hashCode() {
          int result = hashCode; // 초기값 0을 가진다.
        if(result == 0) {
        int result = Integer.hashCode(areaCode);
        result = 31 * result + Integer.hashCode(areaCode);
        result = 31 * result + Integer.hashCode(areaCode);
        hashCode = result;
        }
        return result;
}
```

동시에 여러 쓰레드가 hashCode를 호출하면 여러 쓰레드가 동시에 계산하여 우리의 처음 의도와는 다르게 여러번 계산하는 상황이 발생할 수 있다.  
그래서 지연 초기화를 하려면 동기화를 신경써주는 것이 좋다.


## **해시 테이블(Hash Table)?**

**해시 테이블(Hash Table)** 은 키(key)와 값(value)이 하나의 쌍을 이루는 데이터 구조이다. 즉, 키(key)와 배열의 인덱스(index)를 이용하여 키를 저장하는 자료구조이다. 해시 테이블은 해시 맵, 맵, 딕셔너리, 연관 배열 이라는 이름으로 알려져있다.  
해시 테이블은 키를 **해시 함수(hash function)** 로 계산하여 그 값을 배열의 인덱스로 사용한다. 이때, 해시 함수에 의해 반환된 데이터의 고유 숫자 값을 **해시값 또는 해시코드** 라고 한다. 즉, key 값을 해시 함수를 통해서 배열의 인덱스로 바꿔주고, 그 자리에 데이터를 저장한다. 정리하면 다음과 같다.

**원래 데이터의 값(Key) -> Hash Function -> **Hash Function의 결과 =** Hash Code** 

**-> **Hash Code를 배열의** Index 로 사용 -> 해당하는 Index에 data 넣기**
