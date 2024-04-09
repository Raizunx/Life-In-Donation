package lifeindonation;


import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LifeInDonation {

    static Connection c_Connection; 
    static Statement statement;
    static String query;
    
    public static void main(String[] args) throws SQLException {
        
        do{
        int choice = 0;
              
            System.out.println("\n.......life in Donation........ ");
            System.out.println("-------------------------------------------------");
            System.out.println("Choose a Role: ");
            System.out.println("> 1- Donor");
            System.out.println("> 2- Those in need");
            System.out.println("> 3- Exit");
            System.out.println("-------------------------------------------------");
      
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
       
            switch(choice){
       
            case 1:
                Donor(); 
                break;
            
            case 2:
                Those_in_need();
                break; 
        
            case 3:
                exit(0);
                break;

            default:
            System.out.println("Invalid Choice Try Again");
                                                                                                      
            }
            
        }while (true);
 
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
        }catch(Exception n){
            System.out.println("invalid input!");
        }
           
    }
        
    
}