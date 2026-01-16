package composite;

import org.junit.jupiter.api.Test;
import sistema.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class AsientoIndividualTest {

    @Test
    void reservarYLiberar_debeCambiarEstadoCorrectamente() {
        Usuario u = new Usuario("1", "Carlos", "c@mail.com", "0666666666");

        AsientoIndividual a = new AsientoIndividual(
                "Platea-A-1",
                new Ubicacion("Platea", "A", 1),
                50.0
        );

        assertTrue(a.esDisponible());
        assertEquals(EstadoAsiento.LIBRE, a.getEstado());

        boolean reservado = a.reservar(u);
        assertTrue(reservado);
        assertFalse(a.esDisponible());
        assertEquals(EstadoAsiento.RESERVADO, a.getEstado());
        assertEquals("Platea - Fila A - Asiento 1", a.getUbicacion());

        a.liberar();
        assertTrue(a.esDisponible());
        assertEquals(EstadoAsiento.LIBRE, a.getEstado());
    }
}
