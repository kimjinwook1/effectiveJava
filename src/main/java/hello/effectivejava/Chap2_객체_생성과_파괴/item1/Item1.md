# 생성자 대신 정적 팩터리 메서드를 고려하라

-  정적 팩터리 메서드란?  
   클래스의 인스턴스를 반환하는 단순한 정적 메서드이다.   
  

### 장점
1. 이름을 가질 수 있다.
    - 메서드 이름을 통해 반환될 객체의 특성을 쉽게 묘사할 수 있다.
    - ex) Boolean.valueOf(String) : String을 boolean으로 변환해주는 메서드
2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    - 불변 클래스의 경우 항상 같은 객체를 반환할 수 있다.
    - ex) Boolean.valueOf(String) : String이 true, false인지에 따라 Boolean.TRUE, Boolean.FALSE를 반환한다.
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    - ex) Collection 인터페이스를 구현한 클래스들은 모두 List, Set, Queue 등의 하위 타입을 반환할 수 있다.
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    - 반환 타입의 하위 타입이 아닌 다른 클래스의 객체를 반환할 수 있다.
    - ex) EnumSet 클래스의 of 메서드는 입력 매개변수에 따라 RegularEnumSet, JumboEnumSet 클래스의 객체를 반환한다.
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
    - ex) JDBC

### 단점
1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
    - 하위 클래스를 만들 수 없다는 것은 확장할 수 없다는 것이다.
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
    - 생성자처럼 API에 명확히 드러나지 않는다.
    - ex) Boolean.valueOf(String) : Boolean 클래스의 정적 팩터리 메서드

### 정적 팩터리 메서드 명명 방식
- from : 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
    - ex) Date d = Date.from(instant);
- of : 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
    - ex) Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
- valueOf : from과 of의 더 자세한 버전
    - ex) BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
- instance 혹은 getInstance : 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지는 않는다.
    - ex) StackWalker luke = StackWalker.getInstance(options);
- create 혹은 newInstance : instance 혹은 getInstance와 같지만, 매번 새로운 인스턴스를 생성해 반환함을 보장한다.
    - ex) Object newArray = Array.newInstance(classObject, arrayLen);
- getType : getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. Type은 팩터리 메서드가 반환할 객체의 타입이다.
    - ex) FileStore fs = Files.getFileStore(path);
- newType : newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. Type은 팩터리 메서드가 반환할 객체의 타입이다.
    - ex) BufferedReader br = Files.newBufferedReader(path);
- type : getType과 newType의 간결한 버전
    - ex) List<Complaint> litany = Collections.list(legacyLitany);
