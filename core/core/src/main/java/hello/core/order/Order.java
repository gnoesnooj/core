package hello.core.order;

public class Order {
    private Long memberId;
    private  String itmeName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itmeName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itmeName = itmeName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice-discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItmeName() {
        return itmeName;
    }

    public void setItmeName(String itmeName) {
        this.itmeName = itmeName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itmeName='" + itmeName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
