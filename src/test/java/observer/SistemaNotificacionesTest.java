package observer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaNotificacionesTest {

    @Test
    void canalesPorDefecto_debenSerEmailSmsPush() {
        SistemaNotificaciones sn = new SistemaNotificaciones();
        assertIterableEquals(List.of("email", "sms", "push"), sn.getCanales());
    }

    @Test
    void setCanales_debeActualizarLista() {
        SistemaNotificaciones sn = new SistemaNotificaciones();
        sn.setCanales(List.of("email"));

        assertEquals(1, sn.getCanales().size());
        assertEquals("email", sn.getCanales().get(0));
    }
}
