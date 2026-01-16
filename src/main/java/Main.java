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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
        
        GestorEventos gestorEventos = sistema.getGestorEventos();
        DatosEvento datosEvento = new DatosEvento(
                "Hamlet",
                new Date(),
                "Obra clásica de Shakespeare"
        );
=======
=======
>>>>>>> Stashed changes
    private static Evento crearEventoDemo(SistemaEnVivoTickets sistema) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("titulo", "Hamlet");
        datos.put("descripcion", "Obra clásica");
<<<<<<< Updated upstream
>>>>>>> Stashed changes

        return sistema.getGestorEventos().crearNuevoEvento("obra_teatro", datos);
    }

<<<<<<< Updated upstream

      
        FuncionEvento funcion = new FuncionEvento("F001", new Date(), evento);
        funcion.registrarObservador(usuario.getObservador());
        funcion.registrarObservador(sistema.getSistemaNotificaciones());
        funcion.registrarObservador(sistema.getGestorReservas());

        
        System.out.println("\n" + funcion.getMapaAsientos().visualizarMapa());

        
        List<String> asientosSeleccionados = Arrays.asList("Platea-A-1", "Platea-A-2");
        sistema.procesarCompra(usuario, evento.getId(), asientosSeleccionados);

        
        System.out.println("\n--- Simulando cancelación ---");
        funcion.cancelarFuncion();

        
        PaqueteAsientos paquete = new PaqueteAsientos("P001", "Paquete Familiar", 0.15);
       

        System.out.println("\nSistema probado exitosamente!");
=======
=======

        return sistema.getGestorEventos().crearNuevoEvento("obra_teatro", datos);
    }

>>>>>>> Stashed changes
    private static void simularFlujoCompra(SistemaEnVivoTickets sistema, Usuario usuario, Evento evento) {
        List<String> asientos = Arrays.asList("Platea-A-1", "Platea-A-2");
        System.out.println("Iniciando simulación de compra...");
        sistema.procesarCompra(usuario, evento.getId(), asientos);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }
}