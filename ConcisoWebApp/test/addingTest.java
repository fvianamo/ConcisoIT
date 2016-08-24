
import dao.*;
import db.*;
import java.sql.SQLException;
import model.*;

public class addingTest {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBUtils dbManager = new DBUtils();
        
        Route newRoute = new Route(0, "rota1");
        //Coordenadas da Conciso ;)
        Stop newStop = new Stop(0, -5.820660, -35.21004);
        Relation newRelation = new Relation(0, 1, 1);
        Bus newBus = new Bus(0, "BLS1111", 1);
        
        BusDAO busManager = new BusDAO(dbManager);
        StopDAO stopManager = new StopDAO(dbManager);
        RelationDAO relationManager = new RelationDAO(dbManager);
        RouteDAO routeManager = new RouteDAO(dbManager);
        
        routeManager.addRoute(newRoute);
        stopManager.addStop(newStop);
        relationManager.addRelation(newRelation);
        busManager.addBus(newBus);
    }
    
}
