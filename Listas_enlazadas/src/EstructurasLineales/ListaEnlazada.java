package EstructurasLineales;

public class ListaEnlazada {
    Nodo inicio;
    public ListaEnlazada(){
        inicio=null;
    }
    public void insertar(Cancion cancion){
        Nodo nuevoNodo = new Nodo(cancion);
        if(this.inicio == null){
            this.inicio=nuevoNodo;
        }else {
            Nodo nodoActual = inicio.getSiguiente();
            if (nodoActual == null){
                inicio.setSiguiente(nuevoNodo);
            }else {
                while (nodoActual.getSiguiente() != null){
                    nodoActual = nodoActual.getSiguiente();
                }
                nodoActual.setSiguiente(nuevoNodo);
            }
        }
    }
    public void mostrarElemntos(){
        Nodo nodoActual = inicio;
        while (nodoActual != null){
            System.out.print(nodoActual.getCancion().getNombre()+" ");
            System.out.print(nodoActual.getCancion().getDuracion()+" ");
            System.out.println(nodoActual.getCancion().getRuta()+" ");
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
