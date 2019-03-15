package structuralPattern.facadePattern;

public class ShopKeeper {

    private MobileShop iphone;
    private MobileShop samsung;
    private MobileShop blackberry;

    public ShopKeeper(){
        this.iphone = new Iphone();
        this.samsung = new Samsung();
        this.blackberry = new BlackBerry();
    }

    public void iphoneSale(){
        iphone.modelNo();
        iphone.price();
    }

    public void samsungSale(){
        samsung.modelNo();
        samsung.price();
    }

    public void blackBerrySale(){
        blackberry.modelNo();
        blackberry.price();
    }

}
