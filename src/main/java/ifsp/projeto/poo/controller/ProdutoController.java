package ifsp.projeto.poo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ifsp.projeto.poo.model.Produto;
import ifsp.projeto.poo.model.dao.ProdutoDAO;
import ifsp.projeto.poo.utils.Metodos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
public class ProdutoController implements Initializable {
  
  @FXML
  private AnchorPane anchorPane;

  @FXML
  private Button btn_cadastrarProduto;

  @FXML
  private Button btn_editarProduto;

  @FXML
  private Button btn_excluirProduto;

  @FXML
  private TableColumn<Produto, String> col_codBarra;

  @FXML
  private TableColumn<Produto, String> col_descricao;

  @FXML
  private TableColumn<Produto, Integer> col_qtdEstoque;

  @FXML
  private TableColumn<Produto, String> col_valorCategoria;

  @FXML
  private TableColumn<Produto, Double> col_valorVenda;

  @FXML
  private TableColumn<Produto, Double> col_valorCusto;

  @FXML
  private TableView<Produto> tabela_produtos;

  @FXML
  private TextField txt_categoria;

  @FXML
  private TextField txt_codBarra;

  @FXML
  private TextField txt_descricao;

  @FXML
  private TextField txt_estoque;

  @FXML
  private TextField txt_porcentagemLucro;

  @FXML
  private TextField txt_valorCusto;

  @FXML
  private TextField txt_valorVenda;

  @FXML
  void cadastraProduto() throws IOException {
    inserirProduto();
  }

  @FXML
  void editaProduto(ActionEvent event) {}

  @FXML
  void excluiProduto(ActionEvent event) throws IOException {
    remover();
  }

  private List<Produto> listProdutos;
  private ObservableList<Produto> observableListProdutos;
  private final ProdutoDAO produtoDAO = new ProdutoDAO();
  private final Metodos msg = new Metodos();
  
  //NESSE METODO CARREGA TODOS OS PRODUTOS CADASTRADO NO BANCO  
  //E EXIBE NA TABELA DE CADASTRO
  public void carregarTabelaProdutos() {
    col_codBarra.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
    col_descricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
    col_valorVenda.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
    col_valorCusto.setCellValueFactory(new PropertyValueFactory<>("precoCusto"));
    col_valorCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    col_qtdEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));

    listProdutos = produtoDAO.listar();

    observableListProdutos = FXCollections.observableArrayList(listProdutos);
    tabela_produtos.setItems(observableListProdutos);
  }

  //METODO PARA INSERIR PRODUTO
  private void inserirProduto() throws IOException {
    if (verificaCampo()) {
      String codigoBarra = txt_codBarra.getText();
      String nome = txt_descricao.getText();
      Double precoCusto = Double.valueOf(txt_valorCusto.getText());
      Double precoVenda = Double.valueOf(txt_valorVenda.getText());
      Integer quantidadeEstoque = Integer.valueOf(txt_estoque.getText());
      String categoria = txt_categoria.getText();
      Produto produto = new Produto(
        codigoBarra,
        nome,
        precoCusto,
        precoVenda,
        quantidadeEstoque,
        categoria
      );
      if (produtoDAO.inserir(produto)) {
        msg.mensagemDeSucesso("Produto inserido com sucesso!");
        carregarTabelaProdutos();
        limpaCampo();
      }
    }else{
      msg.mensagemDeErro("Verifique todos os campos!");
    }
  }

  //VERIFICA SE OS CAMPOS DE CADASTROS PRODUTOS ESTÃO TODOS PREENCHIDOS
  private boolean verificaCampo() {
    List<String> lista = new ArrayList<>();    
    lista.add(txt_estoque.getText());
    lista.add(txt_categoria.getText());
    lista.add(txt_codBarra.getText());
    lista.add(txt_descricao.getText());
    lista.add(txt_valorCusto.getText());
    lista.add(txt_valorVenda.getText());  

    for (String item : lista) {
      if (item == null || item =="") {
        return false;
      }
    }
    return true;
  }
// LIMPA OS CAMPOS APOS A INSERÇÃO DO PRODUTO NA BANCO DE DADOS
  private void limpaCampo() {
    txt_categoria.clear();
    txt_estoque.clear();
    txt_valorVenda.clear();
    txt_valorCusto.clear();
    txt_descricao.clear();
    txt_codBarra.clear();
  }
// REMOVE PRODUTO DO BANCO DE DADOS
  private void remover(){
    Produto produto;
    produto = tabela_produtos.getSelectionModel().getSelectedItem();   
    if (produto == null) {
      msg.mensagemDeErro("Selecione um produto!");
    } else {          
      produtoDAO.remover(produto);
      carregarTabelaProdutos();
    }
  } 

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    carregarTabelaProdutos();
  }
}
