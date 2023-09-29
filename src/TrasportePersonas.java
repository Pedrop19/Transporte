import java.util.LinkedList;

public class TrasportePersonas extends Vehiculo {

    private int pasajeros;

    public TrasportePersonas(String matricula, int id_conductor, int carga_maxima, Tipo tipo, int pasajeros) {
        super(matricula, id_conductor, carga_maxima, tipo);
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public int cantidadPersonas(){
        int cantidadPersonas = 0;
        cantidadPersonas += pasajeros;
        return cantidadPersonas;
    }

    public void setN_personas(int pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    @Override
    public String toString() {
        return getTipo() + "[ " + super.toString() + ", n_personas=" + cantidadPersonas() + "]";
    }

    @Override
    public double costeRuta(Ruta r) {
            if (getTipo() == Tipo.AUTOBUS)
                return (1.25 * cantidadPersonas()) + (2 * r.getN_localidades());
            else if (getTipo() == Tipo.TAXI)
                return (2 * cantidadPersonas()) + (3 * r.getN_localidades());
        return 0;
    }

}
