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

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        int semilla = args.length > 0 ? Integer.parseInt(args[0]) : 123; // TUS 3 DIGITOS

        double base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        String clasif;
        if (temp < 0) {
            clasif = "Congelante";
        } else if (temp < 10) {
            clasif = "Frio";
        } else if (temp < 20) {
            clasif = "Fresco";
        } else if (temp < 30) {
            clasif = "Templado";
        } else if (temp < 40) {
            clasif = "Caluroso";
        } else {
            clasif = "Peligroso";
        }

        String pc = InetAddress.getLocalHost().getHostName();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String msg = String.format(Locale.US, "Temperatura: %.1f °C\nClasificacion: %s\nComputadora: %s | Fecha: %s",
                temp, clasif, pc, fecha);
        JOptionPane.showMessageDialog(null, msg);
    }
}