package ifsp.projeto.poo.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ifsp.projeto.poo.model.Produto;
import ifsp.projeto.poo.model.dao.ProdutoDAO;
import ifsp.projeto.poo.utils.Metodos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VendaController implements Initializable {

  @FXML
  private TextField buscaProduto;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private BorderPane border;

  @FXML
  private Button btn_buscarProduto;

  @FXML
  private Button btn_cancelarVenda;

  @FXML
  private Button btn_finalizarVenda;

  @FXML
  private Label lbl_caixaAberto;

  @FXML
  private Label lbl_subtotalCompra;

  @FXML
  private Label lbl_totalItem;

  @FXML
  private Label lbl_troco;

  @FXML
  private Label lbl_valorUnitarioItem;

  @FXML
  private TableView<Produto> tabela_itensSelecionados;

  @FXML
  private TableColumn<Produto, String> col_codBarra;

  @FXML
  private TableColumn<Produto, String> col_descricao;

  @FXML
  private TableColumn<String, String> col_qtdProduto;

  @FXML
  private TableColumn<Produto, Double> col_subtotalItem;

  @FXML
  private TableColumn<Produto, Double> col_valorUnitario;

  @FXML
  private TextField txt_codigoDeBarra;

  @FXML
  private TextField txt_valorRecebido;

  private Produto produto;
  private ObservableList<Produto> observableListProdutos = FXCollections.observableArrayList();
  private final ProdutoDAO produtoDAO = new ProdutoDAO();
  private final Metodos msg = new Metodos();
  private final String path = "/ifsp/projeto/poo/view/";

  @FXML
  void buscaProduto(ActionEvent event) throws SQLException {
    produtosPorCodigo();
  }

  @FXML
  void cancelaCompra(ActionEvent event) {}

  @FXML
  void finalizaCompra(ActionEvent event) throws IOException {
    abriTela("Pagamento.fxml");
  }

  @Override
  public void initialize(URL url, ResourceBundle rs) {}

  public void produtosPorCodigo() throws SQLException {
    try {      
      String codigoBarra = txt_codigoDeBarra.getText();

      if(codigoBarra ==""){
        msg.mensagemDeErro("Insira um código de barra!");
        txt_codigoDeBarra.clear();
        return;
      } 

      produto = produtoDAO.buscarPorCodBarra(codigoBarra);
      if(produto.getCodigoBarra() == null){
        msg.mensagemDeErro("Produto não encontrado!");
        txt_codigoDeBarra.clear();
        return;
      }
      col_codBarra.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
      col_descricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
      col_valorUnitario.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
      // col_qtdProduto.getCellValueFactory().getClass().getResource(codigoBarra);

      observableListProdutos.add(produto);
      tabela_itensSelecionados.setItems(observableListProdutos);
      txt_codigoDeBarra.clear();
    } catch (Exception ex) {
      msg.mensagemDeErro(  ex + "Produto não existe!");
    }
  }


  // private void calcularPrecoTotal(String precoVenda)
  // {
  //     txb_preco. = precoVenda;
  //     //Multiplicando preço  por quantidade
  //     decimal calculoValorTotal = decimal.Parse(txb_preco.Text) * int.Parse(txb_quantidade.Text);
  //     valorTotal += calculoValorTotal;
  //     // Setando textBox  com o valor  total calculado
  //     txb_valorTotal.Text = valorTotal.ToString();
  //     // Calculando valor total de produtos
  //     qtdItens += int.Parse(txb_quantidade.Text);
  //     //Setando textBox com a quantidade  total  calculada
  //     txb_qtdTotalItens.Text = qtdItens.ToString();
  // }

  private void abriTela(String nomePagina) throws IOException {
    AnchorPane pane = (AnchorPane) FXMLLoader.load(
      getClass().getResource(path.concat(nomePagina))
    );
    anchorPane.getChildren().setAll(pane);
  }
}
