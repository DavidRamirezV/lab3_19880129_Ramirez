package modelo;

public class RemoteRepository extends Repository {
	private String comentario;
	private Commit Commit;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Commit getCommit() {
		return Commit;
	}
	public void setCommit(Commit commit) {
		Commit = commit;
	}
}
