package hello.effectivejava.Chap2_객체_생성과_파괴.item8;

public class RoomTest {

    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕~");
            // try-with-resources 문을 사용하면 자동으로 close()를 호출해준다.
        }

        final Room room = new Room(99);
        System.out.println("방 청소함");
        // try-with-resources 문을 사용하지 않았기 때문에 close()를 호출해줘야 한다.
        room.close();
    }
}
