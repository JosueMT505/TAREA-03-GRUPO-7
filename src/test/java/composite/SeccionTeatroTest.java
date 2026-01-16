package composite;

import org.junit.jupiter.api.Test;
import sistema.Usuario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeccionTeatroTest {

    @Test
    void ocupacionYDisponibles_debeCalcularBien() {
        SeccionTeatro platea = new SeccionTeatro("Platea", 50.0);
        Usuario u = new Usuario("1", "Sofia", "s@mail.com", "0555555555");

        AsientoIndividual a1 = new AsientoIndividual("Platea-A-1", "Platea", "A", 1, 50.0);
        AsientoIndividual a2 = new AsientoIndividual("Platea-A-2", "Platea", "A", 2, 50.0);

        platea.agregarAsiento(a1);
        platea.agregarAsiento(a2);

        assertEquals(2, platea.getCapacidadTotal());

        a1.reservar(u);

        double ocupacion = platea.obtenerPorcentajeOcupacion();
        List<ComponenteAsiento> disponibles = platea.obtenerAsientosDisponibles();

        assertAll(
                () -> assertEquals(50.0, ocupacion, 0.0001),
                () -> assertEquals(1, disponibles.size()),
                () -> assertTrue(disponibles.get(0).getId().equals("Platea-A-2"))
        );
    }

    @Test
    void obtenerAsientosDisponibles_debeMantenerOrdenEsperado() {
        SeccionTeatro vip = new SeccionTeatro("VIP", 80.0);

        AsientoIndividual v1 = new AsientoIndividual("VIP-V-1", "VIP", "V", 1, 80.0);
        AsientoIndividual v2 = new AsientoIndividual("VIP-V-2", "VIP", "V", 2, 80.0);

        vip.agregarAsiento(v1);
        vip.agregarAsiento(v2);

        var ids = vip.obtenerAsientosDisponibles().stream().map(ComponenteAsiento::getId).toList();
        assertIterableEquals(List.of("VIP-V-1", "VIP-V-2"), ids);
    }
}
