package creationalPattern.factoryMethodPattern;

class CommercialPlan extends Plan {//default class = 같은 패키지 내에 참조 가능
    @Override
    public void getRate() {//Plan 추상클래스를 상속 받는다. getRate 라는 함수를 구현해주어야함. (abstract)
        rate=7.50;//Plan 클래스의 rate 변수에 대입해준다. (부모클래스)
    }
}
