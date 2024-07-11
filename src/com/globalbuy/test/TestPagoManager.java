package test;

import com.globalbuy.pagos.PagoManager;

public class TestPagoManager {

    public static void main(String[] args) {
        PagoManager pagoManager = new PagoManager();

        // Prueba del método procesarPago
        boolean pagoExitoso = pagoManager.procesarPago(100.0, "Tarjeta de crédito");
        if (pagoExitoso) {
            System.out.println("Pago procesado exitosamente.");
        } else {
            System.out.println("Error al procesar el pago.");
        }

        // Prueba del método verificarPago
        boolean pagoVerificado = pagoManager.verificarPago(12345);
        if (pagoVerificado) {
            System.out.println("Pago verificado exitosamente.");
        } else {
            System.out.println("Error al verificar el pago.");
        }

        // Ejemplo de generación de recibo
        pagoManager.generarRecibo(12345);
    }
}
