package sistema;

import factory.*;
import observer.*;
import java.util.*;

public class SistemaEnVivoTickets {
    private GestorEventos gestorEventos;
    private GestorReservas gestorReservas;
    private SistemaNotificaciones sistemaNotificaciones;

    public SistemaEnVivoTickets() {
        this.gestorEventos = new GestorEventos();
        this.sistemaNotificaciones = new SistemaNotificaciones();
        this.gestorReservas = new GestorReservas();
    }

    public void iniciarSistema() {
        System.out.println("Sistema EnVivoTickets iniciado");
    }

    public Ticket procesarCompra(Usuario usuario, String eventoId, List<String> asientosIds) {
        Evento evento = gestorEventos.obtenerEvento(eventoId);
        if (evento == null) {
            System.out.println("Evento no encontrado");
            return null;
        }

        Ticket ticket = usuario.realizarReserva(evento, asientosIds);
        gestorReservas.registrarReserva(ticket);

        return ticket;
    }

    public void liberarReservasExpiradas() {
        System.out.println("Liberando reservas expiradas...");
    }

    public GestorEventos getGestorEventos() { return gestorEventos; }
    public GestorReservas getGestorReservas() { return gestorReservas; }
    public SistemaNotificaciones getSistemaNotificaciones() { return sistemaNotificaciones; }
}