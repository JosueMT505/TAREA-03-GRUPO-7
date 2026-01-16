package composite;

public class Ubicacion {
    private final SeccionTeatro seccion;
    private final String fila;
    private final int numero;

    public Ubicacion(SeccionTeatro seccion, String fila, int numero) {
        this.seccion = seccion;
        this.fila = fila;
        this.numero = numero;
    }

    public SeccionTeatro seccion() {
        return seccion;
    }

    public String fila() {
        return fila;
    }

    public int numero() {
        return numero;
    }

    @Override
    public String toString() {
        return String.format("%s (Fila: %s, Núm: %d)", seccion, fila, numero);
    }
}