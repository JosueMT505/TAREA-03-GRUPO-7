package observer;

import java.util.*;

public class SistemaNotificaciones implements Observador {
    
    private List<CanalNotificacion> canales;

    public SistemaNotificaciones() {
        this.canales = new ArrayList<>(Arrays.asList(
            new EmailCanal(), 
            new SmsCanal(), 
            new PushCanal()
        ));
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Sistema de Notificaciones recibió: " + mensaje);
        for (CanalNotificacion canal : canales) {
            canal.enviar(mensaje);
        }
    }

    public List<CanalNotificacion> getCanales() { return canales; }
    public void setCanales(List<CanalNotificacion> canales) { this.canales = canales; }
}