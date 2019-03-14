package creationalPattern.buildPattern2;

public class ExtraLargeNonVegPizza extends NonVegPizza{
    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Extra-Large Pizza";
    }

    @Override
    public float price() {
        return 250.f;
    }
}
