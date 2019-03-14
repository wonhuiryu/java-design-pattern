package creationalPattern.factoryMethodPattern;

public abstract class Plan {//이 추상 클래스는 어느곳에서나 사용되어야 하기 때문에 public Plan타입 변수 = Factory에서 가져온 자식 객체;

    protected double rate;//default + this.class를 상속한 경우 참조 가능

    public abstract void getRate();//default abstract 같은패키지 내에서 참조 가능하지만 몸체를 구현해주어야함(추상클래스)

    public void calculateBill(int units){//public 어디에서나 참조 가능능
        System.out.println(units * rate);
    }
}
