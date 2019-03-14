package creationalPattern.builderPattern;

public class Samsung extends Company {
    @Override
    public String pack() {
        return "Samsung CD";
    }

    @Override
    public int price() {
        return 40;
    }
}
