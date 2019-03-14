package creationalPattern.buildPattern2;

public class MediumCheezePizza extends VegPizza{
    @Override
    public String name() {
        return "Cheeze Pizza";
    }

    @Override
    public String size() {
        return "Medium Size";
    }

    @Override
    public float price() {
        return 220.f;
    }
}
