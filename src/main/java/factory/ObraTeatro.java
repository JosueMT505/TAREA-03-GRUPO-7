package factory;

import java.util.*;
import observer.FuncionEvento;

public class ObraTeatro extends EventoBase {

    private String director;
    private int duracionMinutos;
    private String elencoPrincipal;
    private List<FuncionEvento> funciones;

    public ObraTeatro() {
        this.funciones = new ArrayList<>();
    }

    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 48 horas antes del evento con reembolso del 80%";
    }

    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("Platea", 50.0);
        precios.put("Balcón", 30.0);
        precios.put("VIP", 80.0);
        return precios;
    }

    public void agregarFuncion(FuncionEvento funcion) {
        funciones.add(funcion);
    }

    public List<FuncionEvento> obtenerFuncionesDisponibles() {
        return new ArrayList<>(funciones);
    }

    public String getDirector() { return director; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public String getElencoPrincipal() { return elencoPrincipal; }

    public void setDirector(String director) { this.director = director; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public void setElencoPrincipal(String elencoPrincipal) { this.elencoPrincipal = elencoPrincipal; }
}