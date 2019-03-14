package creationalPattern.builderPattern;

public class CDBuilder {

    public CDType buildSonyCD(){
        CDType cds = new CDType();/*private List<Packing> items = new ArrayList<>();*/
        cds.addItem(new Sony());//Sony extends Company -> Company implements Packing
        return cds;
    }

    public CDType buildSamsungCD(){
        CDType cds = new CDType();
        cds.addItem(new Samsung());
        return cds;
    }

}
