package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public class ManejadorProxy implements Manejador {
	
	MapeadorDatos md;
	ManejadorImpl manejador;
	
	public ManejadorProxy(MapeadorDatos md) {
		
		this.md = md;
		this.manejador = new ManejadorImpl(md);


	}

	@Override
	public String[] dameDatos() {
		
		return this.manejador.dameDatos();
	}

	@Override
	public boolean agrega(String dato) {
		
		return this.manejador.agrega(dato);
	}

	@Override
	public boolean borra(String dato) {
		
		return this.manejador.borra(dato);
	}

	@Override
	public void finaliza() {
		this.manejador.finaliza();
		
	}

	@Override
	public boolean agregaObservador(Observador o) {
		
		System.out.println("Se invocó el método agregaObservador(Observador o)");
		
	    return this.manejador.agregaObservador(o);

	}

	@Override
	public boolean quitaObservador(Observador o) {
		
		return this.manejador.quitaObservador(o);
	}

}
