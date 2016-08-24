
package dao;

import db.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Route;


public class RouteDAO {
    public static Connection conn;
    public static Statement st;

    public RouteDAO(DBUtils db) {
        conn = db.conn;
        st = db.st;
    }
    
    public static void addRoute(Route route) throws SQLException{    
        String query = "INSERT INTO Routes (name) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setString(1, route.getName());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void deleteRoute(Route route) throws SQLException{    
        String query = "DELETE FROM Route WHERE routeID = ?";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setInt(1, route.getRouteID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void updateRoute(Route route) throws SQLException{
        String query = "UPDATE Routes SET name = ? WHERE routeID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, route.getName());
        ps.setInt(2, route.getRouteID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static List<Route> getAllRoutes() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT * FROM Routes");
        List<Route> list = new ArrayList<Route>();
        
        while(rs.next()){
            Route temp = new Route(rs.getInt("routeID"), rs.getString("name"));
            list.add(temp);
        }
        
        return list;
    }
    
}
