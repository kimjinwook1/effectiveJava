# finalizer와 cleaner 사용을 피하라
자바는 두 가지 객체 소멸자를 제공한다.  
finalizer는 예측할 수 없고, 상황에 다라 위험할 수 있어 일반적으로 불필요하다.
cleaner는 finalizer는 덜 위험하지만, 여전히 예측할 수 없고, 느리고, 일반적으로 불필요하다.

finalizer와 cleanr는 즉시 수행된다는 보장이 없다. finalizer와 cleanr를 얼마나 신속히 수행할지는 전적으로 가비지 컬렉터 알고리즘에 달려있으며, 이는 가비지 컬렉터 구현마다 천차만별이다.  
프로그램 생애주기와 상관없는, **상태를 영구적**으로 수정하는 작업에서는 절대 finalizer와 cleanr에 의존해서는 안 된다.

finalizer와 cleanr를 대신해줄 묘안은 **AutoCloseable**를 구현해주고, 클라이언트에서 인스턴스를 다 쓰고나면 close 메서드를 호출하면 된다.
(**try-with-resources**를 사용하면 더욱 간단하다.)
