package mx.uam.is.practicadiseno.datos;

import java.util.ArrayList;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos {

	private List <String> datos = new ArrayList <String> ();
	
	
	public MapeadorDatosImpl() {
		datos.add("Entrada 1");
		datos.add("Entrada 2");
		datos.add("Entrada 3");
	}
	
	
	public boolean agrega(String dato) {
		if(!dato.equals("") && !datos.contains(dato)) {
			datos.add(dato);
			return true;
		}
		return false;
	}

	@Override
	public boolean borra(String dato) {
		return datos.remove(dato);
	}

	@Override
	public String[] dameDatos() {
		// Convierte la lista a un arreglo de cadenas y lo regresa
				String arregloDatos [] = new String[datos.size()];
				datos.toArray(arregloDatos);
				return arregloDatos;
	}

	@Override
	public boolean contiene(String dato) {
		return datos.contains(dato);
		
	}

}
