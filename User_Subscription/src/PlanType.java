public enum PlanType {

    BASIC(10000),
    SILVER(15000),
    GOLD(20000),
    PREMIUM(25000);

    private int price;
    PlanType(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }


}