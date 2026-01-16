import sistema.*;
import factory.*;
import observer.*;
import composite.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       
        SistemaEnVivoTickets sistema = new SistemaEnVivoTickets();
        sistema.iniciarSistema();

       
        Usuario usuario = new Usuario("U001", "Juan Pérez", "juan@email.com", "0999999999");
        usuario.agregarPreferencia("cancelación");

        
        GestorEventos gestorEventos = sistema.getGestorEventos();
        DatosEvento datosEvento = new DatosEvento(
                "Hamlet",
                new Date(),
                "Obra clásica de Shakespeare"
        );

        Evento evento = gestorEventos.crearNuevoEvento("obra_teatro", datosEvento);


      
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
    }
}