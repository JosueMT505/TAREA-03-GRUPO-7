package composite;

import sistema.Usuario;
import java.util.Date;

public class AsientoIndividual implements ComponenteAsiento {
    private String id;
    private double precio;
    private EstadoAsiento estado;
    private Usuario usuarioReserva;
    private Date tiempoReserva;
    
   
    private Ubicacion ubicacion; 

   
    public AsientoIndividual(String id, Ubicacion ubicacion, double precio) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.estado = EstadoAsiento.LIBRE;
    }

   
    @Override
    public String getUbicacion() {
        return ubicacion.seccion() + " - Fila " + ubicacion.fila() + " - Asiento " + ubicacion.numero();
    }

    
    public String getSeccion() { return ubicacion.seccion(); }
    public String getFila() { return ubicacion.fila(); }
    public int getNumero() { return ubicacion.numero(); }

   
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

    @Override public boolean esDisponible() { return estado == EstadoAsiento.LIBRE; }
    @Override public String getId() { return id; }
    @Override public double getPrecio() { return precio; }
    @Override public EstadoAsiento getEstado() { return estado; }
    public Usuario getUsuarioReserva() { return usuarioReserva; }
    public Date getTiempoReserva() { return tiempoReserva; }
}