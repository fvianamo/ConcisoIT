
package dao;

import db.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Relation;



public class RelationDAO {
    public static Connection conn;
    public static Statement st;

    public RelationDAO(DBUtils db) {
        conn = db.conn;
        st = db.st;
    }
    
    public static void addRelation(Relation relation) throws SQLException{    
        String query = "INSERT INTO RELATIONS (routeID, stopID) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setInt(1, relation.getRouteID());
        ps.setInt(2, relation.getStopID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void deleteRelation(Relation relation) throws SQLException{    
        String query = "DELETE FROM RELATIONS WHERE relationsID = ?";
        PreparedStatement ps = conn.prepareStatement(query); //
        ps.setInt(1, relation.getRelationID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static void updateRelation(Relation relation) throws SQLException{
        String query = "UPDATE Relations SET routeID = ?, stopID = ? WHERE relationsID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, relation.getRouteID());
        ps.setInt(2, relation.getStopID());
        ps.setInt(3, relation.getRelationID());
        ps.executeUpdate();
        ps.close();
    }
    
    public static List<Relation> getAllRelations() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT * FROM RELATIONS");
        List<Relation> list = new ArrayList<Relation>();
        
        while(rs.next()){
            Relation temp = new Relation(rs.getInt("relationsID"), rs.getInt("routeID"), rs.getInt("stopID"));
            list.add(temp);
        }
        
        return list;
    }
    
}
