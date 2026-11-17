import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: [joel ayarza]
 * Fecha: [11-16-2026]
 */
public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        int semilla = args.length > 0 ? Integer.parseInt(args[0]) : 123;

        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        int descuentoPct;
        switch (codigo) {
            case 1: descuentoPct = 10; break; // Electronica
            case 2: descuentoPct = 15; break; // Ropa
            case 3: descuentoPct = 5;  break; // Alimentos
            case 4: descuentoPct = 20; break; // Muebles
            default: descuentoPct = 0;        // No aplica
        }

        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        String pc = InetAddress.getLocalHost().getHostName();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String msg = String.format(Locale.US,
                "Precio original : $ %.2f\nDescuento (%d%%) : $ %.2f\nPrecio final    : $ %.2f\nComputadora: %s | Fecha: %s",
                precio, descuentoPct, descuentoMonto, precioFinal, pc, fecha);
        JOptionPane.showMessageDialog(null, msg);
    }
}