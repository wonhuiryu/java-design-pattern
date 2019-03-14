package creationalPattern.abstractFactoryPattern;

class HDFC implements Bank {//default 같은 패키지 내에서 가능
    private final String BNAME;//final 키워드 초기화를 사용자 정의 생성자에서 해준다.
    public HDFC(){
        BNAME = "HDFC BANK";//초기화
    }

    @Override
    public String getBankName(){
        return this.BNAME;
    }
}
