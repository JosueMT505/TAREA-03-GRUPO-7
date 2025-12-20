package observer;

import factory.Evento;
import composite.MapaAsientos;
import java.util.*;

public class FuncionEvento implements Sujeto {
    private String id;
    private Date fechaHora;
    private Evento evento;
    private MapaAsientos mapaAsientos;
    private EstadoFuncion estado;
    private List<Observador> observadores;

    public FuncionEvento(String id, Date fechaHora, Evento evento) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.evento = evento;
        this.estado = EstadoFuncion.PROGRAMADO;
        this.observadores = new ArrayList<>();
        this.mapaAsientos = new MapaAsientos(this);
    }

    public void cambiarFecha(Date nuevaFecha) {
        this.fechaHora = nuevaFecha;
        this.estado = EstadoFuncion.REPROGRAMADO;
        notificarObservadores("La función ha sido reprogramada a: " + nuevaFecha);
    }

    public void cancelarFuncion() {
        this.estado = EstadoFuncion.CANCELADO;
        notificarObservadores("La función ha sido cancelada");
    }

    public void actualizarElenco(String cambios) {
        notificarObservadores("Cambios en el elenco: " + cambios);
    }

    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("Observador registrado: " + observador.getClass().getSimpleName());
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        notificarObservadores("Cambio en la función: " + evento.getTitulo());
    }

    public void notificarObservadores(String mensaje) {
        System.out.println("Notificando " + observadores.size() + " observadores...");
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }

    public String getId() { return id; }
    public Date getFechaHora() { return fechaHora; }
    public Evento getEvento() { return evento; }
    public MapaAsientos getMapaAsientos() { return mapaAsientos; }
    public EstadoFuncion getEstado() { return estado; }
    public List<Observador> getObservadores() { return observadores; }
}