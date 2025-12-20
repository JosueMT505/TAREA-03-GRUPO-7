package factory;

import java.util.Date;

public class CreadorObraTeatro extends CreadorEvento {
    private String teatroAsociado;

    public CreadorObraTeatro() {
        this.teatroAsociado = "Teatro Nacional";
    }

    @Override
    protected Evento metodoFabrica() {
        return new ObraTeatro();
    }

    @Override
    public Evento crearEvento(String titulo, Date fecha) {
        Evento evento = super.crearEvento(titulo, fecha);
        configurarEvento(evento);
        return evento;
    }
    
    @Override
    public void configurarEvento(Evento evento) {
        super.configurarEvento(evento);
        if (evento instanceof ObraTeatro) {
            ObraTeatro obra = (ObraTeatro) evento;
            obra.setDirector("Director Predeterminado");
            obra.setDuracionMinutos(120);
        }
    }

    public String getTeatroAsociado() { return teatroAsociado; }
    public void setTeatroAsociado(String teatroAsociado) { this.teatroAsociado = teatroAsociado; }
}
