import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: [joel ayarza]
 * Fecha: [11-16-2026]
 */
public class Ejercicio3 {
    public static void main(String[] args) throws Exception {
        int semilla = args.length > 0 ? Integer.parseInt(args[0]) : 123;

        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        int i = 1;
        int suma = 0;
        String serie = "";
        while (i <= n) {
            int multiplo = i * k;
            suma += multiplo;
            serie += multiplo;
            if (i < n) {
                serie += ", ";
            }
            i++;
        }

        String pc = InetAddress.getLocalHost().getHostName();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String msg = "Serie: " + serie + " (" + n + " terminos)\nSuma total: " + suma
                + "\nComputadora: " + pc + " | Fecha: " + fecha;
        JOptionPane.showMessageDialog(null, msg);
    }
}