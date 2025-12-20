package composite;

import sistema.Usuario;
import java.util.*;

public class PaqueteAsientos implements ComponenteAsiento {
    private String id;
    private String descripcion;
    private double descuentoGrupo;
    private List<ComponenteAsiento> asientos;
    private boolean incluyeServicios;

    public PaqueteAsientos(String id, String descripcion, double descuentoGrupo) {
        this.id = id;
        this.descripcion = descripcion;
        this.descuentoGrupo = descuentoGrupo;
        this.asientos = new ArrayList<>();
        this.incluyeServicios = false;
    }

    @Override
    public boolean reservar(Usuario usuario) {
        for (ComponenteAsiento asiento : asientos) {
            if (!asiento.esDisponible()) {
                System.out.println("No todos los asientos del paquete están disponibles");
                return false;
            }
        }

        for (ComponenteAsiento asiento : asientos) {
            asiento.reservar(usuario);
        }

        System.out.println("Paquete " + descripcion + " reservado para " + usuario.getNombre());
        return true;
    }

    @Override
    public void liberar() {
        for (ComponenteAsiento asiento : asientos) {
            asiento.liberar();
        }
        System.out.println("Paquete " + descripcion + " liberado");
    }

    @Override
    public boolean esDisponible() {
        for (ComponenteAsiento asiento : asientos) {
            if (!asiento.esDisponible()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public double getPrecio() {
        double precioTotal = 0;
        for (ComponenteAsiento asiento : asientos) {
            precioTotal += asiento.getPrecio();
        }
        return precioTotal * (1 - descuentoGrupo);
    }

    @Override
    public String getUbicacion() {
        return "Paquete: " + descripcion;
    }

    public void agregarAsiento(ComponenteAsiento asiento) {
        asientos.add(asiento);
    }

    public void removerAsiento(ComponenteAsiento asiento) {
        asientos.remove(asiento);
    }

    @Override public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public double getDescuentoGrupo() { return descuentoGrupo; }
    public List<ComponenteAsiento> getAsientos() { return asientos; }
    public boolean isIncluyeServicios() { return incluyeServicios; }
    @Override public EstadoAsiento getEstado() {
        for (ComponenteAsiento asiento : asientos) {
            if (asiento.getEstado() == EstadoAsiento.RESERVADO ||
                    asiento.getEstado() == EstadoAsiento.OCUPADO) {
                return asiento.getEstado();
            }
        }
        return EstadoAsiento.LIBRE;
    }

    public void setIncluyeServicios(boolean incluyeServicios) {
        this.incluyeServicios = incluyeServicios;
    }
}