package creationalPattern.buildPattern2;

public class SmallNonVegPizza extends NonVegPizza {
    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Small Size";
    }

    @Override
    public float price() {
        return 180.f;
    }
}
