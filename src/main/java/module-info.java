module ifsp.projeto.lp3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ifsp.projeto.poo to javafx.fxml;   
    exports ifsp.projeto.poo;
    exports ifsp.projeto.poo.controller;
    exports ifsp.projeto.poo.model;
    opens ifsp.projeto.poo.controller to javafx.fxml;
    
}
