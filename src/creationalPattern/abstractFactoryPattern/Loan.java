package creationalPattern.abstractFactoryPattern;

public abstract class Loan {
    protected double rate;
    public abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanAmount, int years){
        double EMI;
        int n;

        n = years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate), n))/((Math.pow((1+rate), n))-1))*loanAmount;

        System.out.println("your monthly EMI is "+ EMI + " for the amount"+ loanAmount + " you have borrowed");
    }

}
