package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 field

    public int order(String name, int price){
//        this.price = price; // 여기가 문제
        return price;
    }
//
//    public int getPrice() {
////        return price;
//    }
}