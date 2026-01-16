package factory;

import java.util.*;
import observer.FuncionEvento;

public class Concierto extends EventoBase {

    private String artistaPrincipal;
    private String generoMusical;
    private List<String> artistasInvitados;

    private int duracionMinutos;
    private boolean produccionEspecial;

    private final List<FuncionEvento> funciones;

    public Concierto() {
        this.funciones = new ArrayList<>();
        this.artistasInvitados = new ArrayList<>();
    }

    @Override
    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 48 horas antes del evento con reembolso del 85%";
    }

    @Override
    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 40.0);
        precios.put("Preferencial", 60.0);
        precios.put("VIP", 110.0);
        return precios;
    }

    public void agregarFuncion(FuncionEvento funcion) {
        funciones.add(funcion);
    }

    public List<FuncionEvento> obtenerFuncionesDisponibles() {
        return new ArrayList<>(funciones);
    }


    public String getArtistaPrincipal() { return artistaPrincipal; }
    public String getGeneroMusical() { return generoMusical; }
    public List<String> getArtistasInvitados() { return new ArrayList<>(artistasInvitados); }
    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean isProduccionEspecial() { return produccionEspecial; }

    public void setArtistaPrincipal(String artistaPrincipal) { this.artistaPrincipal = artistaPrincipal; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }

    public void setArtistasInvitados(List<String> artistasInvitados) {
        this.artistasInvitados = (artistasInvitados == null) ? new ArrayList<>() : new ArrayList<>(artistasInvitados);
    }

    public void agregarArtistaInvitado(String artista) {
        if (artista != null && !artista.isBlank()) {
            this.artistasInvitados.add(artista);
        }
    }

    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public void setProduccionEspecial(boolean produccionEspecial) { this.produccionEspecial = produccionEspecial; }
}
