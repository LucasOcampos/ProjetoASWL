package ifsp.projeto.poo.controller;


import java.net.URL;
import java.util.ResourceBundle;

import ifsp.projeto.poo.utils.Metodos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class PagamentoController implements Initializable{  
    Metodos msg = new Metodos();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn_okPagamento;

    @FXML
    private CheckBox check_credito;

    @FXML
    private CheckBox check_debito;

    @FXML
    private CheckBox check_dinheiro;

    @FXML
    void selecionaFormaPagamento(ActionEvent event) {

        if(check_dinheiro.isSelected()){
            msg.mensagemDeConfirmacao("dinheiro");
        }
    }    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
    
}
