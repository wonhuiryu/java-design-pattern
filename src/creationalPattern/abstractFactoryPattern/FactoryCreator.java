package creationalPattern.abstractFactoryPattern;

public class FactoryCreator {

    public static AbstractFactory getFactory(String choice){

        choice = choice.toUpperCase();

        switch (choice){
            case "BANK":
                return new BankFactory();
            case "LOAN":
                return new LoanFactory();
        }

        return null;
    }
}
