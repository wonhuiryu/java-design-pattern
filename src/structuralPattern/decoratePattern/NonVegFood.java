package structuralPattern.decoratePattern;

public class NonVegFood extends FoodDecorator {
    public NonVegFood(Food newFood) {//FoodDecorator 추상클래스에 기본 생성자가 없다. 전에 설명.
        super(newFood);
    }

    public String preparedFood(){
        return super.prepareFood() + " With Roasted Chicken and Chicken Curry";
    }

    public double foodPrice(){
        return super.foodPrice() + 150.0;
    }
}
