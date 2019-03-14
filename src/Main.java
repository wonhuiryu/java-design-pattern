import creationalPattern.abstractFactoryPattern.AbstractFactory;
import creationalPattern.abstractFactoryPattern.Bank;
import creationalPattern.abstractFactoryPattern.FactoryCreator;
import creationalPattern.abstractFactoryPattern.Loan;
import creationalPattern.builderPattern.CDBuilder;
import creationalPattern.builderPattern.CDType;
import creationalPattern.factoryMethodPattern.GetPlanFactory;
import creationalPattern.factoryMethodPattern.Plan;
import creationalPattern.objectPoolPattern.ObjectPoolDemo;
import creationalPattern.prototypePattern.EmployeeRecord;
import creationalPattern.singletonPattern.SingleTon;
import structuralPattern.adapterPattern.BankCustomer;
import structuralPattern.adapterPattern.CreditCard;
import structuralPattern.bridgePattern.JavaQuestions;
import structuralPattern.bridgePattern.QuestionFormat;

/**
 * The type Main.
 */
/*2019.03.14
* by wonhui ryu*/
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
        //한개의 인스턴스를 메모리에 올려 계속 사용한다.
        SingleTon singleTon = SingleTon.getInstance();
        /*-------------------------singleton Pattern--------------------------*/


        /*-------------------------protoType Pattern--------------------------*/
        //인스턴스의 멤버변수들의 값을 갖고 새로운 객체로 값만 복사하게 끔 만드는 패턴
        //아래의 주소값을 보면 다른 걸 알 수 있음.
        EmployeeRecord employeeRecord = new EmployeeRecord(930309, "유원희", "daeri", 1000000, "Suwon");
        employeeRecord.showRecord();
        EmployeeRecord employeeRecord2 = (EmployeeRecord)employeeRecord.getClone();//Prototype형을 반환한다. 자식형으로 캐스팅해준다.
        employeeRecord2.showRecord();
        System.out.println(employeeRecord.hashCode());
        System.out.println(employeeRecord2.hashCode());
        /*-------------------------protoType Pattern--------------------------*/


        /*---------------------------builderPattern-------------------------------*/
        /*Comment : Packing 인터페이스를 구현한 추상클래스 CD, Company
                Company를 상속받은 Samsung, Sony는 price 함수와 pack함수를 정의하였다.
        CDType에선 Packing 인터페이스 타입의 리스트를 선언하고. addMethod를 정의한다.
        CDBuilder에선 CDType 클래스에서 정의한 변수와 함수로 삼성과 소니를 빌드하는
        함수를 정의한다. */
        CDBuilder cdBuilder = new CDBuilder();

        CDType cdType1 = cdBuilder.buildSonyCD();
        cdType1.showItems();

        CDType cdType2 = cdBuilder.buildSamsungCD();
        cdType2.showItems();
        /*Final-Comment : 대략적으로 하나의 객체를 몇단계로 세부적으로 나눌지에 대한 문제이다.
        interface -> abstract class -> abstract class의 형태로 계보를 타고 내려간다.
        ** 결국, 자신이 원하는 값들을 담아준 후 해당 인스턴스를 얻는다. */
        /*---------------------------builderPattern-------------------------------*/


        /*It boosts the performance of the application significantly.*/
        /*--------------------------objectPoolPattern-----------------------------*/


        /*--------------------------objectPoolPattern-----------------------------*/



        /*----------------------------thread Test------------------------------------*/
        int N = 77777777;
        long t;

        //thread-safe
        {
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }

        //thread-non-safe
        //if using local variable(instance) each thread will get its own instance in tomcat
        //-> params not member variable
        {
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i > 0 ; i--) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }
        /*----------------------------thread Test------------------------------------*/



        /*TODO-----------------------------objectPoolPattern---------------------------------*/
/*        오브젝트를 setUp에 셋팅해준만큼 (최소~최대)풀에 넣어 놓고 사용한다는 것 같은데.
        자세하게 모르겠음. 몇번 봐야할듯함.*/
        ObjectPoolDemo op = new ObjectPoolDemo();
        op.setUp();
        op.teatDown();
        op.testObjectPool();
        /*TODO-----------------------------objectPoolPattern---------------------------------*/

        /*--------------------------------adapterPattern----------------------------------*/
        /*BankCustomer extends BankDetails implements CreditCard*/
        CreditCard targetInterface = new BankCustomer();//Interface type에 담는다.
        targetInterface.giveBankDetails();
        System.out.print(targetInterface.getCreditCard());
/*        VO 객체를 생각한다. 단지 VO 객체를 부모로 물려받아 부모의 멤버변수에 값을 넣어준 후
                또 부모의 멤버 메소드로 값을 꺼내온다.
        interface에 해야할 일을 명시 한 후, 값을 저장하는 것 꺼내오는 것은 상속받은 부모클래스를 이용(인터페이스정의)
                신용카드 번호 반환 (인터페이스 정의)

                --> 이렇게 사용하는 이유는? 내 추측엔, 이미 VO를 정의 해놓았고, 해당 VO엔
                카드를 만드는 데에 필요한 변수가 지정되어 있다. BankCustomer에서 세분화하여
                부모값은 사용하면서 자신만의 변수에 값을 저장하여 사용할 때에 좋을 것 같다.
                interface는 행위에 관련되게 정의를 한다.*/
        /*--------------------------------adapterPattern----------------------------------*/

        /*----------------------------------bridgePattern------------------------------------*/
        /*Question interface 구현 및 정의 JavaQuestions
                QuestionManager은 Question interface함수를 호출한다.
        즉, 어떤 Questions이든 QuestionsInterface를 정의하면 QuestionManager가 사용가능
        QuestionFormat이 굳이 필요한 이유가? 아직 잘 모르겠음.*/
        QuestionFormat questions = new QuestionFormat("Java Programming Language");
        questions.q = new JavaQuestions();
        questions.delete("what is class?");
        questions.display();
        questions.newOne("What is inheritance? ");
        questions.newOne("How many types of inheritance are there in java?");
        questions.displayAll();
        /*----------------------------------bridgePattern------------------------------------*/
    }
}
