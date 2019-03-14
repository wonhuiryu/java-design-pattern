package creationalPattern.buildPattern2;

public class LargeCheezePizza extends VegPizza {
    @Override
    public String name() {
        return "Cheeze Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }

    @Override
    public float price() {
        return 260.f;
    }
}
