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

        Evento evento = creador.crearEvento(
                datos.getTitulo(),
                datos.getFecha()
        );

        evento.setDescripcion(datos.getDescripcion());

        creador.configurarEvento(evento);
        eventosActivos.add(evento);

        System.out.println("Evento creado: " + evento.getTitulo());
        return evento;
    }


    public List<Evento> buscarEventosPorTipo(String tipo) {
        List<Evento> resultado = new ArrayList<>();
        for (Evento evento : eventosActivos) {
            if (evento.getClass().getSimpleName().toLowerCase().contains(tipo.toLowerCase())) {
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