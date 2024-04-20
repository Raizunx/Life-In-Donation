package lifeindonation;

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
    }
    //2
    public Donor(){
        displayService();
    }
    
    
    ////////////////////////////core method////////////////////////////
    public void displayService(){
       Scanner input = new Scanner(System.in); 
       
       int userSelection = 0;
       
       do{
            System.out.println("-------------------------------------------------"
                + "\nChoose a Service: "
                + "\n> 1- List of needs "
                + "\n> 2- Device donation"
                + "\n> 3- to exit"
                + "\n-------------------------------------------------");
        
            try{
                userSelection = input.nextInt();
       
                //check input
                while(userSelection != 1 && userSelection != 2){
                System.out.println("!! wrong input !! \n"
                    + "-------------------------------------------------"
                    + "\nChoose a Service: "
                    + "\n> 1- List of needs "
                    + "\n> 2- Device donation"
                    + "\n> 3- exit"
                    + "\n-------------------------------------------------");
                userSelection = input.nextInt();
                }
                
                
                if(userSelection == 1){
                    service.ListOfNeed();
                }   
                else if(userSelection == 2){
                    service.DetailOfDonate(id);
                }
                
            }catch(Exception e){
                System.out.println("!!!wrong input!!!");
            }
        
       }while(userSelection < 0);
    }
}