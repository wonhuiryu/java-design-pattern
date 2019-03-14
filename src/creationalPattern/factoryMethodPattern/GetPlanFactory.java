package creationalPattern.factoryMethodPattern;

public class GetPlanFactory {//Factory로 어느 클래스에서든 해당 계획 인스턴스들을 사용할 일이 있기에 public

    public Plan getPlan(String planType){//함수 정의

        switch (planType){//since java7 String switch-case
            case "DOMESTICPLAN":
                return new DomesticPlan();
            case "COMMERCIALPLAN":
                return new CommercialPlan();
            case "INSTITUTIONALPLAN":
                return new InstitutionalPlan();
        }

        return null;
    }
}
