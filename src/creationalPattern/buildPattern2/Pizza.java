package creationalPattern.buildPattern2;

public abstract class Pizza implements Item{//extended By VegPizza, NonVegPizza
    @Override
    public abstract float price();//인터페이스의 추상메소드 price를 다시 추상메소드로 정의한다.(아마도 그냥 보여주기 위함인듯함. 어떤 피자이든, 음료이든 가격은 있으니)
}
