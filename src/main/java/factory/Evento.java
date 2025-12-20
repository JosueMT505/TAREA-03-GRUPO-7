package factory;

import java.util.*;
import observer.FuncionEvento;

public interface Evento {
    String getId();
    String getTitulo();
    String getDescripcion();
    String calcularPoliticaCancelacion();
    Map<String, Double> obtenerConfiguracionPrecios();
    void agregarFuncion(FuncionEvento funcion);
    List<FuncionEvento> obtenerFuncionesDisponibles();

    void setId(String id);
    void setTitulo(String titulo);
    void setDescripcion(String descripcion);
}
