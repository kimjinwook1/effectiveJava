package hello.effectivejava.Chap2_객체_생성과_파괴.item7;

import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 이 메서드는 항상 size 필드를 증가시킨다.
     * 이 메서드는 capacity 필드가 최대치에 도달했을 때 배열을 늘릴 때만 배열을 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = java.util.Arrays.copyOf(elements, 2 * size + 1);
    }
}
