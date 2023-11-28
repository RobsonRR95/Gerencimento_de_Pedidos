
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQL {
    public static java.sql.Connection getConexaoMySQL(){
        Connection conn = null;
        
        String serverName = "localhost";
        String mydatabase = "projeto_final";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "root";
        String password = "";
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    
    }
}
