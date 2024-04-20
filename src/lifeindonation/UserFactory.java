package lifeindonation;

import java.util.Scanner;

/**
 * a class to apply Factory desgin pattern by spicfying which user to create
 * to know which service should be displayed
 */
public class UserFactory {
    
    //Factory Method
    public User typeOfUser (String type){
        
        if (type==null)
            return null;
        else if(type.equalsIgnoreCase("Donor"))
            Donor();
        else if(type.equalsIgnoreCase("Those in Need"))
            Those_in_need();
        
        return null;
        
    } 
        
    public static void Donor(){
        
        User u = new User();
        u.create_donor_table();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please Enter The Following Personal information: ");
        
        try{
                String id ;
                do {
                    System.out.print("ID: ");
                    id = keyboard.next();
    
                    if (id.length() != 10) {
                        System.out.println("ID number must be 10 digits. Please re-enter.");
                        continue;
                    }
                    break; 
                } while (true); 
                int ID = Integer.parseInt(id);
                
                System.out.print("First Name: ");
                String first_name = keyboard.next();
                System.out.print("Middle Name: ");
                String middle_name = keyboard.next();
                System.out.print("Surname: ");
                String surname = keyboard.next();
                
                String phoneNumber;
                do {
                    System.out.print("Enter your phone number: ");
                    phoneNumber = keyboard.next();
    
                    if (phoneNumber.length() != 10) {
                        System.out.println("Phone number must be 10 digits. Please re-enter.");
                        continue;
                    }
                    if (!phoneNumber.startsWith("05")) {
                    System.out.println("Phone number must start with 05. Please re-enter.");
                    continue;
                    }
                    break; 
    
                } while (true); 
                
                int phoneNumbers = Integer.parseInt(phoneNumber);
               
                System.out.print("email: ");
                String email = keyboard.next();
                
                System.out.print("Address: ");
                String address = keyboard.next();
                
                Donor donor_info = new Donor(ID, first_name, middle_name, 
                        surname, phoneNumbers, address, email);
                donor_info.displayService();
                
        }catch(Exception e){
            System.out.println("invalid input!");
        }
                
    }
    
    public static void Those_in_need(){
        Scanner keyboard = new Scanner(System.in);
        
        User u = new User();
        u.create_PiN_table();
        try{
                System.out.println("Please Enter The Following Personal information: ");
                
                String id ;
                do {
                    System.out.print("ID: ");
                    id = keyboard.next();
    
                    if (id.length() != 10) {
                        System.out.println("ID number must be 10 digits. Please re-enter.");
                        continue;
                    }
                    break; 
                } while (true); 
                int ID = Integer.parseInt(id);
                
                System.out.print("First Name: ");
                String first_name = keyboard.next();
                
                System.out.print("Middle Name: ");
                String middle_name = keyboard.next();
                
                System.out.print("Surname: ");
                String surname = keyboard.next();
                
                
                String phoneNumber;
                do {
                    System.out.print("Enter your phone number: ");
                    phoneNumber = keyboard.next();
    
                    if (phoneNumber.length() != 10) {
                        System.out.println("Phone number must be 10 digits. Please re-enter.");
                        continue;
                    }
                    if (!phoneNumber.startsWith("05")) {
                    System.out.println("Phone number must start with 05. Please re-enter.");
                    continue;
                    }
                    break; 
                    
                } while (true); 
                int phoneNumbers = Integer.parseInt(phoneNumber);
                
                System.out.print("email: ");
                String email = keyboard.next();
                
                System.out.print("Address: ");
                String address = keyboard.next();
                
                
                PersonInNeed person_in_need_info =new PersonInNeed(ID, 
                        first_name, middle_name, surname, phoneNumbers, 
                        address, email);
                person_in_need_info.displayService();
                
        }catch(Exception n){
            System.out.println("invalid input!");
        }
           
    }
       
}
