package factory;

import java.util.Date;

public class CreadorConcierto extends CreadorEvento {
    private String promotor;

    public CreadorConcierto() {
        this.promotor = "Live Nation Ecuador";
    }

    @Override
    protected Evento metodoFabrica() {
        return new Concierto();
    }

    @Override
    public Evento crearEvento(String titulo) {
        Evento evento = super.crearEvento(titulo);
        configurarEvento(evento);
        return evento;
    }

    @Override
    public void configurarEvento(Evento evento) {
        super.configurarEvento(evento);

        if (evento instanceof Concierto) {
            Concierto concierto = (Concierto) evento;
            concierto.setProduccionEspecial(true);
            concierto.setDuracionMinutos(120);
            concierto.setGeneroMusical("Rock");

            System.out.println("Concierto configurado por promotor: " + promotor +
                    " (Producción especial: Sí, Duración: 120 min, Género: Rock)");
        }
    }

    public String getPromotor() { return promotor; }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }
}