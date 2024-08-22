package co.edu.konradlorenz.view;

import co.edu.konradlorenz.model.Vehiculo;
import java.util.Scanner;

public class Factura {
    private Scanner leer = new Scanner(System.in);

    public Vehiculo ingresarDatos() {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = leer.nextLine();

        System.out.print("Ingrese el tipo de vehículo (bicicleta/moto/carro): ");
        String tipoVehiculo = leer.nextLine();

        System.out.print("Ingrese la duración en horas: ");
        int duracion = leer.nextInt();
        leer.nextLine(); 

        return new Vehiculo(placa, tipoVehiculo, duracion);
    }

    public void mostrarFactura(Vehiculo vehiculo) {
        double iva = vehiculo.calcularIva();
        double valorTotal = vehiculo.calcularValorTotal();

        // dejar los numeros enteros, se usa el string format pero tambien se pudo usar  DecimalFormat
        String valorPagarStr = String.format("%.0f", vehiculo.getValorPagar());
        String ivaStr = String.format("%.0f", iva);
        String valorTotalStr = String.format("%.0f", valorTotal);

        System.out.println("----- FACTURA -----");
        System.out.println("Placa del vehículo: " + vehiculo.getPlaca());
        System.out.println("Tipo de vehículo: " + vehiculo.getTipoVehiculo());
        System.out.println("Duración: " + vehiculo.getDuracionHoras() + " horas");
        System.out.println("Valor a pagar sin IVA: " + valorPagarStr);
        System.out.println("IVA: " + ivaStr);
        System.out.println("Valor total a pagar: " + valorTotalStr);
        System.out.println("-------------------");
    }
}