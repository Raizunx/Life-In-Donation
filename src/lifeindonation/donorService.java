package lifeindonation;

/*
donorService class provide service for donor.
the service: 
1- take a Detail of Donate 
2- List Of Need 
*/

import java.sql.*;
import java.util.HashSet;
import java.util.Random;

public class donorService implements donorServiceInterface{ 
        Mediator mediator = new Mediator();
        Connection conn;
        String[] elements = new String[7] ;
        
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
        try
        {  
            Random r = new Random();
            HashSet<Integer> set=new HashSet<>();
            while(set.size()<1){
               int random=r.nextInt(99)+10;
               set.add(random);
            }
            conn= mediator.reactOnDataBase();
            Connection D_Connection = conn; 
            Statement statement = D_Connection.createStatement(); 
            for(int count:set){
                String query ="insert into donated_devices values("
                    + "'"+count+"',"
                    + "'"+elements[5]+"',"
                    + "'"+elements[0]+"',"
                    + "'"+elements[2]+"',"
                    + "'"+elements[1]+"',"
                    + "'"+elements[3]+"',"
                    + "'"+elements[4]+"',"
                    + "'"+elements[6]+"')";
                statement.execute(query);
            }
            System.out.println("\ndevice successfully added. "
        + "\nWe will contact you to set a date for receiving the device\n");
            try{
                D_Connection.close();
                statement.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }catch(SQLException e){ 
            System.out.println(e.getMessage());   
        }
    }
    
    //2 (List Of Need)
    @Override
    public void ListOfNeed(){
        System.out.println("-------------------------------------------------");
        System.out.println("List Of device Needed: ");
        DeviceFlyweighFactory.getDevice("need device list");
    }
}

