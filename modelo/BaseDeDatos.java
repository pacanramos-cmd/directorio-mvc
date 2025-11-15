package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
        productos.add(new Producto("Laptop Pro", "P001", 10, 1200.50));
        productos.add(new Producto("Mouse Inalámbrico", "M002", 50, 25.99));
    }

    /**
     * Agrega un producto a la lista.
     */
    public boolean agregarProducto(Producto producto) {
        if (producto == null) return false;
        return productos.add(producto);
    }

    /**
     * Busca un producto por ID.
     */
    public Producto buscarProductoId(String id) {
        if (id == null || id.isEmpty()) return null;

        return productos.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(String id) {
        Producto producto = buscarProductoId(id);
        if (producto != null) {
            return productos.remove(producto);
        }
        return false;
    }
}