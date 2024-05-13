package lifeindonation;

public class SpecificNeed implements PersonInNeedServiceCommandInterface {
    private PersonInNeed_Service personInNeedService;
    private int ID;
    
    SpecificNeed(PersonInNeed_Service personInNeedService, int ID){
        this.personInNeedService = personInNeedService;
        this.ID = ID;
    }

    @Override
    public void excute() {
        personInNeedService.specificNeed(ID);
    }
}
    

