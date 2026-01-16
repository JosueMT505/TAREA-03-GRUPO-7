package factory;

import java.util.*;
import observer.FuncionEvento;

public class Microteatro extends EventoBase {

    private int aforoMaximo;
    private String ubicacionEspecifica;
    private boolean interaccionPublico;

    private final List<FuncionEvento> funciones;

    public Microteatro() {
        this.funciones = new ArrayList<>();
    }

    public String calcularPoliticaCancelacion() {
        return "Cancelación permitida hasta 24 horas antes del evento con reembolso del 70%";
    }

    public Map<String, Double> obtenerConfiguracionPrecios() {
        Map<String, Double> precios = new HashMap<>();
        precios.put("General", 15.0);
        precios.put("Preferencial", 25.0);
        return precios;
    }

    public int getAforoMaximo() { return aforoMaximo; }
    public String getUbicacionEspecifica() { return ubicacionEspecifica; }
    public boolean isInteraccionPublico() { return interaccionPublico; }

    public void setAforoMaximo(int aforoMaximo) { this.aforoMaximo = aforoMaximo; }
    public void setUbicacionEspecifica(String ubicacionEspecifica) { this.ubicacionEspecifica = ubicacionEspecifica; }
    public void setInteraccionPublico(boolean interaccionPublico) { this.interaccionPublico = interaccionPublico; }

    public List<FuncionEvento> getFunciones() {
        return funciones;
    }
}