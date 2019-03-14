package creationalPattern.abstractFactoryPattern;

class ICICI implements Bank {//default 같은 패키지 내에서 가능
    private final String BNAME;
    ICICI(){
        BNAME="ICICI BANK";
    }
    @Override
    public String getBankName(){
        return this.BNAME;
    }
}
