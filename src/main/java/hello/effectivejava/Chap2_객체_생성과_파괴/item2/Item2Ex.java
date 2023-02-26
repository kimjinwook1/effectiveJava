package hello.effectivejava.Chap2_객체_생성과_파괴.item2;

public class Item2Ex {
        public static void main(String[] args) {
            NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                    .addTopping(Pizza.Topping.SAUSAGE)
                    .addTopping(Pizza.Topping.ONION)
                    .build();

            Calzone calzone = new Calzone.Builder()
                    .addTopping(Pizza.Topping.HAM)
                    .sauceInside()
                    .build();
        }
}
