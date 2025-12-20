package factory;

import java.util.*;
import observer.FuncionEvento;

public class StandUp implements Evento {
    private String id;
    private String titulo;
    private String descripcion;

    private String comediante;
    private boolean contenidoAdultos;
    private String tematica;

    private int edadMinima;

    private final List<FuncionEvento> funciones;

    public StandUp() {
        this.funciones = new ArrayList<>();
    }

    @Override
    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 12 horas antes del evento con reembolso del 50%";
    }

    @Override
    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 20.0);
        precios.put("Front Row", 35.0);
        return precios;
    }

    @Override
    public void agregarFuncion(FuncionEvento funcion) {
        funciones.add(funcion);
    }

    @Override
    public List<FuncionEvento> obtenerFuncionesDisponibles() {
        return new ArrayList<>(funciones);
    }

    @Override public String getId() { return id; }
    @Override public String getTitulo() { return titulo; }
    @Override public String getDescripcion() { return descripcion; }

    public String getComediante() { return comediante; }
    public boolean isContenidoAdultos() { return contenidoAdultos; }
    public String getTematica() { return tematica; }
    public int getEdadMinima() { return edadMinima; }

    @Override public void setId(String id) { this.id = id; }
    @Override public void setTitulo(String titulo) { this.titulo = titulo; }
    @Override public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setComediante(String comediante) { this.comediante = comediante; }
    public void setContenidoAdultos(boolean contenidoAdultos) { this.contenidoAdultos = contenidoAdultos; }
    public void setTematica(String tematica) { this.tematica = tematica; }
    public void setEdadMinima(int edadMinima) { this.edadMinima = edadMinima; }
}
