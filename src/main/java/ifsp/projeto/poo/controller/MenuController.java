package ifsp.projeto.poo.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable{

    private final String path = "/ifsp/projeto/poo/view/";

    @FXML
    private AnchorPane anchorPane;

   
    
    @FXML
    private MenuItem menuItem_CadastroUsuario;

    @FXML
    private MenuItem menuItem_cadastroCategoria;

    @FXML
    private MenuItem menuItem_cadastroCliente;

    @FXML
    private MenuItem menuItem_cadastroFornecedores;

    @FXML
    private MenuItem menuItem_cadastroProdutos;

    @FXML
    private MenuItem menuItem_graficosMensal;

    @FXML
    private MenuItem menuItem_processosVendas;

    @FXML
    private MenuItem menuItem_relatoriosValorTotalEstoque;

    @FXML
    private MenuItem menuItem_relatoriosValorTotalPorCategoria;

    @FXML
    void abriTelaDeVendas(ActionEvent event) throws IOException{
        abriTela("Venda.fxml");
    }

    @FXML
    void abriTelaCategoria(ActionEvent event) throws IOException{
    }

    @FXML
    void abriTelaFornecedores(ActionEvent event) throws IOException{
    }

    @FXML
    void abriTelaUsuario(ActionEvent event) throws IOException {
        abriTela("Usuario.fxml");
    }

    @FXML
    void abriTelaProduto(ActionEvent event) throws IOException {          
        abriTela("Produto.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {        
    }

    private void abriTela(String nomePagina) throws IOException{
        AnchorPane pane =(AnchorPane)
        FXMLLoader.load(getClass().getResource(path.concat(nomePagina)));
        anchorPane.getChildren().setAll(pane);
    }


}
