package factory;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorEventosTest {

    @Test
    void crearEventoSoportado_debeCrearloYAgregarloAActivos() {
        GestorEventos gestor = new GestorEventos();
        DatosEvento datos = new DatosEvento("Hamlet", new Date(), "Obra clásica");

        Evento evento = gestor.crearNuevoEvento("obra_teatro", datos);

        assertAll(
                () -> assertNotNull(evento),
                () -> assertEquals("Hamlet", evento.getTitulo()),
                () -> assertEquals("Obra clásica", evento.getDescripcion()),
                () -> assertTrue(gestor.getEventosActivos().contains(evento))
        );
    }

    @Test
    void crearEventoNoSoportado_debeRetornarNull() {
        GestorEventos gestor = new GestorEventos();
        DatosEvento datos = new DatosEvento("X", new Date(), "Y");

        Evento evento = gestor.crearNuevoEvento("tipo_inexistente", datos);

        assertNull(evento);
    }

    @Test
    void buscarEventosPorTipo_debeFiltrarCorrectamente_yEnTiempoRazonable() {
        GestorEventos gestor = new GestorEventos();
        gestor.crearNuevoEvento("obra_teatro", new DatosEvento("Hamlet", new Date(), "Desc"));
        gestor.crearNuevoEvento("microteatro", new DatosEvento("Micro 1", new Date(), "Desc"));

        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            List<Evento> obras = gestor.buscarEventosPorTipo("obra");
            assertFalse(obras.isEmpty());
            assertTrue(obras.get(0).getClass().getSimpleName().toLowerCase().contains("obra"));
        });
    }
}
