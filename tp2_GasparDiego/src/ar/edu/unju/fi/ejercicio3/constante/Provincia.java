package ar.edu.unju.fi.ejercicio3.constante;

public enum Provincia {
    JUJUY,
    SALTA,
    TUCUMAN,
    CATAMARCA,
    LA_RIOJA,
    SANTIAGO_DEL_ESTERO;

    private int poblacion;
    private int superficie;

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) poblacion / superficie;
    }
}
