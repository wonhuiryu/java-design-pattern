package creationalPattern.abstractFactoryPattern;

class LoanFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        loan = loan.toUpperCase();
        switch (loan){
            case "HOME":
                return new HomeLoan();
            case "BUISINESS":
                return new BussinessLoan();
            case "EDUCATION":
                return new EducationLoan();
        }
        return null;
    }
}
