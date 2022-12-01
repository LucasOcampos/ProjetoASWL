package ifsp.projeto.poo.model.database;

import java.sql.Connection;

//Interface para logar no banco de dados
//E os metodos de conexão
public interface Database  {
    public Connection conectar();
    public void desconectar(Connection conn);
}