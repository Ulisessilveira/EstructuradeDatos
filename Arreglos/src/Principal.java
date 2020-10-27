public class Principal {
    public static void main(String[]args){
        int[] arregloA={2,3,8,7,1};
        int mayor=0;
        for (int dato:arregloA) {
            int res = (dato>mayor) ? mayor=dato : mayor;
            }
        System.out.println("El número máximo es " + mayor);
        }
    }
