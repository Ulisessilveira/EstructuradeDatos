package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class Controller {
    @FXML TextField txtUsuario;
    @FXML PasswordField txtContraseña;

    public void login(javafx.event.ActionEvent event) {
        ingresar();
    }
    public void enter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            ingresar();
        }
    }
    public void ingresar() {
        String u=txtUsuario.getText();
        String c=txtContraseña.getText();
        if(u.equals("Ulises") && c.equals("123")){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Cobro.fxml"));
                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
                //Main.stage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("DATOS INVALIDOS");
            alert.show();
        }
    }
}
