package observer;

import factory.ObraTeatro;
import factory.Evento;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionEventoObserverTest {

    static class ObservadorFake implements Observador {
        private final List<String> mensajes = new ArrayList<>();
        @Override public void actualizar(String mensaje) { mensajes.add(mensaje); }
        List<String> getMensajes() { return mensajes; }
    }

    @Test
    void cambiarFecha_debeCambiarEstadoYNotificar() {
        Evento evento = new ObraTeatro();
        evento.setTitulo("Obra X");
        FuncionEvento funcion = new FuncionEvento("F1", new Date(), evento);

        ObservadorFake obs = new ObservadorFake();
        funcion.registrarObservador(obs);

        Date nueva = new Date(System.currentTimeMillis() + 86_400_000);
        funcion.cambiarFecha(nueva);

        assertEquals(EstadoFuncion.REPROGRAMADO, funcion.getEstado());
        assertFalse(obs.getMensajes().isEmpty());
        assertTrue(obs.getMensajes().get(0).toLowerCase().contains("reprogram"));
    }

    @Test
    void cancelarFuncion_debeCambiarEstadoYNotificar() {
        Evento evento = new ObraTeatro();
        evento.setTitulo("Obra Y");
        FuncionEvento funcion = new FuncionEvento("F2", new Date(), evento);

        ObservadorFake obs = new ObservadorFake();
        funcion.registrarObservador(obs);

        funcion.cancelarFuncion();

        assertEquals(EstadoFuncion.CANCELADO, funcion.getEstado());
        assertTrue(obs.getMensajes().stream().anyMatch(m -> m.toLowerCase().contains("cancel")));
    }
}
