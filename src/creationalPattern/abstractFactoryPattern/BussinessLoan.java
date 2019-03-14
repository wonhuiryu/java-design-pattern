package creationalPattern.abstractFactoryPattern;

class BussinessLoan extends Loan {
    @Override
    public void getInterestRate(double rate) {
        this.rate = rate;
    }
}
