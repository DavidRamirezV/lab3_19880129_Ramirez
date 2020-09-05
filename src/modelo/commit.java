package modelo;

import java.util.LinkedList;

public class commit {
	public String comentario;
	private LinkedList<archivo> archivosCommit;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LinkedList<archivo> getArchivosCommit() {
		return archivosCommit;
	}

	public void setArchivosCommit(LinkedList<archivo> archivosCommit) {
		this.archivosCommit = archivosCommit;
	}


	
}
