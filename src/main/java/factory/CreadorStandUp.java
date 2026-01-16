package factory;

import java.util.Date;

public class CreadorStandUp extends CreadorEvento {
    private String productora;

    public CreadorStandUp() {
        this.productora = "Comedy Central Productions";
    }

    @Override
    protected Evento metodoFabrica() {
        return new StandUp();
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

        if (evento instanceof StandUp) {
            StandUp standUp = (StandUp) evento;
            standUp.setContenidoAdultos(false);
            standUp.setEdadMinima(12);
            standUp.setTematica("Comedia Observacional");

            System.out.println("StandUp configurado por productora: " + productora +
                    " (Edad mínima: 12, Temática: Comedia Observacional)");
        }
    }

    public String getProductora() { return productora; }

    public void setProductora(String productora) {
        this.productora = productora;
    }
}