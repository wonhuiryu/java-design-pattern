package creationalPattern.abstractFactoryPattern;

class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        bank = bank.toUpperCase();
        switch (bank){
            case "HDFC":
                return new HDFC();
            case "ICICI":
                return new ICICI();
            case "SBI":
                return new SBI();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
