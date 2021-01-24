package sample.Estructuras;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Inventario {
    SimpleIntegerProperty codigo;
    SimpleStringProperty marca;
    SimpleStringProperty tipo;
    SimpleStringProperty tamaño;
    SimpleIntegerProperty precio;
    SimpleIntegerProperty stoke;

    public Inventario(int codigo, String marca, String tipo, String tamaño, int precio, int stoke) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.marca = new SimpleStringProperty(marca);
        this.tipo = new SimpleStringProperty(tipo);
        this.tamaño = new SimpleStringProperty(tamaño);
        this.precio = new SimpleIntegerProperty(precio);
        this.stoke = new SimpleIntegerProperty(stoke);
    }

    public int getCodigo() {
        return codigo.get();
    }

    public SimpleIntegerProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public String getMarca() {
        return marca.get();
    }

    public SimpleStringProperty marcaProperty() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public String getTamaño() {
        return tamaño.get();
    }

    public SimpleStringProperty tamañoProperty() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño.set(tamaño);
    }

    public int getPrecio() {
        return precio.get();
    }

    public SimpleIntegerProperty precioProperty() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio.set(precio);
    }

    public int getStoke() {
        return stoke.get();
    }

    public SimpleIntegerProperty stokeProperty() {
        return stoke;
    }

    public void setStoke(int stoke) {
        this.stoke.set(stoke);
    }
}