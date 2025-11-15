package vista;


import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {
    
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    // ... (mostrarMenu sin cambios) ...

    /** NUEVO: Solo pide el nombre (primer paso del flujo). */
    public String pedirNombreProducto() {
        System.out.println("\n--- Ingrese datos del Producto ---");
        System.out.print("1. Ingrese Nombre: ");
        return scanner.nextLine();
    }
    
    /** MODIFICADO: Pide Cantidad y Precio, y devuelve un objeto Producto temporal. */
    public Producto pedirDatosRestantes(int idAsignado, String nombre) {
        
        System.out.print("3. Ingrese Cantidad (Unidad): ");
        while (!scanner.hasNextInt()) {
            mostrarMensaje("Entrada invalida. Ingrese un numero entero para la cantidad.");
            scanner.next(); 
            System.out.print("3. Ingrese Cantidad (Unidad): ");
        }
        int cantidad = scanner.nextInt();
        
        System.out.print("4. Ingrese Precio Por unidad : ");
        while (!scanner.hasNextDouble()) {
            mostrarMensaje("Entrada invalida. Ingrese un numero decimal para el precio.");
            scanner.next(); 
            System.out.print("4. Ingrese Precio por Unidad (Decimal): ");
        }
        double precio = scanner.nextDouble();
        scanner.nextLine();

        // Se crea el producto con el ID y Nombre validados/recibidos
        return new Producto(idAsignado, nombre, cantidad, precio);
    }

    /** MODIFICADO: Se renombra y es la clave para todas las búsquedas, eliminaciones y actualizaciones. */
    public int solicitarId() {
        System.out.print("2. Ingrese ID (Numero unico): ");
        while (!scanner.hasNextInt()) {
            mostrarMensaje("Entrada invalida. Ingrese un numero entero para el ID.");
            scanner.next();
            System.out.print("2. Ingrese ID (Número unico): ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
    
    // ... (El resto de métodos sin cambios) ...

    public int mostrarMenu() {
        System.out.println("\n===== Sistema de Gestion de Inventario (MVC) =====");
        System.out.println("  ");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar un producto por ID"); 
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto por ID");
        System.out.println("5. Actualizar un producto por ID"); 
        System.out.println("6. Salir"); 
        System.out.print("Seleccione una opcion: ");

        while (!scanner.hasNextInt()) {
            mostrarMensaje("Entrada invalida. Por favor, ingrese un número del 1 al 6.");
            scanner.next(); 
            System.out.print("Seleccione una opcion: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public Producto pedirDatosParaActualizar(int idAsignado) {
        System.out.println("\n--- Ingrese Nuevos datos para el ID " + idAsignado + " ---");
        // Reutilizamos la lógica pidiendo el nombre y luego los demás datos
        String nombre = pedirNombreProducto();
        return pedirDatosRestantes(idAsignado, nombre);
    }
    
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("\n--- Producto Encontrado ---");
            System.out.println(producto.toString());
        } else {
            System.out.println("\n--- Producto no encontrado. ---");
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- Lista Completa de Productos (ID Asignado por Usuario) ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
        System.out.println("-----------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}