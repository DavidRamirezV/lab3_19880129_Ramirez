package modelo;

import java.util.LinkedList;
import java.util.Scanner;

public class index extends repository{
	static Scanner input = new Scanner(System.in); 
	
	public static LinkedList<commit> gitCommit (String mensaje,repository rep){
		commit nuevoCommit = new commit();	
        LinkedList<archivo> archivosRepositorio = new LinkedList<archivo>();
     
        if (rep.getRemoteRepository() == null || rep.getRemoteRepository().size() == 0) {
        	archivosRepositorio = rep.getIndex();
        }
        
        else {
	        archivosRepositorio = rep.getRemoteRepository().getLast().getArchivosCommit();
	         for (int i=0;i < rep.getIndex().size();i++) {
				//para cada archivo del index se debe comparar si
		    	//este existe en el repositorio, 
		        //si existe se debe reemplazar
		        //si no existe se debe agregar
	        	archivo.anadirArchivoLista(archivosRepositorio, rep.getIndex().get(i));
				
	        }
	        
        }
        
        nuevoCommit.setComentario(mensaje);
        nuevoCommit.setArchivosCommit(archivosRepositorio);
 
        
        LinkedList<commit> retornoAllCommits = new LinkedList<commit>();
        if (rep.getLocalRepository() == null || rep.getLocalRepository().size() == 0) {
        	retornoAllCommits.add(nuevoCommit);
            
        }
        else {
        	retornoAllCommits = rep.getLocalRepository();
        	retornoAllCommits.add(nuevoCommit);
        }
        return retornoAllCommits;
	}
	
}
