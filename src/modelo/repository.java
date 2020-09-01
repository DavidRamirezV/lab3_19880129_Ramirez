package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class repository {
	private String rama;
	private String autor;
	private String fecha;
	static Scanner input = new Scanner(System.in); 

	LinkedList<archivo> Archivos;
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
    public void obtenerFecha(){
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date fecha = new Date();
        this.fecha = formato.format(fecha);
    }
    
    public static repository gitInit(){
	    repository rep = new repository();
	    System.out.println("Introduce el nombre del autor del repositorio:");
        rep.setAutor(input.nextLine());	        
        rep.obtenerFecha();      
        System.out.println("Introduce la rama actual:");
        rep.setRama(input.nextLine());	           
        return rep;      	
   }
	
	
	 
}
