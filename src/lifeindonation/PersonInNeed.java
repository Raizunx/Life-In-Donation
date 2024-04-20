package lifeindonation;

/*
PersonInNeed class represent child of User class
it display the list of services for Person In Need and then routing them to
appropriate class to implements their requests.
*/

import static java.lang.System.exit;
import java.util.Scanner;

public class PersonInNeed extends User{
    
    private int age;
    private int id;
    private String first_name;
    private String middle_name;
    private String surname;
    private int phone_number;
    private String address;
    PersonInNeed_Service service = new PersonInNeed_Service();
    
    Scanner input = new Scanner(System.in);
    
    
    ////////////////////////////consturctors////////////////////////////
    //1 (empty)
    public PersonInNeed(){
        System.out.println("detail of PersonInNeed not sent.");
    }
    //2
    public PersonInNeed(int id,String FN,String MN,String SN,int phone,String address, String email)
    {
        super(id,FN,MN,SN,phone,address,email);
        add_Pin_ToDataBase();
        this.id = id;
    }
    
    
    ////////////////////////////core method////////////////////////////
    public void displayService(){
        
        do{
        int userSelection=0;
        
        try{
            System.out.print("-------------------------------------------------"
                    + "\nChoose a Service: "
                    + "\n> 1- List of available medical devices "
                    + "\n> 2- Add a specific need"
                    + "\n> 3- Search for a medical device" 
                    + "\n> 4- Exit" 
                    + "\n-------------------------------------------------\n");
            userSelection = input.nextInt();
        
            //check input
            while(userSelection != 1 && userSelection != 2 && userSelection != 3 && userSelection != 4){
                System.out.print("!!! wrong input !!! \n"
                    + "-------------------------------------------------"
                    + "\nChoose a Service: "
                    + "\n> 1- List of available medical devices "
                    + "\n> 2- Add a specific need"
                    + "\n> 3- Search for a medical device"  
                    + "\n> 4- Exit"
                    + "\n-------------------------------------------------\n");
                userSelection = input.nextInt();
            }
            
            
        }catch(Exception e){
           System.out.println("!!!wrong input!!!");
           System.out.println("your input should be number");
        }
        
    switch(userSelection){
       
            case 1:
                service.ListOfAvailableDevice();
                break;
            
            case 2:
                service.specificNeed(id);
                break; 
        
            case 3:
                service.SearchToOrder();
                break;
                
             case 4:
                exit(0);
                break;

            default:
            System.out.println("Invalid Choice Try Again");
                                                                                                      
            }
            
        }while (true);
    }//end method
    
    
    
    ////////////////////////////set & get methods////////////////////////////
    public void setID(int id){
        this.id =id; 
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public void setMiddle_name(String middle_name){
        this.middle_name = middle_name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setPhone_number(int phone_number){
        this.phone_number = phone_number;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    
    public int getID(){
        return id;  
    }
    public String getFirst_name(){
        return first_name;
    }
    public String getMiddle_name(){
        return middle_name;
    }
    public String getSurname(){
        return surname;
    }
    public int getPhone_number(){
        return phone_number;
    }
    public String getAddress(){
        return address;
    }
    
    
    
}

