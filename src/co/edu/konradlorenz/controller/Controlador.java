package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.Vehiculo;
import co.edu.konradlorenz.view.Factura;

public class Controlador {
	public void run() {
        Factura vista = new Factura(); 
        Vehiculo vehiculo = vista.ingresarDatos(); // Solicitar datos al usuario y crear un Vehiculo

        vista.mostrarFactura(vehiculo); // Mostrar la factura pasando el objeto Vehiculo
    }
}
