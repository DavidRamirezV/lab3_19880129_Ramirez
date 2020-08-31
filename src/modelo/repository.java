package modelo;

import java.util.LinkedList;

public class repository {
	private String rama;
	private String autor;
	private String fecha;
	
	LinkedList<archivo> Workspace;
	LinkedList<commit> RemoteRepository;
	
	public String getRama() {
		return rama;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setRama(String rama) {
		this.rama = rama;
	}
	
	/*
	 LinkedList<String> ll 
     = new LinkedList<String>(); 
	
	 // Adding elements to the linked list 
	 ll.add("A"); 
	 ll.add("B"); 
	 ll.addLast("C"); 
	 ll.addFirst("D"); 
	 ll.add(2, "E"); 
	
	 System.out.println(ll); 
	// Removing elements to the linked list 
	 ll.remove("B"); 
	 ll.remove(3); 
	 ll.removeFirst(); 
	 ll.removeLast(); 
	
*/
	 
}
