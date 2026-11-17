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
public class Ejercicio5 {
    public static void main(String[] args) throws Exception {
        int semilla = args.length > 0 ? Integer.parseInt(args[0]) : 123;

        int mSemilla = 2 + (semilla % 19);
        int l = 5 + (semilla % 8);

        String salida = "";
        try {
            String entrada = JOptionPane.showInputDialog("Ingrese M (1-20):", String.valueOf(mSemilla));
            int m = Integer.parseInt(entrada.trim()); // puede lanzar NumberFormatException

            if (m < 1 || m > 20) {
                throw new Exception("Error: numero fuera de rango [1-20]");
            }

            salida += "Tabla del " + m + "\n";
            for (int i = 1; i <= l; i++) {
                salida += m + " x " + i + " = " + (m * i) + "\n";
            }
        } catch (NumberFormatException e) {
            salida += "Error: entrada no numerica\n";
        } catch (Exception e) {
            salida += e.getMessage() + "\n";
        } finally {
            salida += "Proceso finalizado\n";
            String pc = InetAddress.getLocalHost().getHostName();
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            salida += "Computadora: " + pc + " | Fecha: " + fecha;
            JOptionPane.showMessageDialog(null, salida);
        }
    }
}