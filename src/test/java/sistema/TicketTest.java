package sistema;

import factory.ObraTeatro;
import factory.Evento;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void confirmarCompra_debeCambiarEstado() {
        Usuario u = new Usuario("U1", "Ana", "a@a.com", "099");
        Evento e = new ObraTeatro();
        e.setTitulo("Obra");

        Ticket t = new Ticket("T1", u, e, List.of("A1"));

        assertEquals(EstadoTicket.RESERVADO, t.getEstado());
        t.confirmarCompra();
        assertEquals(EstadoTicket.CONFIRMADO, t.getEstado());
    }

    @Test
    void esExpirado_debeSerTrueSiReservaVencioYNoConfirmado() throws Exception {
        Usuario u = new Usuario("U1", "Ana", "a@a.com", "099");
        Evento e = new ObraTeatro();
        e.setTitulo("Obra");

        Ticket t = new Ticket("T2", u, e, List.of("A1"));

        Field f = Ticket.class.getDeclaredField("fechaExpiracionReserva");
        f.setAccessible(true);
        f.set(t, new Date(System.currentTimeMillis() - 1000)); // ya vencido

        assertTrue(t.esExpirado());
    }

    @Test
    void esExpirado_debeSerFalseSiConfirmadoAunqueFechaVencio() throws Exception {
        Usuario u = new Usuario("U1", "Ana", "a@a.com", "099");
        Evento e = new ObraTeatro();
        e.setTitulo("Obra");

        Ticket t = new Ticket("T3", u, e, List.of("A1"));

        Field f = Ticket.class.getDeclaredField("fechaExpiracionReserva");
        f.setAccessible(true);
        f.set(t, new Date(System.currentTimeMillis() - 1000));

        t.confirmarCompra();

        assertFalse(t.esExpirado());
    }
}
