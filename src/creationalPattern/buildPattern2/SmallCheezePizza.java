package creationalPattern.buildPattern2;

public class SmallCheezePizza extends VegPizza{
    @Override
    public String name() {
        return "Cheeze Pizza";
    }

    @Override
    public String size() {
        return "Small size";
    }

    @Override
    public float price() {
        return 170.f;
    }
}
