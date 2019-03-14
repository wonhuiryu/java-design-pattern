package creationalPattern.abstractFactoryPattern;

class SBI implements Bank{//default 같은 패키지 내에서 가능
    private final String BNAME;
    public SBI(){//
        BNAME = "SBI BANK";
    }
    @Override
    public String getBankName(){
        return this.BNAME;
    }
}
