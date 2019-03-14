package creationalPattern.buildPattern2;

public class LargeOnionPizza extends VegPizza{
    @Override
    public String name() {
        return "Onion Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }

    @Override
    public float price() {
        return 180.f;
    }
}
