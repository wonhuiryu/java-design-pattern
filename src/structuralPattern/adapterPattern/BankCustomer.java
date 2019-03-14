package structuralPattern.adapterPattern;

public class BankCustomer extends BankDetails implements CreditCard{//BankDetails 변수 선언 및 메소드 정의
    @Override
    public void giveBankDetails() {
        setAccHolderName("wonhui");
        setAccNumber(123456789l);
        setBankName("KB");
    }

    @Override
    public String getCreditCard() {
        long accno=getAccNumber();
        String accholdername=getAccHolderName();
        String bname=getBankName();
        return ("The Account number "+accno+" of "+accholdername+" in "+bname+ " bank is valid and authenticated for issuing the credit card.");
    }
}
