package structuralPattern.bridgePattern;

public class QuestionManager {

    //부모클래스에 사용자 정의 생성자가 정의 되었을 때, 기본 생성자를 명시해주지 않으면 자식 클래스에서 해당 사용자 정의 생성자를 사용해야한다.
    //부모클래스에 사용자 정의 생성자가 정의되고, 기본생성자가 정의 되었을 경우 기본 생성자를 상속받기 때문에 부모의 사용자 정의 생성자를 호출할 필요가 없다.
    public Question q;
    public String catalog;

    public QuestionManager(String catalog){
        this.catalog = catalog;
    }
    public void next(){
        q.nextQuestion();
    }
    public void previous(){
        q.previousQuestion();
    }
    public void newOne(String quest){
        q.newQuestion(quest);
    }
    public void delete(String quest){
        q.deleteQuestion(quest);
    }
    public void display(){
        q.displayQuestion();
    }
    public void displayAll(){
        System.out.println("Question Paper: " + catalog);
        q.displayAllQuestions();
    }
}
