package creationalPattern.singletonPattern;


public class SingleTon {
    private static final SingleTon singleTon = new SingleTon();//접근제어자 private, static(memory) 새로운 객체 생성해서 대입.
    /*private SingleTon(){}*/ //기본 생성자

    //getInstance를 호출함으로써, 이 인스턴스를 얻는다.
    //한번의 호출로 계속해서 사용되어진다.
    //참고로 SpringFrameWork의 @Autowired는 기본이 싱글턴이다.
    //예를들자면, xxxxRepository (database Interface)에 사용되어진다고 보면됨.
    //데이터베이스 인터페이스에 데이터를 전달하는 역할만을 하는 것인데, 사용할 때마다 객체를 새로 생성할 필요가 없음.
    public static SingleTon getInstance(){
        return singleTon;
    }

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
