package ifsp.projeto.poo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ifsp.projeto.poo.model.Administrador;
import ifsp.projeto.poo.model.Funcionario;
import ifsp.projeto.poo.model.dao.UsuarioDAO;
import ifsp.projeto.poo.utils.Metodos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UsuarioController implements Initializable {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Metodos msg = new Metodos();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn_alterar;

    @FXML
    private Button btn_excluir;

    @FXML
    private Button btn_inserir;

    @FXML
    private TableColumn<?, String> tableColumn_usuarioCpfCnpj;

    @FXML
    private TableColumn<?, ?> tableColumn_UsuarioNome;

    @FXML
    private TableView<?> tabela_usuarios;

    @FXML
    private TextField txt_documento;

    @FXML
    private TextField txt_login;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_senha;

    @FXML
    private TextField txt_telefone;

    @FXML
    void btn_alterarUsuario(ActionEvent event) {
    }

    @FXML
    void btn_excluirUsuario(ActionEvent event) {
    }

    @FXML
    void btn_inserirUsuario(ActionEvent event) {
        Administrador administrador = null;
        Funcionario funcionario = null;
        if (txt_login.getText().contains("@adm")) {
            administrador = new Administrador(
                    txt_nome.getText(),
                    txt_login.getText(),
                    txt_senha.getText(),
                    txt_telefone.getText(),
                    txt_documento.getText()
            );
            administrador.cadastarUsuario(administrador);
            msg.mensagemDeSucesso("Usuário Cadastrado com sucesso!");
            limpaCampo();
        } 
        else {
            funcionario = new Funcionario(
                    txt_nome.getText(),
                    txt_login.getText(),
                    txt_senha.getText(),
                    txt_telefone.getText(),
                    txt_documento.getText()
            );
            funcionario.cadastarUsuario(funcionario);
            msg.mensagemDeSucesso("Usuário Cadastrado com sucesso!");
            limpaCampo();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    private void limpaCampo() {
        txt_nome.clear();
        txt_login.clear();
        txt_senha.clear();
        txt_telefone.clear();
        txt_documento.clear();
    }
    

//   public void carregaTabelaUsuario(){
//       if(txt){
//           tableColumn_UsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//           tableColumn_usuarioCpfCnpj.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//       }
//   }
}
