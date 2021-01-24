package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructuras.Busqueda;
import sample.Estructuras.Inventario;
import sample.Estructuras.Ordenamiento;

import java.io.IOException;

public class ControllerInv {
    @FXML TableView tabla;
    @FXML Label nombreUsuario;
    @FXML TextField numeroBus;
    TableColumn columnCodigo = new TableColumn("Código");
    TableColumn columnMarca = new TableColumn("Marca");
    TableColumn columnTipo = new TableColumn("Tipo");
    TableColumn columnTamaño = new TableColumn("Tamaño");
    TableColumn columnPrecio = new TableColumn("Precio $");
    TableColumn columnStoke = new TableColumn("Stock");
    ObservableList<Inventario> listaInventarios = FXCollections.observableArrayList();
    Inventario[] arreglo = new Inventario[6];
    @FXML protected void  initialize(){
        nombreUsuario.setText(Main.nombreUsuario);
        arreglo[0] = new Inventario(101,"Moyu", "Cubico", "2x2",110,56);
        arreglo[1] =new Inventario(102,"Gan", "Cubico", "3x3",1190,6);
        arreglo[2] =new Inventario(103,"QiYi", "Megaminx", "4x4",526,1);
        arreglo[3] =new Inventario(104,"Z-cube", "Pyraminx", "5x5",130,31);
        arreglo[4] =new Inventario(105,"YJ Yongjun", "Skewb", "6x6",1160,10);
        arreglo[5] =new Inventario(106,"Rubik's", "Cubico", "3x3",240,60);
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("codigo"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<Inventario,String>("marca"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<Inventario,String>("tipo"));
        columnTamaño.setCellValueFactory(new PropertyValueFactory<Inventario,String>("tamaño"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("precio"));
        columnStoke.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("stoke"));
        tabla.getColumns().addAll(columnCodigo,columnMarca,columnTipo,columnTamaño,columnPrecio,columnStoke);
        tabla.setItems(listaInventarios);
        listaInventarios.add(arreglo[0]);
        listaInventarios.add(arreglo[1]);
        listaInventarios.add(arreglo[2]);
        listaInventarios.add(arreglo[3]);
        listaInventarios.add(arreglo[4]);
        listaInventarios.add(arreglo[5]);
    }
    public void regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cobro.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void burbuja(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Inventario[] ordenado = ordenar.burbujaPrecio(arreglo);
        listaInventarios.clear();
        listaInventarios.add(ordenado[0]);
        listaInventarios.add(ordenado[1]);
        listaInventarios.add(ordenado[2]);
        listaInventarios.add(ordenado[3]);
        listaInventarios.add(ordenado[4]);
        listaInventarios.add(ordenado[5]);
    }
    public void ShellSort(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Inventario[] ordenado = ordenar.ShellSortStoke(arreglo);
        listaInventarios.clear();
        listaInventarios.add(ordenado[0]);
        listaInventarios.add(ordenado[1]);
        listaInventarios.add(ordenado[2]);
        listaInventarios.add(ordenado[3]);
        listaInventarios.add(ordenado[4]);
        listaInventarios.add(ordenado[5]);
    }
    public void binario(ActionEvent event){
        Ordenamiento ordenar = new Ordenamiento();
        Busqueda busqueda = new Busqueda();
        int codB;
        try{
             codB = Integer.parseInt(numeroBus.getText());
            if(codB>=101 && codB<=106){
                codB = Integer.parseInt(numeroBus.getText());
                Inventario[] ordenado = ordenar.burbujaCodigo(arreglo);
                listaInventarios.clear();
                listaInventarios.add(ordenado[0]);
                listaInventarios.add(ordenado[1]);
                listaInventarios.add(ordenado[2]);
                listaInventarios.add(ordenado[3]);
                listaInventarios.add(ordenado[4]);
                listaInventarios.add(ordenado[5]);
                int buscado = busqueda.binario(arreglo, codB);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RUBIK'S WORLD");
                alert.setContentText("El código buscado esta en la posicion " + buscado + " de la tabla");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RUBIK'S WORLD");
                alert.setContentText("El código introducido no se encuentra en la tabla");
                alert.show();
            }
        } catch (NumberFormatException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("No se ha introducido ningún código, favor de ingresar uno");
            alert.show();
        }
    }
    public void cerrarSesion (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
