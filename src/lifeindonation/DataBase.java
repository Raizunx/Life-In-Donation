package lifeindonation;

//this class for connect code with Data Base

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  DataBase {
    
    private static final String host ="root";
    private static final String password ="";
    private static final String address ="jdbc:mysql://localhost/LifeInDonationDataBase";
    private static DataBase singletonInstance = null; 
    
    private DataBase(){}
    
    public static DataBase getInstane(){
        if(singletonInstance == null)
            singletonInstance = new DataBase();
        return singletonInstance;
    }
    
    public static Connection connect()throws SQLException{
        return DriverManager.getConnection(address, host, password);
    }
    
    
    
}

