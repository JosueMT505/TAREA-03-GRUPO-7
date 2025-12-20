package factory;

import java.util.*;
import observer.FuncionEvento;

public class Microteatro implements Evento {
    private String id;
    private String titulo;
    private String descripcion;

    private int aforoMaximo;
    private String ubicacionEspecifica;
    private boolean interaccionPublico;

    private final List<FuncionEvento> funciones;

    public Microteatro() {
        this.funciones = new ArrayList<>();
    }

    @Override
    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 24 horas antes del evento con reembolso del 70%";
    }

    @Override
    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 15.0);
        precios.put("Preferencial", 25.0);
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

    public int getAforoMaximo() { return aforoMaximo; }
    public String getUbicacionEspecifica() { return ubicacionEspecifica; }
    public boolean isInteraccionPublico() { return interaccionPublico; }

    @Override public void setId(String id) { this.id = id; }
    @Override public void setTitulo(String titulo) { this.titulo = titulo; }
    @Override public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setAforoMaximo(int aforoMaximo) { this.aforoMaximo = aforoMaximo; }
    public void setUbicacionEspecifica(String ubicacionEspecifica) { this.ubicacionEspecifica = ubicacionEspecifica; }
    public void setInteraccionPublico(boolean interaccionPublico) { this.interaccionPublico = interaccionPublico; }
}