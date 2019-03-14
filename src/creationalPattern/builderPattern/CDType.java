package creationalPattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class CDType {

    private List<Packing> items = new ArrayList<>();//List<interface>

    public void addItem(Packing packs){//인터페이스를 구현한 인스턴스 또는 부모인스턴스가 해당 인터페이스를 구현한 아이템
        items.add(packs);
    }

/*    public void getCost(){
        for(Packing packs: items){
            packs.price();
        }
    }*/

    public void showItems(){
        for (Packing packing : items){
            System.out.print("CD:"+packing.pack());
            System.out.println(", Price:"+packing.price());
        }
    }

}
