package modelo;

import java.util.LinkedList;

public class Commit {
	public String comentario;
	private LinkedList<Archivo> archivosCommit;
	
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
	
	public Commit() {
	}
	public Commit(String comentario,LinkedList<Archivo> archivosCommit ){
		this.comentario = comentario;
		this.archivosCommit = archivosCommit;
	}
	
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
