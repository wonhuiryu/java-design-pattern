package creationalPattern.objectPoolPattern;

public class ExportingProcess {

    private long processNo;//프로세스 번호

    public ExportingProcess(long processNo){//생성자
        this.processNo = processNo;
        System.out.println("Object with process no." + processNo + " was created");
    }

    public long getProcessNo(){
        return processNo;
    }

}
