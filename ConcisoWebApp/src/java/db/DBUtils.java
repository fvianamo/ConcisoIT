/*
Class that implements an object to create connection
with the database.
*/
package db;

import java.sql.*;

public class DBUtils {
    public static Connection conn;
    public static Statement st;
    
    //substituir por url, user e password do database criado
    private static final String url = "jdbc:mysql://localhost:3306/ConcisoIT";
    private static final String user = "root";
    private static final String password = "password";
       
    public static ResultSet dbConsult(String query) throws SQLException {
        return st.executeQuery(query);
    }
    
    public DBUtils() throws SQLException, ClassNotFoundException {
        //
        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(url, user, password);
        //Create a statement object scrollable and updateable
        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
}
