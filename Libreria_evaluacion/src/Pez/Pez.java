package Pez;

public class Pez {
    String tipo_pez;
    int por_nacimiento;

    public Pez(String tipo_pez, int por_nacimiento) {
        this.tipo_pez = tipo_pez;
        this.por_nacimiento = por_nacimiento;
    }

    public String getTipo_pez() {
        return tipo_pez;
    }

    public void setTipo_pez(String tipo_pez) {
        this.tipo_pez = tipo_pez;
    }

    public int getPor_nacimiento() {
        return por_nacimiento;
    }

    public void setPor_nacimiento(int por_nacimiento) {
        this.por_nacimiento = por_nacimiento;
    }

    public double peces_al_anio() {
        double nacidos = this.por_nacimiento;
        double muridos=0, esta_vivo=0;
        muridos = nacidos * 0.1;
        esta_vivo = nacidos-muridos;
        nacidos = esta_vivo;
        return nacidos;

    }
}
