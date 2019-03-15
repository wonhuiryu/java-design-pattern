package behavioralPattern.commandPattern;

public class MenuOptions {

    private ActionListenerCommand a1;
    private ActionListenerCommand a2;

    public MenuOptions(ActionListenerCommand a1, ActionListenerCommand a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public void clickOpen(){
        this.a1.execute();
    }

    public void clickSave(){
        this.a2.execute();
    }
}
