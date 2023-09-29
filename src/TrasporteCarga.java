import java.util.LinkedList;

public class TrasporteCarga extends Vehiculo {

    private LinkedList<Paquete> paquetes;

    public TrasporteCarga(String matricula, int id_conductor, int carga_maxima, Tipo tipo) {
        super(matricula, id_conductor, carga_maxima, tipo);
        this.paquetes = new LinkedList<>();
    }

    public void addPaquete(Paquete p) {
        if (pesoTotal() < getCarga_maxima())
            paquetes.add(p);
        else
            System.out.println("Carga maxima alcanzada.");
    }

    public void removePaquete(Paquete p) {
        paquetes.remove(p);
    }

    @Override
    public String toString() {
        return getTipo() + "[ " + super.toString() + "paquetes=" + paquetes + "]";
    }

    public double pesoTotal() {
        double pesoTotal = 0;
        for (Paquete p : paquetes)
            pesoTotal += p.getPeso();
        return pesoTotal;
    }

    @Override
    public double costeRuta(Ruta r) {
        for (Paquete p : paquetes) {
            if (getTipo() == Tipo.FURGON)
                return (2.5 * pesoTotal()) + (3 * r.getN_localidades());
            else if (getTipo() == Tipo.CAMION)
                return (1.75 * pesoTotal()) + (3 * r.getN_localidades());
        }
        return 0;
    }

}
