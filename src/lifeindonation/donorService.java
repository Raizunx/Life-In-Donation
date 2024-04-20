package lifeindonation;

/*
donorService class provide service for donor.
the service: 
1- take a Detail of Donate 
2- List Of Need 
3- search 
*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class donorService {
        Scanner input = new Scanner(System.in); 
        static ResultSet r;
        static Statement ss;
        static String query;
        static Connection c;
        DataBase conn = new DataBase();
//////////////////////////////////consturctors//////////////////////////////////
        //1
        public donorService(){
        }
        //2
        public donorService(ResultSet r, Statement ss, String query, 
                Connection c, DataBase conn){
        this.r = r;
        this.ss = ss;
        this.query = query;
        this.c = c;
        this.conn = conn;
        }
    
        
////////////////////////////////donor service///////////////////////////////////
    
    //1 (Detail of Donate)
    public void DetailOfDonate(int id){
        int duration = 0;
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
        int nn = input.nextInt();
        //6
        System.out.print("Device description: ");
        String description = input.next();
        
        //========================================//
        
        device d = new device(name, status, type, duration, description, id, nn);
        
        try{
            d.create_donated_devices_table();
            d.add_donated_device();
            
        }catch(Exception e){
            System.out.println("\nThere was an error. Try later");
        }
        }catch(Exception e){
            System.out.println("\nThere was an error. Try later");
        }
        
    }
    
    //2 (List Of Need)
    public void ListOfNeed(){
        
        System.out.println("-------------------------------------------------");
        System.out.println("List Of device Needed: ");
        
        DataBase conn = new DataBase();
        try{
            c = conn.connect();
            ss = c.createStatement();
            
            query = "select * from needed_devices";
            r = ss.executeQuery(query);
            int count = 0;
            while(r.next()){
                count++;
                System.out.println("("+count+")");
                System.out.println("name: "+r.getString("Device_name"));
                System.out.println("type: "+r.getString("Device_type"));
                System.out.println("description: " + r.getString("Device_description"));
                System.out.println("number_of_needs: " + r.getInt("number_of_needs"));
                System.out.println("-------------------------------------------------");
            }
           
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                c.close();
                ss.close();
            }catch(SQLException e2){
                System.out.println(e2.getMessage());
            }
            
        }
    }
    
///////////////////////////////set & get methods////////////////////////////////
    public void setR(ResultSet r){
        this.r = r;
    }
    public void setSS (Statement ss){
        this.ss = ss;
    }
    public void setQuery (String query){
        this.query = query;
    }
    public void setC (Connection c){
        this.c = c;
    }
    public void setconn (DataBase conn){
        this.conn = conn;
    }
    
    
    public ResultSet getR(){
        return this.r;
    }
    public Statement getSS (){
        return ss;
    }
    public String getQuery (){
        return query;
    }
    public Connection getC (){
        return c;
    }
    public DataBase getconn (){
        return conn;
    }
    
}
