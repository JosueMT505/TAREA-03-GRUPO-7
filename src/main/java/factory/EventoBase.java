package factory;

import observer.FuncionEvento;

import java.util.*;

public abstract class EventoBase implements Evento {
    protected List<FuncionEvento> funciones = new ArrayList<>();

    protected final String id;
    protected String titulo;
    protected String descripcion;

    public EventoBase() {
        this.id = UUID.randomUUID().toString();
    }

    public void agregarFuncion(FuncionEvento funcion) {
        if (funcion != null) {
            funciones.add(funcion);
        }
    }

    public List<FuncionEvento> obtenerFuncionesDisponibles() {
        return new ArrayList<>(funciones);
    }

    public String getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getDescripcion() {return descripcion;}

    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 72 horas antes del evento con reembolso del 85%";
    }

    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 35.0);
        precios.put("Preferencial", 60.0);
        precios.put("VIP", 110.0);
        return precios;
    }
}