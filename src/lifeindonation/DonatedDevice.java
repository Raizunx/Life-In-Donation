package lifeindonation;

import java.sql.*;

public class DonatedDevice implements DeviceFlyweightInterface {
    DataBase conn = DataBase.getInstance();
    
    //avalabel device
    @Override
    public void deviceList() {
        Statement statement;
        Connection connection1;
       try{
            connection1 = conn.connect();
            statement = connection1.createStatement();
            String query = "select * from donated_devices";
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            while(resultSet.next()){
                count++;
                System.out.println("("+count+")");
                System.out.println("No.Dev: "+resultSet.getInt("No_Dev"));
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
}
