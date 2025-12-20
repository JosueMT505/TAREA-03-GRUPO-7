package observer;

import sistema.Ticket;
import sistema.Usuario;
import factory.Evento;
import java.util.*;

public class GestorReservas implements Observador {
    private Map<String, Ticket> reservasActivas;

    public GestorReservas() {
        this.reservasActivas = new HashMap<>();
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Gestor de Reservas recibió: " + mensaje);

        if (mensaje.contains("cancelada")) {
            liberarReservasPorCancelacion("evento_id");
        }
    }

    public void liberarReservasPorCancelacion(String eventoId) {
        List<Ticket> reservasALiberar = new ArrayList<>();

        for (Ticket ticket : reservasActivas.values()) {
            if (ticket.getEvento().getId().equals(eventoId)) {
                reservasALiberar.add(ticket);
            }
        }

        for (Ticket ticket : reservasALiberar) {
            ticket.cancelar();
            reservasActivas.remove(ticket.getId());
            System.out.println("Reserva liberada: " + ticket.getId());
        }
    }

    public void ofrecerAlternativas(Usuario usuario, Evento eventoOriginal) {
        System.out.println("Ofreciendo alternativas a " + usuario.getNombre() +
                " por cancelación de " + eventoOriginal.getTitulo());
    }

    public void registrarReserva(Ticket ticket) {
        reservasActivas.put(ticket.getId(), ticket);
    }

    public Map<String, Ticket> getReservasActivas() { return reservasActivas; }
}