package sistema;

import factory.Evento;
import java.util.Date;
import java.util.List;

public class Ticket {
    private String id;
    private EstadoTicket estado;
    private Evento evento;
    private List<String> asientos;
    private Usuario usuario;
    private Date fechaCompra;
    private Date fechaExpiracionReserva;

    public Ticket(String id, Usuario usuario, Evento evento, List<String> asientos) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.asientos = asientos;
        this.estado = EstadoTicket.RESERVADO;
        this.fechaCompra = new Date();
        this.fechaExpiracionReserva = new Date(fechaCompra.getTime() + 15 * 60 * 1000);
    }

    public void confirmarCompra() {
        this.estado = EstadoTicket.CONFIRMADO;
        System.out.println("Ticket " + id + " confirmado");
    }

    public void cancelar() {
        this.estado = EstadoTicket.CANCELADO;
        System.out.println("Ticket " + id + " cancelado");
    }

    public boolean esExpirado() {
        return new Date().after(fechaExpiracionReserva) && estado == EstadoTicket.RESERVADO;
    }
    
    public boolean perteneceAlEvento(String eventoId) {
        return this.evento != null && this.evento.getId().equals(eventoId);
    }

    public String getId() { return id; }
    public EstadoTicket getEstado() { return estado; }
    public Evento getEvento() { return evento; }
    public List<String> getAsientos() { return asientos; }
    public Usuario getUsuario() { return usuario; }
    public Date getFechaCompra() { return fechaCompra; }
}
