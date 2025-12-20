package sistema;

import factory.Evento;
import observer.UsuarioObservador;
import java.util.*;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private List<String> preferencias;
    private UsuarioObservador observador;

    public Usuario(String id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.preferencias = new ArrayList<>();
        this.observador = new UsuarioObservador(this);
    }

    public Ticket realizarReserva(Evento evento, List<String> asientosIds) {
        System.out.println("Usuario " + nombre + " realizando reserva para " + evento.getTitulo());

        Ticket ticket = new Ticket(
                UUID.randomUUID().toString(),
                this,
                evento,
                asientosIds
        );

        ticket.confirmarCompra();
        return ticket;
    }

    public void recibirNotificacion(String mensaje) {
        System.out.println("NotificaciÃ³n para " + nombre + ": " + mensaje);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public UsuarioObservador getObservador() { return observador; }
    public List<String> getPreferencias() { return preferencias; }

    public void agregarPreferencia(String preferencia) {
        preferencias.add(preferencia);
    }
}