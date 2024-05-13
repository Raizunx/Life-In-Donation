package lifeindonation;

import java.sql.*;

public class NeededDevice implements DeviceFlyweightInterface {
    Mediator mediator = new Mediator();
    Connection conn;
    
    //disply needed device.
    @Override
    public void deviceList(){
        
        
        try{
            conn= mediator.reactOnDataBase();
            Connection c = conn;
            Statement ss = c.createStatement();
            
            String query = "select * from needed_devices";
            ResultSet r = ss.executeQuery(query);
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
            try{
                c.close();
                ss.close();
            }catch(SQLException e2){
                System.out.println(e2.getMessage());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("error in ListOfNeed method at donorService class");
        }
    }
}
