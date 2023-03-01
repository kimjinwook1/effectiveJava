# 이펙티브 자바

## 2장. 객체 생성과 파괴

### [Item 1 - 생성자 대신 정적 팩터리 메서드를 고려하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item1/Item1.md)
- 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
  - [Item1Ex.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem1%2FItem1Ex.java)

### [Item 2 - 생성자에 매개변수가 많다면 빌더를 고려하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item2/Item2.md)
- 빌더 패턴은 매개변수가 많을 때 쓰기 좋다.
  - [Item2Ex.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem2%2FItem2Ex.java)
### [Item 3 - private 생성자나 열거 타입으로 싱글턴임을 보증하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item3/Item3.md)
- 정적 팩터리 방식의 싱글턴
  - [RandomNumberGenerator.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem3%2FRandomNumberGenerator.java)
- 열거 타입 방식의 싱글턴
  - [DatabaseConnection.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem3%2FDatabaseConnection.java)
### [Item 4 - 인스턴스화를 막으려거든 private 생성자를 사용하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item4/Item4.md)
- 정적 멤버만 담은 유틸리티 클래스
  - [MathUtils.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem4%2FMathUtils.java)
### [Item 5 - 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item5/Item5.md)
- 의존 객체 주입
  - [LambdaFactory.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem5%2FLambdaFactory.java)
### [Item 6 - 불필요한 객체 생성을 피하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item6/Item6.md)
- 불필요한 객체 생성을 피하는 방법
  - [RegexTest.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem6%2FRegexTest.java)
### [Item 7 - 다 쓴 객체 참조를 해제하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item7/Item7.md)
- 다 쓴 객체 참조를 해제하는 방법
  - [ConnectionTest.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem7%2FConnectionTest.java)
### [Item 8 - finalizer와 cleaner 사용을 피하라](src/main/java/hello/effectivejava/Chap2_객체_생성과_파괴/item8/Item8.md)
- finalizer와 cleaner 사용을 피하는 방법
  - [RoomTest.java](src%2Fmain%2Fjava%2Fhello%2Feffectivejava%2FChap2_%EA%B0%9D%EC%B2%B4_%EC%83%9D%EC%84%B1%EA%B3%BC_%ED%8C%8C%EA%B4%B4%2Fitem8%2FRoomTest.java)
