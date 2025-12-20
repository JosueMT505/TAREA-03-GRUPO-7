package composite;

import factory.ObraTeatro;
import factory.Evento;
import observer.FuncionEvento;
import org.junit.jupiter.api.Test;
import sistema.Usuario;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapaAsientosTest {

    @Test
    void mapaAsientos_debeInicializarSeccionesYAsientos() {
        Evento e = new ObraTeatro();
        e.setTitulo("Obra");
        FuncionEvento f = new FuncionEvento("F1", new Date(), e);

        MapaAsientos mapa = f.getMapaAsientos();

        assertEquals(3, mapa.getSecciones().size());

        int totalAsientos = mapa.getSecciones().stream()
                .mapToInt(s -> s.getAsientos().size())
                .sum();

        assertEquals(30, totalAsientos);

        String vista = mapa.visualizarMapa();
        assertTrue(vista.contains("Mapa de Asientos para:"));
        assertTrue(vista.contains("Platea"));
        assertTrue(vista.contains("VIP"));
    }

    @Test
    void seleccionarAsientos_soloDebeDevolverDisponibles() {
        Evento e = new ObraTeatro();
        e.setTitulo("Obra");
        FuncionEvento f = new FuncionEvento("F1", new Date(), e);
        MapaAsientos mapa = f.getMapaAsientos();

        ComponenteAsiento asiento = mapa.getSecciones().get(0).getAsientos().get(0);
        String id = asiento.getId();

        Usuario u = new Usuario("U1", "Ana", "a@a.com", "099");
        assertTrue(asiento.esDisponible());
        assertTrue(asiento.reservar(u));
        assertFalse(asiento.esDisponible());

        List<ComponenteAsiento> seleccion = mapa.seleccionarAsientos(List.of(id));
        assertTrue(seleccion.isEmpty());
    }
}
