# 불필요한 객체 생성을 피하라
똑같은 기능의 객체를 매번 생성하기보다는 객체 하나를 재사용하는 편이 나을 때가 많다.
생성자 대신 정적 팩터리 메서드를 제공하는 불변 클래스에서는 정적 팩터리 메서드를 사용해 불필요한 객체 생성을 피할 수 있다.  
생성 비용이 비싼 객체는 캐싱하여 재사용하는 것이 좋다.
