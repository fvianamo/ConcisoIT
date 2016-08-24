
package dao;

import db.DBUtils;
import model.Bus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    public static Connection conn;
    public static Statement st;

    public BusDAO(DBUtils db) {
        this.conn = db.conn;
        this.st = db.st;
    }
    
    public static void addBus(Bus bus) throws SQLException{    
        String query = "INSERT INTO Buses (licensePlate, routeFK) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, bus.getLicensePlate());
        ps.setInt(2, bus.getRouteFK());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void deleteBus(Bus bus) throws SQLException{    
        String query = "DELETE FROM Buses WHERE busID = ?";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setInt(1, bus.getBusID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void updateBus(Bus bus) throws SQLException{
        String query = "UPDATE Buses SET licensePlate = ?, routeFK = ? WHERE busID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, bus.getLicensePlate());
        ps.setInt(2, bus.getRouteFK());
        ps.setInt(3, bus.getBusID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static List<Bus> getAllBuses() throws SQLException{
        //st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Buses");
        List<Bus> list = new ArrayList<Bus>();
        
        while(rs.next()){
            Bus temp = new Bus(rs.getInt("busID"), rs.getString("licensePlate"), rs.getInt("routeFK"));
            list.add(temp);
        }
        
        return list;
    }
}
