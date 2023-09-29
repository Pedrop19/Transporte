public class Paquete {

    private int id;
    private double peso;
    
    public Paquete(int id, double peso) {
        this.id = id;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paquete [id=" + id + ", peso=" + peso + "]";
    }

}
