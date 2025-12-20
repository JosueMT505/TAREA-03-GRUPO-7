package observer;

import sistema.Usuario;
import java.util.List;

public class UsuarioObservador implements Observador {
    private Usuario usuario;
    private List<String> preferenciasNotificacion;

    public UsuarioObservador(Usuario usuario) {
        this.usuario = usuario;
        this.preferenciasNotificacion = usuario.getPreferencias();
    }

    @Override
    public void actualizar(String mensaje) {
        if (filtrarNotificacion(mensaje)) {
            usuario.recibirNotificacion(mensaje);
        }
    }

    public boolean filtrarNotificacion(String mensaje) {
        if (preferenciasNotificacion.isEmpty()) {
            return true;
        }

        for (String preferencia : preferenciasNotificacion) {
            if (mensaje.toLowerCase().contains(preferencia.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public Usuario getUsuario() { return usuario; }
    public List<String> getPreferenciasNotificacion() { return preferenciasNotificacion; }
}