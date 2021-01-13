package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructuras.ItemPedido;
import sample.Estructuras.Pedido;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControllerCobro {
    @FXML ComboBox comboTipo, comboTamaño, comboMarca;
    @FXML TextField txtCantidad, txtNombre;
    @FXML Label nombrePedido, nombreClinte;
    @FXML TableView tabla;
    LinkedList<String> listaTipo = new LinkedList<>();
    LinkedList<String> listaTamaño = new LinkedList<>();
    LinkedList<String> listaMarca = new LinkedList<>();
    TableColumn columnTipo = new TableColumn("Tipo");
    TableColumn columnTamaño = new TableColumn("Tamaño");
    TableColumn columnCatidad = new TableColumn("Cantidad");
    TableColumn columnMarca = new TableColumn("Marca");
    ObservableList<Pedido> listPedidos = FXCollections.observableArrayList();
    Queue<ItemPedido> cola=new LinkedList<>();
    Stack<ItemPedido> pila = new Stack<>();
    @FXML protected void  initialize(){
        columnTipo.setCellValueFactory(new PropertyValueFactory<Pedido,String>("tipo"));
        columnTamaño.setCellValueFactory(new PropertyValueFactory<Pedido,String>("tamaño"));
        columnCatidad.setCellValueFactory(new PropertyValueFactory<Pedido,String>("cantidad"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<Pedido,String>("marca"));

        tabla.getColumns().addAll(columnTipo,columnTamaño,columnCatidad,columnMarca);
        tabla.setItems(listPedidos);
        listaTipo.add("Cúbico");
        listaTipo.add("Cuboide");
        listaTipo.add("Morphix");
        listaTipo.add("Skewb");
        listaTipo.add("Pyraminx");
        listaTipo.add("Megaminx");
        listaTipo.add("Modificado");
        listaTamaño.add("2x2");
        listaTamaño.add("3x3");
        listaTamaño.add("4x4");
        listaTamaño.add("5x5");
        listaTamaño.add("6x6");
        listaMarca.add("Gan");
        listaMarca.add("Moyu");
        listaMarca.add("QiYi");
        listaMarca.add("Z-cube");
        listaMarca.add("YJ Yongjun");
        listaMarca.add("Rubik's");
        for (int i=0; i<listaTipo.size(); i++) comboTipo.getItems().add(listaTipo.get(i));
        for (int i=0; i<listaTamaño.size(); i++) comboTamaño.getItems().add(listaTamaño.get(i));
        for (int i=0; i<listaMarca.size(); i++) comboMarca.getItems().add(listaMarca.get(i));
    }
    public void insertarPedido(ActionEvent event){
        try {
            String ta=comboTipo.getSelectionModel().getSelectedItem().toString();
            String ti=comboTamaño.getSelectionModel().getSelectedItem().toString();
            String c=txtCantidad.getText();
            String m=comboMarca.getSelectionModel().getSelectedItem().toString();
            if(c.equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("RUBIK'S WORLD");
                alert.setContentText("INSERTE DATOS VALIDOS");
                alert.show();
            }else {
                listPedidos.add(new Pedido(ta, ti, c, m));
                tabla.setDisable(false);
                txtCantidad.setText("");
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("INSERTE DATOS VALIDOS");
            alert.show();
        }
    }
    public void guardarPedido(ActionEvent event){
        String n=txtNombre.getText();
        if (n.equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("INSERTE NOMBRE");
            alert.show();
        }else if (tabla.isDisable()==true){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("NO SE ENCUENTRAN DATOS EN LA TABLA");
            alert.show();
        }else {
            String[][] items = new String[listPedidos.size()][4];
            for (int i=0; i<items.length; i++){
                items[i][0]=listPedidos.get(i).getTipo();
                items[i][1]=listPedidos.get(i).getTamaño();
                items[i][2]=listPedidos.get(i).getCantidad();
                items[i][3]=listPedidos.get(i).getMarca();
            }
            ItemPedido pedido = new ItemPedido(items,txtNombre.getText());
            cola.add(pedido);
            pila.add(pedido);
            listPedidos.clear();
            txtNombre.setText("");
            tabla.setDisable(true);
        }
    }
    public void finalizar(ActionEvent event){
        try {
            ItemPedido pedido = cola.poll();
            nombrePedido.setText(pedido.getNombre());
            String[][] datos = pedido.getDatos();
            listPedidos.clear();
            for (int i=0; i<datos.length; i++){
                System.out.println(datos[i][0]);
                System.out.println(datos[i][1]);
                System.out.println(datos[i][2]);
                System.out.println(datos[i][3]);
                System.out.println();
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("No se encuentran pedidos");
            alert.show();
        }
    }
    public void status(ActionEvent event){
        try {
            ItemPedido pedido = pila.pop();
            System.out.println(pedido.getNombre());
            nombreClinte.setText(pedido.getNombre());
            String[][] datos = pedido.getDatos();
            for (int i=0; i<datos.length; i++) {
                System.out.println(datos[i][0]);
                System.out.println(datos[i][1]);
                System.out.println(datos[i][2]);
                System.out.println(datos[i][3]);
                System.out.println();
                listPedidos.add(new Pedido(datos[i][0], datos[i][1], datos[i][2], datos[i][3]));
                tabla.setDisable(false);
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RUBIK'S WORLD");
            alert.setContentText("No se encuentran clientes");
            alert.show();
        }

    }
    public void limpiarTabla(ActionEvent event){
        listPedidos.clear();
    }
}
