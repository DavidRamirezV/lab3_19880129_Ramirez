package modelo;

import java.util.LinkedList;
import java.util.List;

public class Workspace extends Repository{
	
	public static LinkedList<Archivo> gitAdd (List<String> nombreArchivos, LinkedList<Archivo> workspace) {
		LinkedList<Archivo> coincidencias= new LinkedList<Archivo>() ; 
		
		//si se quiere agregar todo (all)
		if (nombreArchivos.get(0).equals("all")) {
			for(int i=0;i < workspace.size();i++) {
				coincidencias.add(workspace.get(i));		
			}
		}
		//si la lista no esta vacia agregar la lista de nombres entregados
		else {		
			for(int i=0;i < nombreArchivos.size();i++) {
				for(int j=0;j < workspace.size();j++) {
				    if (nombreArchivos.get(i).equals(workspace.get(j).getNombre())) {
				    	coincidencias.add(workspace.get(j));
				    }
				}
			}				
		}
		return coincidencias;
	}
	
	
}
