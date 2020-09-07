package modelo;

import java.util.LinkedList;

/**
 * TDA que representa un commit, este posee un String comentario que indica un mensaje breve que debe representar
 * los cambios en agregados o eliminados en los archivos y una lista enlazada de de la clase archivos que representa
 * los archivos actuales en el commit.
 * @author David Ramirez
 *
 */
public class Commit {
	//ATRIBUTOS
	public String comentario;
	private LinkedList<Archivo> archivosCommit;
	
	//Getters y Setters
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LinkedList<Archivo> getArchivosCommit() {
		return archivosCommit;
	}

	public void setArchivosCommit(LinkedList<Archivo> archivosCommit) {
		this.archivosCommit = archivosCommit;
	}
	
	//METODOS
	//Constructor
	/**
	 * Constructor de la clase Commit.
	 */
	public Commit() {
	}
	
	/**
	 * Constructor de la clase Commit.
	 * @param comentario - String que representa un pequeño mensaje del usuario
	 * @param archivosCommit - Lista enlazada de Archivos
	 */
	public Commit(String comentario,LinkedList<Archivo> archivosCommit ){
		this.comentario = comentario;
		this.archivosCommit = archivosCommit;
	}
	
	
	/** 
	 * Metodo que compara si dos listas enlazadas con elementos del tipo Commit son exactamente iguales.
	 * @param L1 - Lista enlazada de Commits
	 * @param L2 - Lista enlazada de Commits
	 * @return true si ambas listas poseen los mismos elementos, false si ambas listas son distintas 
	 */
	public static boolean listasIguales (LinkedList<Commit> L1, LinkedList<Commit> L2) {
		if (L1 == null && L2 == null) {
			return true;
		}	
		else if (L1 == null && L2 != null || L1 != null && L2 == null || L1.size() != L2.size() ) {
			return false;
		}
		
		return (L1.containsAll(L2) && L2.containsAll(L1));
	}

	
}
