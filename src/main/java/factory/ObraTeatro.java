package factory;

import java.util.*;
import observer.FuncionEvento;

public class ObraTeatro implements Evento {
    private String id;
    private String titulo;
    private String descripcion;
    private String director;
    private int duracionMinutos;
    private String elencoPrincipal;
    private List<FuncionEvento> funciones;

    public ObraTeatro() {
        this.funciones = new ArrayList<>();
    }

    @Override
    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 48 horas antes del evento con reembolso del 80%";
    }

    @Override
    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("Platea", 50.0);
        precios.put("Balcón", 30.0);
        precios.put("VIP", 80.0);
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
    public String getDirector() { return director; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public String getElencoPrincipal() { return elencoPrincipal; }

    @Override public void setId(String id) { this.id = id; }
    @Override public void setTitulo(String titulo) { this.titulo = titulo; }
    @Override public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDirector(String director) { this.director = director; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public void setElencoPrincipal(String elencoPrincipal) { this.elencoPrincipal = elencoPrincipal; }
}