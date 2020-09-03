package modelo;

import java.util.LinkedList;

public class commit {
	public String comentario;
	private String contenido;
	private LinkedList<archivo> archivosCommit;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LinkedList<archivo> getArchivosCommit() {
		return archivosCommit;
	}

	public void setArchivosCommit(LinkedList<archivo> archivosCommit) {
		this.archivosCommit = archivosCommit;
	}


	
}
