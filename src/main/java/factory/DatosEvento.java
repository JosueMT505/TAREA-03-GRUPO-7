package factory;

import java.util.Date;


public class DatosEvento {
    private String titulo;
    private Date fecha;
    private String descripcion;

    public DatosEvento(String titulo, Date fecha, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
