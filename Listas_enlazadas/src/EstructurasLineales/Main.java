package EstructurasLineales;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        ListaEnlazada listaEnlazada=new ListaEnlazada();
        listaEnlazada.insertar(new Cancion("navidad","./navidad.mp3", 60));
        listaEnlazada.insertar(new Cancion("navidad2","./navidad.mp3", 60));
        listaEnlazada.insertar(new Cancion("navidad3","./navidad.mp3", 60));
        listaEnlazada.mostrarElemntos();
        LinkedList<Cancion> listaJava = new LinkedList<>();
        listaJava.add(new Cancion("Cafe", "./cafeina.mp3", 5));
        listaJava.add(new Cancion("Cafe2", "./cafeina.mp3", 5));
        listaJava.add(new Cancion("Cafe3", "./cafeina.mp3", 5));
        for (int x=0; x<listaJava.size(); x++){
            Cancion c=listaJava.get(x);
            System.out.print(c.getNombre() +" ");
            System.out.print(c.getDuracion()+ " ");
            System.out.println(c.getRuta() );
        }

    }
}
