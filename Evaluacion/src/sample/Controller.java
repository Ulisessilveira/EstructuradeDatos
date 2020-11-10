package sample;


import Pez.Pez;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {
    @FXML ComboBox comboBox;
    @FXML TextField txtArreglo;
    @FXML ListView lista;
    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Trucha", "Carpa", "Lucioperca", "Bagre");
        comboBox.setItems(list);
    }


    Pez[] arreglo = new Pez[5];
    int cont=0;

    public void insertar(ActionEvent event){
        if(cont<5) {
            try {
                String datoT = comboBox.getValue().toString();
                int datoN = Integer.parseInt(txtArreglo.getText());
                if(datoN>0 || datoT== null){
                    arreglo[cont] = new Pez(datoT,datoN);
                    cont++;
                    txtArreglo.setText("");
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);//Error de un numero negativo o comboBox vacio
                    alert.setTitle("Error");
                    alert.setContentText("Valor no valido");
                    alert.show();
                }

            }catch (Exception error){
                Alert alert = new Alert(Alert.AlertType.ERROR);//Error de un valor no valido
                alert.setTitle("Error");
                alert.setContentText("Inserte un valor valido");
                alert.show();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//Matriz llena
            alert.setTitle("Aviso");
            alert.setContentText("Arreglo lleno");
            alert.show();
        }
    }

    //Boton procesar
    public void procesar(ActionEvent event){
        for (int i=0;i<cont;i++){
            lista.getItems().add("Pescado " + arreglo[i].getTipo_pez() + " nacen " + arreglo[i].getPor_nacimiento() + " por crias y " + arreglo[i].peces_al_anio() +" anualmente");
        }
    }


}
