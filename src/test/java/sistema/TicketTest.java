package sistema;

import factory.ObraTeatro;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void ticketDebeIniciarReservado_yCambiarEstados() {
        ObraTeatro evento = new ObraTeatro();
        evento.setTitulo("Obra A");
        evento.setDescripcion("Desc");

        Usuario u = new Usuario("1", "Ana", "ana@mail.com", "0999999999");

        Ticket t = new Ticket("T1", u, evento, List.of("Platea-A-1"));

        assertEquals(EstadoTicket.RESERVADO, t.getEstado());

        t.confirmarCompra();
        assertEquals(EstadoTicket.CONFIRMADO, t.getEstado());

        t.cancelar();
        assertEquals(EstadoTicket.CANCELADO, t.getEstado());
    }

    @Test
    void esExpirado_debeSerTrue_siExpiraYEstaReservado() throws Exception {
        ObraTeatro evento = new ObraTeatro();
        evento.setTitulo("Obra B");
        Usuario u = new Usuario("2", "Luis", "luis@mail.com", "0888888888");

        Ticket t = new Ticket("T2", u, evento, List.of("VIP-V-1"));

        // Forzar expiración con reflexión (campo privado fechaExpiracionReserva)
        Field f = Ticket.class.getDeclaredField("fechaExpiracionReserva");
        f.setAccessible(true);
        f.set(t, new Date(System.currentTimeMillis() - 60_000)); // 1 min en el pasado

        assertTrue(t.esExpirado());
    }

    @Test
    void realizarReserva_conEventoNull_debeLanzarExcepcion() {
        Usuario u = new Usuario("3", "Marta", "m@mail.com", "0777777777");

        assertThrows(NullPointerException.class, () ->
                u.realizarReserva(null, List.of("A-1"))
        );
    }
}
