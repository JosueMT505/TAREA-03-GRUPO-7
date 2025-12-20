package factory;

import java.util.*;

public class GestorEventos {
    private Map<String, CreadorEvento> creadores;
    private List<Evento> eventosActivos;

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

    public Evento crearNuevoEvento(String tipo, Map<String, Object> datos) {
        CreadorEvento creador = creadores.get(tipo);
        if (creador == null) {
            System.out.println("Tipo de evento no soportado: " + tipo);
            return null;
        }

        Evento evento = creador.crearEvento(
                (String) datos.get("titulo"),
                (Date) datos.get("fecha")
        );

        evento.setId(UUID.randomUUID().toString());
        evento.setDescripcion((String) datos.get("descripcion"));

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