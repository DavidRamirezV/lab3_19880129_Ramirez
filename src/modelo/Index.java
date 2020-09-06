package modelo;

import java.util.LinkedList;

public class Index extends Repository{
		
		
	public static LinkedList<Commit> gitCommit (String mensaje,Repository rep){
		//creo la lista de archivos
        LinkedList<Archivo> archivosRepositorio = new LinkedList<Archivo>();
        
        if (rep.getRemoteRepository() == null || rep.getRemoteRepository().size() == 0 ) {
        	for (int i = 0; i< rep.getIndex().size();i++) {
        		System.out.println("anadir o reemplazar " + rep.getIndex().get(i).getNombre());
        		Archivo.anadirArchivoLista(archivosRepositorio, rep.getIndex().get(i));
        	}        	
        	System.out.println("########IF");
        }
        
        else {
        	System.out.println("########ELSE");
        	for (int i=0; i<rep.getRemoteRepository().getLast().getArchivosCommit().size();i++) {
        		archivosRepositorio.add(rep.getRemoteRepository().getLast().getArchivosCommit().get(i));
        		System.out.println("anadir " + rep.getRemoteRepository().getLast().getArchivosCommit().get(i).getNombre());
        	}
        	for (int i = 0; i< rep.getIndex().size();i++) {
        		System.out.println("anadir o reemplazar" + rep.getIndex().get(i).getNombre());
        		Archivo.anadirArchivoLista(archivosRepositorio, rep.getIndex().get(i));
        	}
        }
        
        System.out.println("ARCHIVOS ANTES DE AGREGAR AL COMMIT:");
        for (int i=0 ;i < archivosRepositorio.size();i++ ) {
        	System.out.println(archivosRepositorio.get(i).getNombre());
        }

        
        Commit nuevoCommit = new Commit(mensaje,archivosRepositorio);
        System.out.println("MENSAJE:" + nuevoCommit.getComentario());
        System.out.println("IMPRIMIR LISTA DE ARCHIVOS EN EL COMMIT:");
        for (int i=0 ;i < archivosRepositorio.size();i++ ) {
        	System.out.println(nuevoCommit.getArchivosCommit().get(i).getNombre());
        }
        
        LinkedList<Commit> nuevoLocal = new LinkedList<Commit>();
        if(rep.getLocalRepository() == null || rep.getLocalRepository().size() == 0){
        	nuevoLocal.add(nuevoCommit);	    	
	    }
        else {
        	 nuevoLocal.addAll(rep.getLocalRepository());
             nuevoLocal.add(nuevoCommit);
        }
        System.out.println("vvvvvvvv todo ok vvvvvvvvv");
        return nuevoLocal;
        
	}
	
}
