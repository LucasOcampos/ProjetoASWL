package ifsp.projeto.poo.model.database;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMysql implements Database {

    private static Connection conn;
//METODO DE CONEXÃO AO BANCO DE DADOS MYSQL
    @Override
    public Connection conectar() {
        String url ="jdbc:mysql://localhost:3306/db_solid_pdv_lp3?serverTimezone-UTC";
        String usuario = "root";
        String password = "";
        try {            
            conn = DriverManager.getConnection(url, usuario, password);
            return conn;
        } catch (SQLException ex) {
           Logger.getLogger(DataBaseMysql.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }        
    }
    @Override
    public void desconectar(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
}