package structuralPattern.decoratePattern;

public class ChineseFood extends FoodDecorator {
    public ChineseFood(Food newFood) {
        super(newFood);
    }

    public String prepareFood(){
        return super.prepareFood() + " With Fired Rice and Manchurian ";
    }

    public double foodPrice(){
        return super.foodPrice()+65.0;
    }
}
