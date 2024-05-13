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
        DataBase DataBaseConnection = DataBase.getInstance();
        int id;
        
//////////////////////////////////consturctors//////////////////////////////////
        //1
        public PersonInNeed_Service(){}
        
        //2
        public PersonInNeed_Service(DataBase conn, int id){
            this.DataBaseConnection = conn;
            this.id = id;
        }
    
//////////////////////////////PersonInNeed service//////////////////////////////
    
    //1 (List of available device)
    public void ListOfAvailableDevice(){
    
        System.out.println("\nList Of Available device: ");
        DeviceFlyweighFactory.getDevice("donated device list");
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
            int number_of_needs = input.nextInt();
        
            System.out.print("Device description: ");
            input.nextLine(); //because it count enter button
            description = input.nextLine(); 
            try
            {  
                Connection N_Connection = DataBaseConnection.connect(); 
                Statement statement =N_Connection.createStatement(); 
                String query ="insert into needed_devices values("
                    + "'"+id+"',"
                    + "'"+name+"',"
                    + "'"+type+"',"
                    + "'"+description+"',"
                    + "'"+number_of_needs+"')";
                statement.execute(query);
                System.out.println("\nYour specific need successfully added. "
                    + "\nWe will contact you to tell you if your request accepted or rejected");
                try{
                    N_Connection.close();
                    statement.close();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
        }catch(SQLException e){ 
            System.out.println(e.getMessage());   
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
        
        Statement statement;
        Connection connection1;
        
        try{
            connection1 = DataBaseConnection.connect();
            statement = connection1.createStatement();
            String query = "select * from donated_devices WHERE Device_name Like'"+search+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("No.dev: "+resultSet.getInt("No_dev"));
                System.out.println("name: "+resultSet.getString("Device_name"));
                System.out.println("type: "+resultSet.getString("Device_type"));
                System.out.println("status: " + resultSet.getString("Device_status"));
                System.out.println("duration use: " + resultSet.getString("Device_usage_time"));
                System.out.println("description: " + resultSet.getString("Device_description"));
                System.out.println("number_of_devices: " + resultSet.getString("number_of_devices"));
                System.out.println("-------------------------------------------------");
            }
            try{
                connection1.close();
                statement.close();
            }catch(SQLException e2){
                System.out.println(e2.getMessage());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
///////////////////////////////set & get methods////////////////////////////////
    public void setDataBaseConnection (DataBase con){
        this.DataBaseConnection = con;
    }
    public void setID (int id){
        this.id = id;
    }
    
    
    public DataBase getDataBaseConnection (){
        return DataBaseConnection;
    }
    public int getID (){
        return id;
    }
    
}
