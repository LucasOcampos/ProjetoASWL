package ifsp.projeto.poo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifsp.projeto.poo.model.Produto;
import ifsp.projeto.poo.model.database.DataBaseFactory;
import ifsp.projeto.poo.model.database.Database;

public class ProdutoDAO {

  private final Database database = DataBaseFactory.getDatabase("mysql");
  private final Connection conn = database.conectar();

  public boolean inserir(Produto produto) {
    try {
      String sql ="insert into tb_cad_produto(cod_barra, descricao, preco_custo, preco_venda, qtd_estoque,categoria)values(?,?,?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getCodigoBarra());
      pst.setString(2, produto.getNome());
      pst.setDouble(3, produto.getPrecoCusto());
      pst.setDouble(4, produto.getPrecoVenda());
      pst.setInt(5, produto.getQuantidadeEstoque());
      pst.setString(6, produto.getCategoria());

      if (!pst.execute()) {
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  public boolean alterar(Produto produto) {
    String sql =
      "update tb_cad_produto set descricao =?,preco_custo=?,preco_venda=?,qtd_estoque=?,categoria=? where cod_barra =?;";

    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getNome());
      pst.setDouble(2, produto.getPrecoCusto());
      pst.setDouble(3, produto.getPrecoVenda());
      pst.setInt(4, produto.getQuantidadeEstoque());
      pst.setString(5, produto.getCategoria());
      pst.setString(6, produto.getCodigoBarra());
      pst.execute();
      return true;
    } catch (Exception e) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
      return false;
    }
  }

  public boolean remover(Produto produto) {
    String sql = "DELETE FROM tb_cad_produto WHERE cod_barra=?";
    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getCodigoBarra());
      pst.execute();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }

  public List<Produto> listar() {
    String sql = "select * from tb_cad_produto";
    List<Produto> retorno = new ArrayList<>();
    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        Produto produto = new Produto();
        produto.setCodigoBarra(rs.getString("cod_barra"));
        produto.setNome(rs.getString("descricao"));
        produto.setPrecoCusto(rs.getDouble("preco_custo"));
        produto.setPrecoVenda(rs.getDouble("preco_venda"));
        produto.setQuantidadeEstoque(rs.getInt("qtd_estoque"));
        produto.setCategoria(rs.getString("categoria"));
        retorno.add(produto);
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return retorno;
  }

  public Produto buscarPorCodBarra(String codigoBarra) throws SQLException {
    String sql = "select * from tb_cad_produto where cod_barra = ? ";
    Produto retorno = new Produto();   
    
    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, codigoBarra);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {        
        retorno.setCodigoBarra(rs.getString("cod_barra"));
        retorno.setNome(rs.getString("descricao"));
        retorno.setPrecoVenda((Double)rs.getDouble("preco_venda"));
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return retorno;
  }  

  public Integer verificaDados(String valor){
    Integer retorno =0;
    String sql = "select * from tb_cad_produto where cod_barra = ? ";
   
    try {
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, valor);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {       
       retorno = Integer.valueOf(rs.getString("cod_barra"));    
      }
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return retorno;
  }
}
