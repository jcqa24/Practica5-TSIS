package mx.uam.is.practicadiseno;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;
import mx.uam.is.practicadiseno.negocio.ManejadorImpl;
import mx.uam.is.practicadiseno.vista.Ventana;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// Carga el application context
		ClassPathXmlApplicationContext applicationContex = new ClassPathXmlApplicationContext("mx/uam/is/practicadiseno/applicationContext.xml");
		
		
		
		// Agregamos los observadores
		
		Ventana ventana = (Ventana) applicationContex.getBean("ventana1",Ventana.class);
		Ventana ventana2 = (Ventana) applicationContex.getBean("ventana2",Ventana.class);
		Ventana ventana3 = (Ventana) applicationContex.getBean("ventana3",Ventana.class);
		
		ventana.manejador.agregaObservador(ventana2);
		ventana.manejador.agregaObservador(ventana3);
		ventana2.manejador.agregaObservador(ventana);
		ventana2.manejador.agregaObservador(ventana3);
		ventana3.manejador.agregaObservador(ventana);
		ventana3.manejador.agregaObservador(ventana2);
		
	
	}

}
