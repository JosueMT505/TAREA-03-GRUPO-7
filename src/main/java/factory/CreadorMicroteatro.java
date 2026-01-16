package factory;

import java.util.Date;

public class CreadorMicroteatro extends CreadorEvento {
    private String zonaCiudad;

    public CreadorMicroteatro() {
        this.zonaCiudad = "Centro Histórico";
    }

    @Override
    protected Evento metodoFabrica() {
        return new Microteatro();
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

        if (evento instanceof Microteatro) {
            Microteatro microteatro = (Microteatro) evento;
            microteatro.setAforoMaximo(50);
            microteatro.setInteraccionPublico(true);
            microteatro.setUbicacionEspecifica(zonaCiudad);

            System.out.println("Microteatro configurado en zona: " + zonaCiudad +
                    " (Aforo: 50, Interactivo: Sí)");
        }
    }

    public String getZonaCiudad() { return zonaCiudad; }

    public void setZonaCiudad(String zonaCiudad) {
        this.zonaCiudad = zonaCiudad;
    }
}