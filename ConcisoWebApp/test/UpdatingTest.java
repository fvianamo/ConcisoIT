
import dao.*;
import db.*;
import java.sql.SQLException;
import model.*;

public class UpdatingTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBUtils dbManager = new DBUtils();
        
        BusDAO busManager = new BusDAO(dbManager);
        
        Bus newBus = new Bus(1, "BLS2222", 1);
        
        busManager.updateBus(newBus);
    }
    
}
