package lifeindonation;

import java.sql.Connection;
import java.sql.SQLException;

public class Mediator {
    
    public Connection reactOnDataBase() throws SQLException{
        DataBase connection = DataBase.getInstance();
        return connection.connect();
    }
}
