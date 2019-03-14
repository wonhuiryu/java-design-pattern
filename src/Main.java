import creationalPattern.abstractFactoryPattern.AbstractFactory;
import creationalPattern.abstractFactoryPattern.Bank;
import creationalPattern.abstractFactoryPattern.FactoryCreator;
import creationalPattern.abstractFactoryPattern.Loan;
import creationalPattern.factoryMethodPattern.GetPlanFactory;
import creationalPattern.factoryMethodPattern.Plan;
import creationalPattern.singletonPattern.SingleTon;

/*2019.03.14
* by wonhui ryu*/
public class Main {

    public static void main(String[] args) {

        /*-------------------factory method Pattern------------------------*/
            /*Comment : Plan이라는 추상 클래스를 정의한다. rate 라는 멤버 변수와
                getRate()라는 추상 메소드를 정의한다 -> Plan을 상속받게 될
        자식 클래스에서 해당 rate에 값을 대입할 수 있는 getRate() 추상메소드를
                구현한다. GetPlanFactory는 클래스 명부터 느껴지듯 분기처리하여
                Plan 클래스를 상속받은 자식 클래스를 호출하는 역할을 한다.*/
        GetPlanFactory factoryMethodPattern = new GetPlanFactory();
        Plan plan = factoryMethodPattern.getPlan("DOMESTICPLAN");
        plan.getRate();//plan에 정의된 함수를 호출하는 것임.(자식에서 정의된)
        plan.calculateBill(5000);
          /*Final-Comment : 화장품, 재정, 교육사업 등 어떠한 사업이든 비율은
                다르지만 계산하는 행위가 필요할 것이다. 공통행위를 정의해놓고
                공장(팩토리)라는 곳에서 분기처리하여 원하는 사업(instance)를
            가져와 사용한다.*/
        /*-------------------factory method Pattern------------------------*/

        /*--------------------abstract factory method Pattern-----------------*/
/*        Comment : AbstractFactory 추상 클래스를 상속받은 BankFactory, LoanFactory가 있으며,
                FactoryCreator 클래스에서 분기처리하여 해당 인스턴스를 가져온다.
                BankFactory 인스턴스에서 한번더 이름으로 분기하여 해당 은행을 가져와
                Bank 인터페이스에 대입한다. 은행들은 Bank 인터페이스를 구한하고
                해당 인터페이스의 getBankName 함수를 정의하였다.*/
        AbstractFactory abstractFactory = FactoryCreator.getFactory("bank");
        Bank bank = abstractFactory.getBank("sbi");
        System.out.println(bank.getBankName());

        /*Comment : LoanFactory를 AbstracFactory에 대입시키고, 또 분기처리하여 EducationLoan인스턴스
                를 이용한다. Loan 추상클래스를 상속받아 추상메소드를 정의한다.(비율을 받는)
        Loan 추상클래스의 멤버함수를 호출하여 해당 비율로 이자를 계산한다.*/
        AbstractFactory abstractFactoryForLoan = FactoryCreator.getFactory("loan");
        Loan loan = abstractFactoryForLoan.getLoan("EDUCATION");
        loan.getInterestRate(1.6);
        loan.calculateLoanPayment(10000, 20);
/*        Final-Comment : 기본 업무형 클래스들을 인터페이스, 추상클래스로 공통 함수를 정의하고,
        구현 또는 상속받아 정의를 하여 같은 행동이지만 다른 수치로 셋업을 시킨다.(위와 같음)
        일반 factory와 차이점이라면, 추상 클래스(팩토리)를 두어 해당 추상클래스를 상속받아
                자식클래스에서 분기처리를 해주었다는점, 하지만 추상 클래스의 추상메소드들이
                강제 정의를 요구하므로 비효율적이라는 느낌을 받음. (BankFactory는 Bank인스턴스를
    분기처리하는 클래스인데, 사용하지 않는 Loan의 분기처리 함수를 정의해주어야함.)*/
        /*--------------------abstract factory method Pattern-----------------*/

        /*-------------------------singleton Pattern--------------------------*/
        SingleTon singleTon = SingleTon.getInstance();//기본적인 싱글톤 패턴.
        /*-------------------------singleton Pattern--------------------------*/

        
        /*-------------------------protoType Pattern--------------------------*/

        /*-------------------------protoType Pattern--------------------------*/


    }
}
