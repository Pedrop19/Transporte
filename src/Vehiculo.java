public abstract class Vehiculo {

    private String matricula;
    private int id_conductor;
    private int carga_maxima;
    private Tipo tipo;
    
    public Vehiculo(String matricula, int id_conductor, int carga_maxima, Tipo tipo) {
        this.matricula = matricula;
        this.id_conductor = id_conductor;
        this.carga_maxima = carga_maxima;
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public int getCarga_maxima() {
        return carga_maxima;
    }

    public void setCarga_maxima(int carga_maxima) {
        this.carga_maxima = carga_maxima;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public abstract double costeRuta(Ruta r);

    @Override
    public String toString() {
        return "matricula=" + matricula + ", id_conductor=" + id_conductor + ", carga_maxima=" + carga_maxima
                + ", tipo:" + tipo + "]";
    }

}
