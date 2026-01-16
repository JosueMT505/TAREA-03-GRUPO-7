package factory;

import java.util.*;

public class GestorEventos {
    private final Map<String, CreadorEvento> creadores;
    private final List<Evento> eventosActivos;

    public GestorEventos() {
        this.creadores = new HashMap<>();
        this.eventosActivos = new ArrayList<>();
        inicializarCreadores();
    }

    private void inicializarCreadores() {
        creadores.put("obra_teatro", new CreadorObraTeatro());
        creadores.put("microteatro", new CreadorMicroteatro());
        creadores.put("standup", new CreadorStandUp());
        creadores.put("concierto", new CreadorConcierto());
    }

    public Evento crearNuevoEvento(String tipo, DatosEvento datos) {
        CreadorEvento creador = creadores.get(tipo);

        if (creador == null) {
            System.out.println("Tipo de evento no soportado: " + tipo);
            return null;
        }

        // REFACTOR CASO 3: Eliminamos el envío de 'fecha' y el tercer parámetro repetido
        // Ahora la firma es limpia y solo pasa lo necesario.
        Evento evento = creador.crearEvento(datos.getTitulo());

        // Configuramos los demás datos que vienen en el objeto contenedor
        evento.setDescripcion(datos.getDescripcion());

        creador.configurarEvento(evento);
        eventosActivos.add(evento);

        System.out.println("Evento creado exitosamente: " + evento.getTitulo());
        return evento;
    }

    public List<Evento> buscarEventosPorTipo(String tipo) {
        List<Evento> resultado = new ArrayList<>();
        for (Evento evento : eventosActivos) {
            // Una forma más segura de comparar tipos
            if (evento.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

    public Evento obtenerEvento(String id) {
        for (Evento evento : eventosActivos) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }
        return null;
    }

    public List<Evento> getEventosActivos() { return eventosActivos; }
}