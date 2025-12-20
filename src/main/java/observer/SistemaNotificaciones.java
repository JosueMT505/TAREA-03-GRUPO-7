package observer;

import java.util.*;

public class SistemaNotificaciones implements Observador {
    private List<String> canales;

    public SistemaNotificaciones() {
        this.canales = Arrays.asList("email", "sms", "push");
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Sistema de Notificaciones recibió: " + mensaje);
        for (String canal : canales) {
            enviarPorCanal(canal, mensaje);
        }
    }

    private void enviarPorCanal(String canal, String mensaje) {
        switch (canal.toLowerCase()) {
            case "email":
                enviarEmail("todos@clientes.com", mensaje);
                break;
            case "sms":
                enviarSMS("+593XXXXXXXXX", mensaje);
                break;
            case "push":
                enviarPush("todos", mensaje);
                break;
        }
    }

    public void enviarEmail(String destinatario, String mensaje) {
        System.out.println("Enviando email a " + destinatario + ": " + mensaje);
    }

    public void enviarSMS(String telefono, String mensaje) {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
    }

    public void enviarPush(String usuarioId, String mensaje) {
        System.out.println("Enviando push a usuario " + usuarioId + ": " + mensaje);
    }

    // Getters y Setters
    public List<String> getCanales() { return canales; }
    public void setCanales(List<String> canales) { this.canales = canales; }
}