package factory;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {

    @Test
    void creadorObraTeatro_debeCrearYConfigurar() {
        CreadorEvento creador = new CreadorObraTeatro();

        Evento e = creador.crearEvento("Hamlet");
        creador.configurarEvento(e);

        assertNotNull(e);
        assertTrue(e instanceof ObraTeatro);
        assertEquals("Hamlet", e.getTitulo());

        ObraTeatro obra = (ObraTeatro) e;
        assertEquals("Director Predeterminado", obra.getDirector());
        assertEquals(120, obra.getDuracionMinutos());
    }

    @Test
    void creadorMicroteatro_debeCrearYConfigurar() {
        CreadorEvento creador = new CreadorMicroteatro();

        Evento e = creador.crearEvento("Micro");

        assertNotNull(e);
        assertTrue(e instanceof Microteatro);
        assertEquals("Micro", e.getTitulo());

        Microteatro m = (Microteatro) e;
        assertEquals(50, m.getAforoMaximo());
        assertTrue(m.isInteraccionPublico());
        assertNotNull(m.getUbicacionEspecifica());
    }

    @Test
    void creadorConcierto_debeCrearYConfigurar() {
        CreadorEvento creador = new CreadorConcierto();

        Evento e = creador.crearEvento("RockFest");

        assertNotNull(e);
        assertTrue(e instanceof Concierto);
        assertEquals("RockFest", e.getTitulo());

        Concierto c = (Concierto) e;
        assertTrue(c.isProduccionEspecial());
        assertEquals(120, c.getDuracionMinutos());
        assertEquals("Rock", c.getGeneroMusical());
    }

    @Test
    void creadorStandUp_debeCrearYConfigurar() {
        CreadorEvento creador = new CreadorStandUp();

        Evento e = creador.crearEvento("Risas");

        assertNotNull(e);
        assertTrue(e instanceof StandUp);
        assertEquals("Risas", e.getTitulo());

        StandUp s = (StandUp) e;
        assertFalse(s.isContenidoAdultos());
        assertEquals(12, s.getEdadMinima());
        assertEquals("Comedia Observacional", s.getTematica());
    }
}
