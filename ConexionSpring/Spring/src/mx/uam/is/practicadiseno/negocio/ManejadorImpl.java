package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.datos.MapeadorDatosImpl;


public class ManejadorImpl implements Manejador {

	// La estructura que contiene los datos
	
	private MapeadorDatos md;
	private ArrayList<Observador> Observadores;

	/**
	 * Constructor que inicializa con algunos datos
	 *
	 */
	public ManejadorImpl(MapeadorDatos md) {
		
		this.md = md;
		this.Observadores = new ArrayList <Observador>();

	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		return(md.dameDatos());
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato) {
		boolean res;
		res = md.agrega(dato);
		this.notifica();
		return res;
	}

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato) {
		boolean res;
		res = md.borra(dato);
		this.notifica();
		return res;
	}

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}
	
	public boolean agregaObservador(Observador o) {
		return this.Observadores.add(o);
	}

	public boolean quitaObservador(Observador o) {
		return this.Observadores.remove(o);
	}

	private void notifica() {
		for (int i =0; i < this.Observadores.size();i++) {
			this.Observadores.get(i).actualiza();
		}
		
	}

}
