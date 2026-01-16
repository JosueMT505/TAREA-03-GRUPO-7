package factory;

import java.util.*;
import observer.FuncionEvento;

public class StandUp extends EventoBase {

    private String comediante;
    private boolean contenidoAdultos;
    private String tematica;

    private int edadMinima;

    private final List<FuncionEvento> funciones;

    public StandUp() {
        this.funciones = new ArrayList<>();
    }

    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 12 horas antes del evento con reembolso del 50%";
    }

    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 20.0);
        precios.put("Front Row", 35.0);
        return precios;
    }

    public void agregarFuncion(FuncionEvento funcion) {
        funciones.add(funcion);
    }

    public List<FuncionEvento> obtenerFuncionesDisponibles() {
        return new ArrayList<>(funciones);
    }

    public String getComediante() { return comediante; }
    public boolean isContenidoAdultos() { return contenidoAdultos; }
    public String getTematica() { return tematica; }
    public int getEdadMinima() { return edadMinima; }

    public void setComediante(String comediante) { this.comediante = comediante; }
    public void setContenidoAdultos(boolean contenidoAdultos) { this.contenidoAdultos = contenidoAdultos; }
    public void setTematica(String tematica) { this.tematica = tematica; }
    public void setEdadMinima(int edadMinima) { this.edadMinima = edadMinima; }
}
