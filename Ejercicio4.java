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
public class Ejercicio4 {
    public static void main(String[] args) throws Exception {
        int intentos = 0;
        boolean valida = false;

        do {
            String pass = JOptionPane.showInputDialog("Ingrese una contraseña:");
            if (pass == null) { // el usuario cerro o cancelo el cuadro
                return;
            }
            intentos++;

            boolean tieneDigito = false;
            boolean tieneMayuscula = false;
            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                if (c >= '0' && c <= '9') tieneDigito = true;
                if (c >= 'A' && c <= 'Z') tieneMayuscula = true;
            }

            if (pass.length() < 8) {
                JOptionPane.showMessageDialog(null, "Error: minimo 8 caracteres");
            } else if (!tieneDigito) {
                JOptionPane.showMessageDialog(null, "Error: debe tener al menos un digito");
            } else if (!tieneMayuscula) {
                JOptionPane.showMessageDialog(null, "Error: debe tener al menos una mayuscula");
            } else {
                valida = true;
            }
        } while (!valida);

        String pc = InetAddress.getLocalHost().getHostName();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        JOptionPane.showMessageDialog(null, "Contrasena aceptada\nIntentos realizados: " + intentos
                + "\nComputadora: " + pc + " | Fecha: " + fecha);
    }
}