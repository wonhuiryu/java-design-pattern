package creationalPattern.buildPattern2;

public class ExtraLargeCheezePizza extends VegPizza{
    @Override
    public String name() {
        return "Cheeze Pizza";
    }

    @Override
    public String size() {
        return "Extra-Large Size";
    }

    @Override
    public float price() {
        return 300.f;
    }
}
