package structuralPattern.proxyPattern;

public class ProxyInternetAccess implements OfficeInternetAccess {

    private String employeeName;
    private RealInternetAccess realInternetAccess;

    public ProxyInternetAccess(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {

        if(getRole(this.employeeName) > 4){
            this.realInternetAccess = new RealInternetAccess(employeeName);
            this.realInternetAccess.grantInternetAccess();
        }else{
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }

    public int getRole(String employeeName){
        return 4;
    }
}
