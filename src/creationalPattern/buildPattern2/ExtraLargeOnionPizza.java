package creationalPattern.buildPattern2;

public class ExtraLargeOnionPizza extends VegPizza{
    @Override
    public String name() {
        return "Onion Pizza";
    }

    @Override
    public String size() {
        return "Extra-Large Size";
    }

    @Override
    public float price() {
        return 200.f;
    }
}
