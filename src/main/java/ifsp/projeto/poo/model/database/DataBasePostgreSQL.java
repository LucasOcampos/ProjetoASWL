package ifsp.projeto.poo.model.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBasePostgreSQL implements Database {
    private Connection conn;
   // METODO DE CONEXÃO AO BANCO DE DADOS POSTGREE
    @Override
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/db_solid_pdv_lp3", "postgres","postgres");
            return this.conn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void desconectar(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}