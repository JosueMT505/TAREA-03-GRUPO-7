package composite;

import sistema.Usuario;

public interface ComponenteAsiento {
    String getId();
    double getPrecio();
    EstadoAsiento getEstado();
    String getUbicacion();
    boolean reservar(Usuario usuario);
    void liberar();
    boolean esDisponible();
}
