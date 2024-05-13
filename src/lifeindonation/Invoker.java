package lifeindonation;

public class Invoker {
    public void service (PersonInNeedServiceCommandInterface PersonInNeedService){
        PersonInNeedService.excute();
    }
    
}
