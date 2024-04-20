package lifeindonation;
/*
device Class provide:
1- create tables for donated device and need device
2- add values to tables
*/
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;

class device {
    
    static Connection N_Connection; 
    static Connection D_Connection; 
    static Connection o_Connection; 
    static Statement statement;
    DataBase conn = new DataBase();
    static String query;
    
    private String name, status, type,description;
    private int duration=0, id,number_of_needs,number_of_devices,dev_num;
    
    
    ////////////////////////////consturctors////////////////////////////
    //1 (all attribute)
    public device(String name, String status, String type, int duration,String description
                  ,int id, int nn, int nd){
        this.name = name;
        this.status = status;
        this.type = type;
        this.description = description;
        this.duration =duration;
        this.id=id;
        this.number_of_needs=nn;
        this.number_of_devices=nd;
    }
    
    //2 (donor)
    public device(String name, String status, String type, int duration,String description
                  ,int id, int nn){
        this.name = name;
        this.status = status;
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.id=id;
        this.number_of_needs=nn;
        
    }
    
    //3 (need)
    public device(String name, String type,String description,int id, int nd){
        this.name = name;
        this.type = type;
        this.description = description;
        this.duration =duration;
        this.id=id;
        this.number_of_needs=nd;
    }
    
    //4 (empty constrctor)
    public device(){
    System.out.println("detail of device not sent.");
    }
    
    
    
    ////////////////////////////create table device////////////////////////////
    //1 (donated device)
    public void create_donated_devices_table(){
        try
        {  
            D_Connection = conn.connect(); 
            statement = D_Connection.createStatement(); 
            
            query = "create table donated_devices(" 
                + "No_Dev int(100) not null," 
                + "National_Identity_of_donor int(10) not null," 
                + "Device_name varchar(50) not null," 
                + "Device_type varchar(15) not null," 
                + "Device_status varchar(5) not null," 
                + "Device_usage_time int(2) not null," 
                + "Device_description varchar(250) not null," 
                + "number_of_devices int(5) not null," 
                + "constraint pk1 primary key (Device_name,No_Dev),"
+ "constraint Fk1 foreign key (National_Identity_of_donor) REFERENCES donor(National_Identity)" 
                + ")";
        
            statement.execute(query);
        
        }catch(Exception e){ 
            System.out.println(e.getMessage());
        }finally{
            try{
                D_Connection.close();
                statement.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//end method
    
    //2 (need device)
    public void create_needed_device_table(){
        
        try
        {  
            N_Connection = conn.connect(); 
            statement = N_Connection.createStatement(); 
            
            query = "create table needed_devices(" 
                + "National_Identity_of_need int(10) not null," 
                + "Device_name varchar(50) not null," 
                + "Device_type varchar(15) not null," 
                + "Device_description varchar(250) not null," 
                + "number_of_needs int(5) not null," 
                + "constraint pk3 primary key (Device_name,Device_type),"
+ "constraint Fk4 FOREIGN key (National_Identity_of_need) REFERENCES person_in_need(National_Identity)" 
                + ")";                    
            statement.execute(query);
        
        }catch(Exception e){ 
            System.out.println(e.getMessage());
        }finally{
            try{
                N_Connection.close();
                statement.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//end method
    
    ////////////////////////////add device////////////////////////////
    
    //1 (donte device)
    public void add_donated_device(){
        try
        {  
            Random r= new Random();
            HashSet<Integer> set=new HashSet<>();
           while(set.size()<1){
               int random=r.nextInt(99)+10;
               set.add(random);
           }
            D_Connection = conn.connect(); 
            statement =D_Connection.createStatement(); 
            for(int count:set){
            query ="insert into donated_devices values("
                + "'"+count+"',"
                + "'"+id+"',"
                + "'"+name+"',"
                + "'"+type+"',"
                + "'"+status+"',"
                + "'"+duration+"',"
                + "'"+description+"',"
                + "'"+number_of_devices+"')";
            statement.execute(query);}
            
            System.out.println("\ndevice successfully added. "
        + "\nWe will contact you to set a date for receiving the device\n");
        
        }catch(SQLException e){ 
            System.out.println(e.getMessage());
            
        }finally{
            try{
                D_Connection.close();
                statement.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    
    //2 (need device)
    public void add_need_device(){
        try
        {  
            N_Connection = conn.connect(); 
        
            statement =N_Connection.createStatement(); 
            query ="insert into needed_devices values("
                + "'"+id+"',"
                + "'"+name+"',"
                + "'"+type+"',"
                + "'"+description+"',"
                + "'"+number_of_needs+"')";
        
            statement.execute(query);
            
            System.out.println("\nYour specific need successfully added. "
            + "\nWe will contact you to tell you if your request accepted or rejected");
        
        }catch(SQLException e){ 
            System.out.println(e.getMessage());
            
        }finally{
            try{
                N_Connection.close();
                statement.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    
}