package composite;

import sistema.Usuario;
import java.util.Date;

public class AsientoIndividual implements ComponenteAsiento {
    private String id;
    private String seccion;
    private String fila;
    private int numero;
    private double precio;
    private EstadoAsiento estado;
    private Usuario usuarioReserva;
    private Date tiempoReserva;

    public AsientoIndividual(String id, String seccion, String fila, int numero, double precio) {
        this.id = id;
        this.seccion = seccion;
        this.fila = fila;
        this.numero = numero;
        this.precio = precio;
        this.estado = EstadoAsiento.LIBRE;
    }

    @Override
    public boolean reservar(Usuario usuario) {
        if (esDisponible()) {
            this.estado = EstadoAsiento.RESERVADO;
            this.usuarioReserva = usuario;
            this.tiempoReserva = new Date();
            System.out.println("Asiento " + id + " reservado para " + usuario.getNombre());
            return true;
        }
        return false;
    }

    @Override
    public void liberar() {
        this.estado = EstadoAsiento.LIBRE;
        this.usuarioReserva = null;
        this.tiempoReserva = null;
        System.out.println("Asiento " + id + " liberado");
    }

    @Override
    public boolean esDisponible() {
        return estado == EstadoAsiento.LIBRE;
    }

    @Override
    public String getUbicacion() {
        return seccion + " - Fila " + fila + " - Asiento " + numero;
    }

    @Override public String getId() { return id; }
    @Override public double getPrecio() { return precio; }
    @Override public EstadoAsiento getEstado() { return estado; }
    public String getSeccion() { return seccion; }
    public String getFila() { return fila; }
    public int getNumero() { return numero; }
    public Usuario getUsuarioReserva() { return usuarioReserva; }
    public Date getTiempoReserva() { return tiempoReserva; }
}