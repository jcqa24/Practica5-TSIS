package mx.uam.is.practicadiseno;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;
import mx.uam.is.practicadiseno.negocio.ManejadorImpl;
import mx.uam.is.practicadiseno.vista.Ventana;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Crea el mapedor de datos
		MapeadorDatos mapeador = new MapeadorDatosImpl();

		// Crea el manejador

		ManejadorImpl manejador = new ManejadorImpl(mapeador);
		//ManejadorImpl manejador = new ManejadorImpl();

		// Crea la ventana y le pasa referencia
		Ventana ventana = new Ventana(manejador);
		Ventana ventana2 = new Ventana(manejador);
		Ventana ventana3 = new Ventana(manejador);
		
		ventana.manejador.agregaObservador(ventana2);
		ventana.manejador.agregaObservador(ventana3);
		ventana2.manejador.agregaObservador(ventana);
		ventana2.manejador.agregaObservador(ventana3);
		ventana3.manejador.agregaObservador(ventana);
		ventana3.manejador.agregaObservador(ventana2);
		

		// Muestra la ventana arrancando asi el programa
		ventana.setVisible(true);
		ventana2.setVisible(true);
		ventana3.setVisible(true);
	}

}
