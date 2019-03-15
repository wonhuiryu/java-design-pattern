import behavioralPattern.chainOfResponsibilityPattern.ChainOfResponsibilityClient;
import behavioralPattern.chainOfResponsibilityPattern.Logger;
import behavioralPattern.commandPattern.*;
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
import structuralPattern.compositePattern.Accountant;
import structuralPattern.compositePattern.BankManager;
import structuralPattern.compositePattern.Cashier;
import structuralPattern.compositePattern.Employee;
import structuralPattern.decoratePattern.ChineseFood;
import structuralPattern.decoratePattern.Food;
import structuralPattern.decoratePattern.NonVegFood;
import structuralPattern.decoratePattern.VegFood;
import structuralPattern.facadePattern.ShopKeeper;
import structuralPattern.proxyPattern.OfficeInternetAccess;
import structuralPattern.proxyPattern.ProxyInternetAccess;

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

        /*------------------------------------compositePattern----------------------------------*/
        /*Comment : BankManger 즉, 총괄 관리인 클래스에서만 CRUD method를 정의해주고, 나머지의 직급
        또는 역할 클래스에는 method를 정의해주지 않는다. 공통 Interface를 정의한 총괄관리인, 나머지 직급,역할
        들은 종업원 타입의 리스트에 추가될 수 있다.
         */
        Employee emp1 = new Cashier(101, "Sohan Kumar", 20000.0);
        Employee emp2 = new Cashier(102, "Mohan Kumar", 25000.0);
        Employee emp3 = new Accountant(103, "Seema Mahiwal", 30000.0);
        Employee manager1 = new BankManager(100, "Ashwani Rajput", 100000.0);

        manager1.add(emp1);
        manager1.add(emp2);
        manager1.add(emp3);
        manager1.print();
        /*Final-Comment : 총괄관리인 말고는 아무도 직원을 고용하거나 자를 수 없다. 상위 - 하위의 개념
        composite 단어부터 느껴지듯 조합을 하여 최종 결제는 총괄 관리인이 진행한다.
        */
        /*------------------------------------compositePattern----------------------------------*/



        /*--------------------------------------detoratePattern------------------------------------*/
        Food food = new VegFood();

        //순수한 food
        System.out.println(food.prepareFood());
        System.out.println(food.foodPrice());

        //중국 food
        Food chineseFood = new ChineseFood(food);
        System.out.println(chineseFood.prepareFood());
        System.out.println(chineseFood.foodPrice());

        //Non-Veg food
        Food nonVegFood = new NonVegFood(food);
        System.out.println(nonVegFood.prepareFood());
        System.out.println(nonVegFood.foodPrice());
/*        원래의 설계대로라면 Food Interface만을 구현하여 음식 클래스를 정의하였어야했는데, 해당 인터페이스를
                구현하여 정의 한 후, 정의한 것에 추가로 무언가 더하고 싶을 때, Food interface를 추상 클래스로 구현한 후
                그 추상클래스를 상속받아 재정의하는 패턴. chinese, non-veg 클래스는 FoodDecorator 클래스를 상속받고 있기
                때문에 FoodDecorator 클래스에서 Food Interface의 함수를 호출하는 함수를 정의해야한다.
                (Food Interface를 구현하고 있는 VegFood 함수를 호출하기 위해선)*/
        /*--------------------------------------detoratePattern------------------------------------*/

        /*--------------------------------------facadePattern-------------------------------------------*/
        /* Comment : MobileShop interface 를 구현하여 회사마다 가격과 모델명을 제시한다.
        ShopKeeper 즉, 주인장은 정의된 메소드로 호출한다. 가장 기본적이라고 생각됨.
        이 패턴은 행위의 주체(대장)이 되는 클래스에서 클래스를 미리 생성하여 행위하는 동작까지 구현해 놓은것임
        매개변수를 받아 분기처리를 행하여도 된다고 생각함.
         */
        ShopKeeper shopKeeper = new ShopKeeper();
        shopKeeper.blackBerrySale();
        shopKeeper.iphoneSale();
        shopKeeper.samsungSale();
        /*--------------------------------------facadePattern-------------------------------------------*/

        /*----------------------------------------proxyPattern--------------------------------------------*/
        /* Comment : 중간에 한번 거쳐 접근 권한이 있는지 체크하며, 접근 권한이 있다면. 원래의 RealAccessClass를
        생성하여 접근을 시켜준다. 이미 정의된 클래스를 호출하기 전에 무언가의 액션을 실행하고 싶다면 권고하는 패턴.
         */

        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");
        access.grantInternetAccess();
        /*----------------------------------------proxyPattern--------------------------------------------*/

        /*----------------------------------chainOfResponsibilityPattern-------------------------------------*/
        /*TODO Comment : 잘 모르겠음. -> 더 봐야함

         */
        Logger chainLogger= ChainOfResponsibilityClient.doChaining();

        chainLogger.logMessage(Logger.OUTPUTINFO, "Enter the sequence of values ");
        chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");
        chainLogger.logMessage(Logger.DEBUGINFO, "This was the error now debugging is compeled");

        /*----------------------------------chainOfResponsibilityPattern-------------------------------------*/

        /*------------------------------------------commandPattern----------------------------------------------*/
        /* Comment : 메뉴 Command interface를 구현하고 실행 함수를 정의한다. 클래스 명에 맞는 로직이 정의된다.
        공통적으로 어떤것이 열렸다. / 저장됬다에 대한 시작점과 끝점의 공통점.
        -> 어떤 것인지에 대한 세분화 클래스를 만든다. 여기선 Document밖에 없지만. excel, hwp등의 클래스를 정의하여
        open과 save에서 변수로 관리할 수도 있다. MenuOptions에선 어떠한 행위를 할지를 정하여 Command interface 타입의
        변수에 대입해준다.
         */
        Document document = new Document();
        ActionListenerCommand actionListenerCommand = new ActionOpen(document);
        ActionListenerCommand actionListenerCommand1 = new ActionSave(document);

        MenuOptions menuOptions = new MenuOptions(actionListenerCommand, actionListenerCommand1);
        menuOptions.clickOpen();
        menuOptions.clickSave();
        /*------------------------------------------commandPattern----------------------------------------------*/


    }
}
