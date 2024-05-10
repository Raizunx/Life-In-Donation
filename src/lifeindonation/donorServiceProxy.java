package lifeindonation;

import java.util.Scanner;

/**
 * donorServiceProxy
 * 1- take a Detail of Donated device 
 * 2- List Of Need 
 */

public class donorServiceProxy implements donorServiceInterface {
    
    donorService donorService;
    int ID;
            
//////////////////////////////////consturctors//////////////////////////////////
        //1
        public donorServiceProxy(int id){
            this.ID =id;
        }
        
       
////////////////////////////////donor service///////////////////////////////////
    
    //1 (Detail of Donate)
    public void DetailOfDonate(){
        Scanner input = new Scanner(System.in); 
        
        String line;
        
        try{
        //1
        line = input.nextLine();
        System.out.print("\nEnter the name of the device: ");
        String name = input.nextLine();
        
        //2
        System.out.print("Device status (used or new):");
        String status = input.nextLine();
        while(!status.equalsIgnoreCase("used") && !status.equalsIgnoreCase("new")){
            System.out.print("!!try again!! \nDevice status (used or new):");
            status = input.nextLine();
        }
        //3
        int duration = 0;
        if(status.equalsIgnoreCase("used")){
            System.out.print("Device usage time in month: ");
            duration = input.nextInt();
            line = input.nextLine();
        }
        
        //4
        System.out.print("Device type (electronic or normal): ");
        String type = input.next();
        
        //5
        System.out.print("number of Devices: ");
        int numberOfDevices = input.nextInt();
        
        //6
        System.out.print("Device description: ");
        String description = input.next();
        
        if (donorService == null) {
            donorService = new donorService();
        }
        donorService.saveDonateDeviceInArray(name, status, type, duration, description, ID, numberOfDevices);
        donorService.DetailOfDonate();
        
        }catch(Exception e){
            System.out.println("\nThere was an error in DetailOfDonate method"
                    + "at donorServiceProxy class. Try later");
        }
    }
    
    
    //2 (List Of Need)
    public void ListOfNeed(){
        if (donorService == null) {
            donorService = new donorService();
        }
        donorService.ListOfNeed();
    }
    
}
