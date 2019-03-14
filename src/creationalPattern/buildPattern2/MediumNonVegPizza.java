package creationalPattern.buildPattern2;

public class MediumNonVegPizza extends NonVegPizza{
    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Medium Size";
    }

    @Override
    public float price() {
        return 200.f;
    }
}
