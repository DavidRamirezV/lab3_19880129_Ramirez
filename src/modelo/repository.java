package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class repository {
	//atributos
	protected String rama;
	protected String autor;
	protected String nombreRep;
	protected String fecha;
	static Scanner input = new Scanner(System.in); 
	protected LinkedList<archivo> workspace;	
	protected LinkedList<archivo> index;
	protected LinkedList<commit> localRepository;
	protected LinkedList<commit> remoteRepository;
	
	//Getters y Setters
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
	public String getNombreRep() {
		return nombreRep;
	}
	public void setNombreRep(String nombreRep) {
		this.nombreRep = nombreRep;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setRama(String rama) {
		this.rama = rama;
	}	
	//Getters y setters zonas de trabajo
	public LinkedList<archivo> getWorkspace() {
		return workspace;
	}
	public void setWorkspace(LinkedList<archivo> workspace) {
		this.workspace = workspace;
	}
	public LinkedList<archivo> getIndex() {
		return index;
	}
	public void setIndex(LinkedList<archivo> index) {
		this.index = index;
	}
	public LinkedList<commit> getLocalRepository() {
		return localRepository;
	}
	public void setLocalRepository(LinkedList<commit> localRepository) {
		this.localRepository = localRepository;
	}
	public LinkedList<commit> getRemoteRepository() {
		return remoteRepository;
	}
	public void setRemoteRepository(LinkedList<commit> remoteRepository) {
		this.remoteRepository = remoteRepository;
	}

	//otros metodos
    public void obtenerFecha(){
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date fecha = new Date();
        this.fecha = formato.format(fecha);
    }
    
    public static repository gitInit(){
	    repository rep = new repository() {};
	    System.out.println("Introduce el nombre del autor del repositorio:");
        rep.setAutor(input.nextLine());	        
        rep.obtenerFecha();
        System.out.println("Introduce el nombre del repositorio:");
        rep.setNombreRep(input.nextLine());
        rep.setRama("master");	           
        rep.setWorkspace(null);
        rep.setIndex(null);
        rep.setLocalRepository(null);
        rep.setRemoteRepository(null);
       
        return rep;      	
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
