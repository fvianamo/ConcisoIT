
package dao;

import db.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Stop;

public class StopDAO {
    public static Connection conn;
    public static Statement st;

    public StopDAO(DBUtils db) {
        conn = db.conn;
        st = db.st;
    }
    
    public static void addStop(Stop stop) throws SQLException{    
        String query = "INSERT INTO Stops (latit, longi) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setDouble(1, stop.getLatit());
        ps.setDouble(2, stop.getLongi());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void deleteStop(Stop stop) throws SQLException{    
        String query = "DELETE FROM Stop WHERE stopID = ?";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setInt(1, stop.getStopID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void updateStop(Stop stop) throws SQLException{
        String query = "UPDATE Stops SET latit = ?, longi = ? WHERE stopID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, stop.getLatit());
        ps.setDouble(2, stop.getLongi());
        ps.setInt(3, stop.getStopID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static List<Stop> getAllStops() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT * FROM Stops");
        List<Stop> list = new ArrayList<Stop>();
        
        while(rs.next()){
            Stop temp = new Stop(rs.getInt("stopID"),rs.getDouble("latit") , rs.getDouble("longi"));
            list.add(temp);
        }
        
        return list;
    }
    
}