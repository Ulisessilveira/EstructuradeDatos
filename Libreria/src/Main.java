import conversiones.Conversion;

public class Main {
    public static void main(String[] args){
        Conversion conversion = new Conversion();
        String res = conversion.binarios(2);
        System.out.println(res);
        res = conversion.hex(1);
        System.out.println(res);
    }
}
