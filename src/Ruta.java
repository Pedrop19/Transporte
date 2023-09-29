public class Ruta {
    
    private int id;
    private int n_localidades;
    
    public Ruta(int id, int n_localidades) {
        this.id = id;
        this.n_localidades = n_localidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_localidades() {
        return n_localidades;
    }

    public void setN_localidades(int n_localidades) {
        this.n_localidades = n_localidades;
    }

    @Override
    public String toString() {
        return "Ruta [id=" + id + ", localidades=" + n_localidades + "]";
    }

    
}
