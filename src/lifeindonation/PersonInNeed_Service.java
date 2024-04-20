package lifeindonation;

/*
this class provide service for person in need.
the service: 
1- Display List Of Available Device 
2- Add Specific Need 
3- search 
*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersonInNeed_Service {
    
        Scanner input = new Scanner(System.in); 
        static ResultSet r;
        static Statement ss;
        static String query;
        static Connection c,cn;
        DataBase conn = new DataBase();
        int id;
        
//////////////////////////////////consturctors//////////////////////////////////
        //1
        public PersonInNeed_Service(){
        }
        //2
        public PersonInNeed_Service(ResultSet r, Statement ss, String query, 
                Connection c,Connection cn, DataBase conn, int id){
        this.r = r;
        this.ss = ss;
        this.query = query;
        this.c = c;
        this.cn = cn;
        this.conn = conn;
        this.id = id;
        }
    
//////////////////////////////PersonInNeed service//////////////////////////////
    
    //1 (List of available device)
    public void ListOfAvailableDevice(){
    
        System.out.println("\nList Of Available device: ");
        
       try{
            c = conn.connect();
            ss = c.createStatement();
            query = "select * from donated_devices";
            r = ss.executeQuery(query);
            int count = 0;
            while(r.next()){
                count++;
                System.out.println("("+count+")");
                System.out.println("No.Dev: "+r.getInt("No_Dev"));
                System.out.println("name: "+r.getString("Device_name"));
                System.out.println("type: "+r.getString("Device_type"));
                System.out.println("status: " + r.getString("Device_status"));
                System.out.println("duration use: " + r.getString("Device_usage_time"));
                System.out.println("description: " + r.getString("Device_description"));
                System.out.println("number_of_devices: " + r.getString("number_of_devices"));
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
    
    
    //2 (Add Specific Need)
    public void specificNeed(int id){
         
        Scanner input = new Scanner(System.in);
        String name,description,address;
        try{
        System.out.print("\nEnter the name of the device: ");
        name = input.nextLine();
        
        System.out.print("Device type (electronic or normal): ");
        String type = input.next();
        
        System.out.print("number of Devices needed: ");
        int nd = input.nextInt();
        
        System.out.print("Device description: ");
        input.nextLine(); //because it count enter button
        description = input.nextLine();
        
        
            device add = new device(name, type, description , id,  nd);
            try{
                add.create_needed_device_table();
                add.add_need_device();
            
            }catch(Exception e){
                System.out.println("\nThere was an error. Try later");
            }
        }catch(Exception e){
            System.out.println("\nThere was an error. Try later");
        }
    }
     
    
    //3 (Search)
    public void SearchToOrder(){
    
        System.out.println("\nEnter the name of the device: ");
        Scanner scan = new Scanner(System.in);
        String search=scan.nextLine();
        System.out.print("\n");
        
        try{
            c = conn.connect();
            ss = c.createStatement();
            query = "select * from donated_devices WHERE Device_name Like'"+search+"'";
            r = ss.executeQuery(query);
            while(r.next()){
                System.out.println("No.dev: "+r.getInt("No_dev"));
                System.out.println("name: "+r.getString("Device_name"));
                System.out.println("type: "+r.getString("Device_type"));
                System.out.println("status: " + r.getString("Device_status"));
                System.out.println("duration use: " + r.getString("Device_usage_time"));
                System.out.println("description: " + r.getString("Device_description"));
                System.out.println("number_of_devices: " + r.getString("number_of_devices"));
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
    public void setCN (Connection cn){
        this.cn = cn;
    }
    public void setconn (DataBase conn){
        this.conn = conn;
    }
    public void setID (int id){
        this.id = id;
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
    public Connection getCN (){
        return cn;
    }
    public DataBase getconn (){
        return conn;
    }
    public int getID (){
        return id;
    }
    
}