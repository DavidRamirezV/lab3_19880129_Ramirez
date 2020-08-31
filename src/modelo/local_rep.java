package modelo;

public class local_rep extends repository{
	private String comentario;
	private commit Commit;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public commit getCommit() {
		return Commit;
	}
	public void setCommit(commit commit) {
		Commit = commit;
	}
}
