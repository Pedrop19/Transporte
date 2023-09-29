import java.util.LinkedList;
import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ent = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        LinkedList <Vehiculo> vehiculos = new LinkedList<Vehiculo>();
        LinkedList <Paquete> paquetes = new LinkedList<Paquete>();
        LinkedList <Ruta> rutas = new LinkedList<Ruta>();
        LinkedList <TrasporteCarga> trasporteCargas = new LinkedList<TrasporteCarga>();
        LinkedList <TrasportePersonas> trasportePersonas = new LinkedList<TrasportePersonas>();

        Paquete paquete = new Paquete(0, 10);
        Paquete paquete2 = new Paquete(1, 20);
        Paquete paquete3 = new Paquete(2, 5);
        Paquete paquete4 = new Paquete(3, 1);

        TrasporteCarga camion = new TrasporteCarga("111X", 1, 10, Tipo.CAMION);
        TrasporteCarga furgon = new TrasporteCarga("222X", 2, 100, Tipo.FURGON);
        camion.addPaquete(paquete);
        furgon.addPaquete(paquete2);
        camion.addPaquete(paquete3);
        furgon.addPaquete(paquete4);
        
        TrasportePersonas autobus = new TrasportePersonas("333X", 3, 10, Tipo.AUTOBUS, 0);
        TrasportePersonas taxi = new TrasportePersonas("444X", 4, 20, Tipo.TAXI, 0);


        Ruta ruta = new Ruta(1, 5);
        Ruta ruta2 = new Ruta(2, 20);

        vehiculos.add(camion);
        vehiculos.add(furgon);
        vehiculos.add(autobus);
        vehiculos.add(taxi);

        for (Vehiculo v : vehiculos) {
            System.out.println(v.costeRuta(ruta));
        }

        int opc = 0;

        do {
            System.out.println("-- APP TRANSPORTE --");
            System.out.println("Eliga la operación [1-7]: ");
            System.out.println("1. Crear vehiculo");
            System.out.println("2. Crear paquete");
            System.out.println("3. Añadir paquete a vehiculo de carga");
            System.out.println("4. Añadir personas a transporte");
            System.out.println("5. Crear ruta");
            System.out.println("6. Calcular precio de ruta");
            System.out.println("7. Salir");
            opc = ent.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("--REGISTRAR VEHICULO--");
                    System.out.print("Introduce la matricula del vehiculo: ");
                    String matricula = str.nextLine();
                    System.out.print("Introduce el id del conductor: ");
                    int id_conductor = ent.nextInt();
                    System.out.print("Introduce la carga maxima: ");
                    int carga_maxima = ent.nextInt();
                    System.out.println("¿Que tipo de vehiculo es? [1-4]");
                    System.out.println("1.Taxi 2.Autobus 3.Furgoneta 4.Camion");
                    int opc1 = ent.nextInt();
                    Tipo tipo = null;
                    switch(opc1){
                        case 1:
                            tipo = Tipo.TAXI;
                            trasportePersonas.add(new TrasportePersonas(matricula, id_conductor, carga_maxima, tipo, 0));
                            vehiculos.add(new TrasportePersonas(matricula, id_conductor, carga_maxima, tipo, 0));
                            System.out.println("Taxi creado correctamente");
                            break;
                        case 2:
                            tipo = Tipo.AUTOBUS;
                            trasportePersonas.add(new TrasportePersonas(matricula, id_conductor, carga_maxima, tipo, 0));
                            vehiculos.add(new TrasportePersonas(matricula, id_conductor, carga_maxima, tipo, 0));
                            System.out.println("Autobus creado correctamente");
                            break;
                        case 3:
                            tipo = Tipo.FURGON;
                            trasporteCargas.add(new TrasporteCarga(matricula, id_conductor, carga_maxima, tipo));
                            vehiculos.add(new TrasporteCarga(matricula, id_conductor, carga_maxima, tipo));
                            System.out.println("Furgon creado correctamente");
                            break;
                        case 4:
                            tipo = Tipo.CAMION;
                            trasporteCargas.add(new TrasporteCarga(matricula, id_conductor, carga_maxima, tipo));
                            vehiculos.add(new TrasporteCarga(matricula, id_conductor, carga_maxima, tipo));
                            System.out.println("Camion creado correctamente");
                            break;
                        default:
                            System.out.println("Error. Opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("-- REGISTRAR PAQUETE --");
                    System.out.print("Introduce el id: ");
                    int id_paquete = ent.nextInt();
                    System.out.print("Introduce el peso: ");
                    double peso = ent.nextDouble();
                    paquetes.add(new Paquete(id_paquete, peso));
                    System.out.println("Paquete registrado correctamente");
                    break;
                case 3:
                    System.out.println("-- AÑADIENDO PAQUETE --");
                    System.out.println("Mostrando transportes de carga: ");
                    for (TrasporteCarga t : trasporteCargas) {
                            System.out.println(t.toString());
                    }
                    System.out.print("Introduce la matricula del vehiculo al que quieres añadir un paquete: ");
                    String matricula1 = str.nextLine();
                    System.out.println("Mostrando paquetes: ");
                    for (Paquete p : paquetes) {
                        System.out.println(p.toString());
                    }
                    System.out.print("Introduce el id del paquete que quieres añadir: ");
                    int id_paquete1 = ent.nextInt();
                    for (int i = 0; i < trasporteCargas.size(); i++) {
                        if(trasporteCargas.get(i).getMatricula().equals(matricula1)){
                            for (int j = 0; j < paquetes.size(); j++) {
                                if(paquetes.get(j).getId() == id_paquete1)
                                    trasporteCargas.get(i).addPaquete(paquetes.get(j));
                            }
                        }
                    }
                    System.out.println("Paquete añadido correctamente");
                    break;
                case 4:
                    System.out.println("-- AÑADIENDO PERSONAS --");
                    System.out.println("Mostrando transportes de personas: ");
                    for (TrasportePersonas tp : trasportePersonas) {
                        System.out.println(tp.toString());
                    }
                    System.out.print("Introduce la matricula del vehiculo al que quieres añadir pasajeros: ");
                    String matricula2 = str.nextLine();
                    System.out.print("Introduce la cantidad de personas que quieres añadir: ");
                    int n_personas = ent.nextInt();
                    for (int i = 0; i < trasportePersonas.size(); i++) {
                        if(trasportePersonas.get(i).getMatricula().equals(matricula2))
                            trasportePersonas.get(i).setN_personas(trasportePersonas.get(i).getPasajeros() + n_personas);
                    }
                    System.out.println("Persona/s añadida correctamente");
                    break;
                case 5:
                    System.out.println("-- CREANDO RUTA --");
                    System.out.print("Introduce el id: ");
                    int id_ruta = ent.nextInt();
                    System.out.print("Introduce el numero de localidades: ");
                    int n_localidades = ent.nextInt();
                    rutas.add(new Ruta(id_ruta, n_localidades));
                    System.out.println("Ruta creada correctamente");
                    break;
                case 6:
                    System.out.println("-- CALCULAR PRECIO DE RUTA --");
                    System.out.println("Mostrando todos los vehiculos: ");
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v.toString());
                    }
                    System.out.print("Introduce la matricula del vehiculo: ");
                    String matricula3 = str.nextLine();
                    System.out.println("Mostrando rutas: ");
                    for (Ruta r : rutas) {
                        System.out.println(r.toString());
                    }
                    System.out.print("Introduce el id de la ruta: ");
                    int id_ruta1 = ent.nextInt();
                    for (int i = 0; i < vehiculos.size(); i++) {
                        if(vehiculos.get(i).getMatricula().equals(matricula3)){
                            for (int j = 0; j < rutas.size(); j++) {
                                if(rutas.get(j).getId() == id_ruta1)
                                    System.out.println(vehiculos.get(i).costeRuta(rutas.get(j)));
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("ERROR: Opcion no disponible");
                    break;
            }
        } while (opc != 7);
    }
}
