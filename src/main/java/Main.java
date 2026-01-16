import sistema.*;
import factory.*;
import observer.*;
import composite.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SistemaEnVivoTickets sistema = configurarSistema();
        Usuario usuario = crearUsuarioDemo();
        Evento evento = crearEventoDemo(sistema);

        simularFlujoCompra(sistema, usuario, evento);
    }

    private static SistemaEnVivoTickets configurarSistema() {
        SistemaEnVivoTickets sistema = new SistemaEnVivoTickets();
        sistema.iniciarSistema();
        return sistema;
    }

    private static Usuario crearUsuarioDemo() {
        Usuario usuario = new Usuario("U001", "Juan Pérez", "juan@email.com", "0999999999");
        usuario.agregarPreferencia("conciertos");
        return usuario;
    }

    private static Evento crearEventoDemo(SistemaEnVivoTickets sistema) {
        return sistema.getGestorEventos().crearNuevoEvento("obra_teatro", new DatosEvento("Hamlet", new Date(),"ObraTeatro"));
    }

    private static void simularFlujoCompra(SistemaEnVivoTickets sistema, Usuario usuario, Evento evento) {
        List<String> asientos = Arrays.asList("Platea-A-1", "Platea-A-2");
        System.out.println("Iniciando simulación de compra...");
        sistema.procesarCompra(usuario, evento.getId(), asientos);
    }
}