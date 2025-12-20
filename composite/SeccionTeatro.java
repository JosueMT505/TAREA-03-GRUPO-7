package composite;

import sistema.Usuario;
import java.util.*;

public class SeccionTeatro implements ComponenteAsiento {
    private String nombre;
    private int capacidadTotal;
    private List<ComponenteAsiento> asientos;
    private double precioBase;

    public SeccionTeatro(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.asientos = new ArrayList<>();
        this.capacidadTotal = 0;
    }

    @Override
    public boolean reservar(Usuario usuario) {
        System.out.println("No se puede reservar una sección completa");
        return false;
    }

    @Override
    public void liberar() {
        for (ComponenteAsiento asiento : asientos) {
            asiento.liberar();
        }
    }

    @Override
    public boolean esDisponible() {

        for (ComponenteAsiento asiento : asientos) {
            if (asiento.esDisponible()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public String getUbicacion() {
        return "Sección: " + nombre;
    }

    public List<ComponenteAsiento> obtenerAsientosDisponibles() {
        List<ComponenteAsiento> disponibles = new ArrayList<>();
        for (ComponenteAsiento asiento : asientos) {
            if (asiento.esDisponible()) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }

    public double obtenerPorcentajeOcupacion() {
        if (asientos.isEmpty()) return 0;

        int ocupados = 0;
        for (ComponenteAsiento asiento : asientos) {
            if (!asiento.esDisponible()) {
                ocupados++;
            }
        }
        return (ocupados * 100.0) / asientos.size();
    }

    public void agregarAsiento(ComponenteAsiento asiento) {
        asientos.add(asiento);
        capacidadTotal++;
    }

    @Override public String getId() { return nombre; }
    public String getNombre() { return nombre; }
    public int getCapacidadTotal() { return capacidadTotal; }
    public List<ComponenteAsiento> getAsientos() { return asientos; }
    public double getPrecioBase() { return precioBase; }
    @Override public EstadoAsiento getEstado() {
        return esDisponible() ? EstadoAsiento.LIBRE : EstadoAsiento.OCUPADO;
    }
}
