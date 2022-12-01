package ifsp.projeto.poo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifsp.projeto.poo.model.Administrador;
import ifsp.projeto.poo.model.Funcionario;
import ifsp.projeto.poo.model.Usuario;
import ifsp.projeto.poo.model.database.DataBaseFactory;
import ifsp.projeto.poo.model.database.Database;
import ifsp.projeto.poo.utils.Metodos;

public class UsuarioDAO {

  private final Database database = DataBaseFactory.getDatabase("mysql");
  private final Connection conn = database.conectar();

  ResultSet rs = null;
  Metodos msg = new Metodos();
  Usuario usuario;

  public List<Usuario> listar() {
    String sql = "select * from tb_usuario";
    List<Usuario> retorno = new ArrayList<>();
    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        usuario.setNome(rs.getString("nome"));
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));
        retorno.add(usuario);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return retorno;
  }

  public boolean logar(String login, String senha) {
    try {
      PreparedStatement pst = conn.prepareStatement("select * from tb_usuario where login=? and senha=?");
      pst.setString(1, login);
      pst.setString(2, senha);

      rs = pst.executeQuery();
      if (rs.next()) {
        return true;
      }
      
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  public boolean inserir(Usuario usuario) {
    try {
      if (usuario instanceof Funcionario) {
        String sql ="INSERT INTO tb_usuario(nome, login, senha, telefone, cpf) VALUES(?,?,?,?,?)";
        Funcionario caixa = (Funcionario) usuario;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, caixa.getNome());
        pst.setString(2, caixa.getLogin());
        pst.setString(3, caixa.getSenha());
        pst.setString(4, caixa.getTelefone());
        pst.setString(5, caixa.getCpf());
        pst.execute();
        return true;
      } else if (usuario instanceof Administrador) {
        String sql ="INSERT INTO tb_usuario(nome, login, senha, telefone, cnpj) VALUES(?,?,?,?,?)";
        Administrador gerente = (Administrador) usuario;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, gerente.getNome());
        pst.setString(2, gerente.getLogin());
        pst.setString(3, gerente.getSenha());
        pst.setString(4, gerente.getTelefone());
        pst.setString(5, gerente.getCnpj());
        pst.execute();
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }


}
