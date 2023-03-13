package hello.effectivejava.Chap2_객체_생성과_파괴.item10;

import java.util.HashSet;
import java.util.Set;

public class 반사성 {
  private String name;

  public 반사성(final String name) {
    this.name = name;
  }

  public static void main(String args[]){
    Set<반사성> set = new HashSet<>();
    반사성 language = new 반사성("java");
    set.add(language);
    System.out.println(set.contains(language)); // false일 경우, 반사성을 만족하지 못하는 경우이다.
    System.out.println("equals = " + language.equals(language));
  }
}
