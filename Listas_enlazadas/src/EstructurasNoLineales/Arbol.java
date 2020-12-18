package EstructurasNoLineales;

public class Arbol {
    NodoArbol iniciar;
    public Arbol(){
        this.iniciar=null;
    }
    public void insertar(int valor){
        if (this.iniciar == null){
            this.iniciar = new NodoArbol(valor);
        }else {
            this.iniciar.insertar(valor);
        }
    }
    public void dispararPreorden(){
        this.preorden(this.iniciar);
    }
    public void preorden(NodoArbol nodo){
        if (nodo == null){
            return; //detener recursividad casa base
        }else {
            System.out.print(nodo.getValor() + ", ");
            preorden(nodo.getNodoIzq());
            preorden(nodo.getNodoDerecho());
        }
    }
    public void dispararInorden(){
        this.inorden(this.iniciar);
    }
    public  void inorden(NodoArbol nodo){
        if (nodo == null){
            return; //detener recursividad casa base
        }else {
            inorden(nodo.getNodoIzq());
            System.out.print(nodo.getValor() + ", ");
            inorden(nodo.getNodoDerecho());
        }
    }
    public void dispararPostorden(){
        this.postorden(this.iniciar);
    }
    public  void postorden(NodoArbol nodo){
        if (nodo == null){
            return; //detener recursividad casa base
        }else {
            postorden(nodo.getNodoIzq());
            postorden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor() + ", ");
        }
    }
}
