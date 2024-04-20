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
        
        UserFactory user = new UserFactory();
        
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
                user.typeOfUser("Donor"); 
                break;
            
            case 2:
                user.typeOfUser("Those in Need");
                break; 
        
            case 3:
                exit(0);
                break;

            default:
            System.out.println("Invalid Choice Try Again");
                                                                                                      
            }
            
        }while (true);
 
    } 
    
}
