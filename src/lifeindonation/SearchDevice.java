package lifeindonation;

public class SearchDevice implements PersonInNeedServiceCommandInterface {
    private PersonInNeed_Service personInNeedService;
    
    SearchDevice(PersonInNeed_Service personInNeedService){
        this.personInNeedService = personInNeedService;
    }

    @Override
    public void excute() {
        personInNeedService.SearchToOrder();
    }
}
