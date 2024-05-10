package lifeindonation;

/*
donorService class provide service for donor.
the service: 
1- take a Detail of Donate 
2- List Of Need 
*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class donorService implements donorServiceInterface{
        Scanner input = new Scanner(System.in); 
        static ResultSet r;
        static Statement ss;
        static String query;
        static Connection c;
        DataBase conn = DataBase.getInstance();
        String[] elements = new String[7] ;
        
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
        //3
    
        
////////////////////////////////donor service///////////////////////////////////
    
    //1 (Detail of Donate)
    public void saveDonateDeviceInArray(String name,String status,
            String type,int duration, String description,int id, 
            int numberOfDevices){
        elements[0]=name;
        elements[1]=status;
        elements[2]=type;
        elements[3]=Integer.toString(duration);
        elements[4]=description;
        elements[5] = Integer.toString(id);
        elements[6]= Integer.toString(numberOfDevices);
    }
    
    public void DetailOfDonate(){
        device device = new device(elements[0], elements[1], elements[2],
                Integer.valueOf(elements[3]), elements[4], 
                Integer.valueOf(elements[5]), 
                Integer.valueOf(elements[6]));
        try{
            device.create_donated_devices_table();
            device.add_donated_device();
        }catch(Exception e){
            System.out.println("\nThere was an error in donorService class "
                    + "at addDetailOfDonateDeviceToDatabase method . Try later");
        }   
    }
    
    //2 (List Of Need)
    @Override
    public void ListOfNeed(){
        
        System.out.println("-------------------------------------------------");
        System.out.println("List Of device Needed: ");
        
        DataBase conn = DataBase.getInstance();
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
            System.out.println("error in ListOfNeed method at donorService class");
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
