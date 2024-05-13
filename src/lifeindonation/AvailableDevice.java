package lifeindonation;

public class AvailableDevice implements PersonInNeedServiceCommandInterface {
    private PersonInNeed_Service personInNeedService;
    
    AvailableDevice(PersonInNeed_Service personInNeedService){
        this.personInNeedService = personInNeedService;
    }

    @Override
    public void excute() {
        personInNeedService.ListOfAvailableDevice();
    }
    
    
}