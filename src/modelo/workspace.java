package modelo;

import java.util.LinkedList;
import java.util.List;

public class workspace extends repository{
	
	public static LinkedList<archivo> gitAdd (List<String> nombreArchivos, LinkedList<archivo> workspace) {
		LinkedList<archivo> coincidencias= new LinkedList<archivo>() ; 
		
		//si se quiere agregar todo (all)
		if (nombreArchivos.isEmpty()) {
			for(int i=0;i < workspace.size();i++) {
				coincidencias.add(workspace.get(i));		
			}
		}
		//si la lista no esta vacia agregar la lista de nombres entregados
		else {		
			for(int i=0;i < nombreArchivos.size();i++) {
				for(int j=0;i < workspace.size();j++) {
				    if (nombreArchivos.get(i).equals(workspace.get(j).getNombre())) {
				    	coincidencias.add(workspace.get(j));
				    }
				}
			}				
		}
		return coincidencias;
	}
	
	
}
