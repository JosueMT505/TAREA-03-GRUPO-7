package factory;

import java.util.Date;

public abstract class CreadorEvento {
    protected abstract Evento metodoFabrica();

    public Evento crearEvento(String titulo, Date fecha) {
        Evento evento = metodoFabrica();
        evento.setTitulo(titulo);
        return evento;
    }

    public void configurarEvento(Evento evento) {
        System.out.println("Configurando evento: " + evento.getTitulo());
    }
}