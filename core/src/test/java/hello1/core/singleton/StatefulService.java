package hello1.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 주의해야 할 부분!!!
    }

    public int getPrice() {
        return price;
    }
}
