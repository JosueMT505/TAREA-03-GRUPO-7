package composite;

import java.util.*;
import observer.FuncionEvento;

public class MapaAsientos {
    private List<SeccionTeatro> secciones;
    private FuncionEvento funcion;

    public MapaAsientos(FuncionEvento funcion) {
        this.funcion = funcion;
        this.secciones = new ArrayList<>();
        inicializarSecciones();
    }

    private void inicializarSecciones() {
        SeccionTeatro platea = new SeccionTeatro("Platea", 50.0);
        SeccionTeatro balcon = new SeccionTeatro("Balcón", 30.0);
        SeccionTeatro vip = new SeccionTeatro("VIP", 80.0);

        agregarAsientosSeccion(platea, "A", 10, 50.0);
        agregarAsientosSeccion(balcon, "B", 15, 30.0);
        agregarAsientosSeccion(vip, "V", 5, 80.0);

        secciones.add(platea);
        secciones.add(balcon);
        secciones.add(vip);
    }

    private void agregarAsientosSeccion(SeccionTeatro seccion, String fila, int cantidad, double precio) {
        for (int i = 1; i <= cantidad; i++) {
            String id = seccion.getNombre() + "-" + fila + "-" + i;
            AsientoIndividual asiento = new AsientoIndividual(id, seccion.getNombre(), fila, i, precio);
            seccion.agregarAsiento(asiento);
        }
    }

    public String visualizarMapa() {
        StringBuilder mapa = new StringBuilder();
        mapa.append("Mapa de Asientos para: ").append(funcion.getEvento().getTitulo()).append("\n");

        for (SeccionTeatro seccion : secciones) {
            mapa.append("\n").append(seccion.getNombre()).append(" (").append(seccion.getPrecio()).append(" USD):\n");

            for (ComponenteAsiento asiento : seccion.getAsientos()) {
                if (asiento instanceof AsientoIndividual) {
                    AsientoIndividual ai = (AsientoIndividual) asiento;
                    char estado = ai.esDisponible() ? 'O' : 'X';
                    mapa.append("[").append(estado).append("] ");
                }
            }
        }

        return mapa.toString();
    }

    public List<ComponenteAsiento> seleccionarAsientos(List<String> ids) {
        List<ComponenteAsiento> seleccionados = new ArrayList<>();

        for (SeccionTeatro seccion : secciones) {
            for (ComponenteAsiento asiento : seccion.getAsientos()) {
                if (ids.contains(asiento.getId()) && asiento.esDisponible()) {
                    seleccionados.add(asiento);
                }
            }
        }

        return seleccionados;
    }

    public int obtenerDisponibilidadSeccion(String nombreSeccion) {
        for (SeccionTeatro seccion : secciones) {
            if (seccion.getNombre().equalsIgnoreCase(nombreSeccion)) {
                return (int) (seccion.getAsientos().size() -
                        (seccion.obtenerPorcentajeOcupacion() / 100.0 * seccion.getAsientos().size()));
            }
        }
        return 0;
    }

    public List<SeccionTeatro> getSecciones() { return secciones; }
    public FuncionEvento getFuncion() { return funcion; }
}