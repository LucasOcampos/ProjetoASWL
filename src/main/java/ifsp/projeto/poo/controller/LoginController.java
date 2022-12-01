package ifsp.projeto.poo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifsp.projeto.poo.model.Administrador;
import ifsp.projeto.poo.model.Funcionario;
import ifsp.projeto.poo.model.Usuario;
import ifsp.projeto.poo.utils.Metodos;

public class LoginController implements Initializable {
   
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn_novoCadastro;

    @FXML
    private Label lbl_status;

    @FXML
    private Button btn_okLogin;

    @FXML
    private Button btn_sairLogin;

    @FXML
    private TextField txt_login;

    @FXML
    private TextField txt_senha;

    @FXML
    private Label lbl_senhaInvalida;

    @FXML
    private AnchorPane tela_login;
    MenuController menuController = new MenuController();
    Metodos msg = new Metodos(); 
    String login;
    String senha;
    
    Usuario usuario;

    @FXML
    void novoCadastro(ActionEvent event) {
    }

    @FXML
    void efetuarLogin(ActionEvent event) throws IOException {   
        // APOS EFETUAR LOGIN, A TELA DE MENU PRINCIPAL SE ABRE
        login = txt_login.getText().toLowerCase(); 
        senha = txt_senha.getText();  
        try {  
            if (login.contains("@adm")) {
                usuario = new Administrador(login, senha);
                
            } else {
                usuario = new Funcionario(login, senha);
            }
                         
            if (usuario.login(login, senha)){
                Stage stage = (Stage) btn_okLogin.getScene().getWindow();
                FXMLLoader root = new FXMLLoader(LoginController.class.getResource("/ifsp/projeto/poo/view/Menu.fxml"));
                Scene scene = new Scene(root.load());
                stage.setScene(scene);
                stage.setTitle("Tela Inicial");
                stage.show();
            }  
            else{
                msg.mensagemDeErro("Usuário ou Senha Inválidos");
            }         
        } catch (Exception ex) {
            Logger.getLogger(FXMLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    @FXML
    void sairLogin(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }




}
