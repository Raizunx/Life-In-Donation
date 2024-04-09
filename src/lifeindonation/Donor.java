package lifeindonation;

import static java.lang.System.exit;
import java.util.Scanner;
/*
Donor class represent child of User class
it display the list of services for donor and then routing them to appropriate
class to implements their requests.
*/

public class Donor extends User{
    
    donorService service= new donorService();
    
    ////////////////////////////consturctors////////////////////////////
    //1
    public Donor(int id,String FN,String MN,String SN,int phone,String address,String email)
    {
        super(id,FN,MN,SN,phone,address,email);
        add_donor_ToDataBase();
        this.id = id;
        displayService();
    }
    //2
    public Donor(){
        System.out.println("detail of Donor not sent.");
    }
    
    
    ////////////////////////////core method////////////////////////////
    public void displayService(){
       Scanner input = new Scanner(System.in); 
       
       do{
       int userSelection = 0;
       
            System.out.println("-------------------------------------------------"
                + "\nChoose a Service: "
                + "\n> 1- List of needs "
                + "\n> 2- Device donation"
                + "\n> 3- Exit"  
                + "\n-------------------------------------------------");
        
            try{
                userSelection = input.nextInt();
       
                //check input
                while(userSelection != 1 && userSelection != 2 && userSelection != 3 ){
                System.out.println("!! wrong input !! \n"
                    + "-------------------------------------------------"
                    + "\nChoose a Service: "
                    + "\n> 1- List of needs "
                    + "\n> 2- Device donation"
                    + "\n> 3- Exit"   
                    + "\n-------------------------------------------------");
                userSelection = input.nextInt();
                }
    
                
            }catch(Exception e){
                System.out.println("!!!wrong input!!!");
            }
            
            switch(userSelection){
       
            case 1:
                service.ListOfNeed();
                break;
            
            case 2:
                service.DetailOfDonate(id);
                break; 
        
            case 3:
                exit(0);
                break;

            default:
            System.out.println("Invalid Choice Try Again");
                                                                                                      
            }
        
       }while(true);
    }
}