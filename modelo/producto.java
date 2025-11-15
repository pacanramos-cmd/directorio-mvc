package modelo;

public class Producto {
    
    private String nombre;
    private String id;
    private int cantidad;
    private double precio;

    public Producto(String nombre, String id, int cantidad, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setId(String id) { this.id = id; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format(
            "ID: %-10s | Nombre: %-20s | Cantidad: %-5d | Precio: $%.2f",
            id, nombre, cantidad, precio
        );
    }
}
