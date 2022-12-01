package ifsp.projeto.poo.utils;

import javafx.scene.control.Alert;
public class Metodos {
    
        /// MENSAGEM DE ERRO
      public void mensagemDeErro(String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
      }

      /// MENSAGEM DE SUCESSO
      public void mensagemDeSucesso(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
      }
      /// MENSAGEM DE CONFIRMAÇÃO 

      public void mensagemDeConfirmacao(String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(msg);
        alert.show();
      }

    }