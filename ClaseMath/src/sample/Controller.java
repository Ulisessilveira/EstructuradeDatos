package sample;

import Calculos.Calculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField txtarreglo1,txtarreglo2;
    @FXML ListView lista1, lista2;
    double[] arreglo1 = new double[5];
    double[][] arreglo2 = new double[2][4];
    int contador = 0;
    int contador2 = 0;
    int contador3 = 0;
    public void insertar1(ActionEvent event){
        if(contador < 5){
            double dato = Double.parseDouble(txtarreglo1.getText());
            arreglo1[contador] = dato;
            contador++;
            txtarreglo1.setText("");
            imprimirArreglo(arreglo1);
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Arreglo lleno");
            alert.show();
        }
    }
    public void insertar2(ActionEvent event){
        if(contador2 < 2){
            double dato = Double.parseDouble(txtarreglo2.getText());
            arreglo2[contador2][contador3] = dato;
            contador3++;
            if(contador3 == 4){
                contador3 = 0;
                contador2++;
            }
            txtarreglo2.setText("");
            imprimirArregloBidi(arreglo2);
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Arreglo lleno");
            alert.show();
        }
    }
    public void procesar1(ActionEvent event){
        Calculos calculos = new Calculos(arreglo1,arreglo2);
        double[] res = calculos.procesarCoseno();
        for(double dato:res){
            lista1.getItems().add(dato+"");
        }
    }
    public void procesar2(ActionEvent event){
        Calculos calculos = new Calculos(arreglo1,arreglo2);
        double[][] res = calculos.procesarSeno();
        for (int x=0;x<res.length;x++){
            String columna = "";
            for (int y=0; y<res[x].length; y++){
                columna = columna + res[x][y]+ ", ";
            }
            lista2.getItems().add(columna);
        }
    }
    public void imprimirArreglo(double[] arr){
        for (int x = 0; x<arr.length; x++){
            System.out.print(arr[x] + ",");
        }
        System.out.println();
    }
    public void imprimirArregloBidi(double[][] arr){
        for (int x=0;x<arr.length;x++){
            for (int y=0; y<arr[x].length; y++){
                System.out.print(arr[x][y] + ",");
            }
            System.out.println("");
        }
        System.out.println("______________________________________________");
    }
}
