package modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class archivo {
	//modulo de atributos
	private String nombre;	
	private String fecha;	
	private String contenido;
	static Scanner input = new Scanner(System.in); 
	
	
	//Getters y Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
	//Funciones
    public void obtenerFecha(){
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date fecha = new Date();
        this.fecha = formato.format(fecha);
    }
       
    public static archivo crearArchivo(){
	    archivo a1 = new archivo();
	    System.out.println("Introduce el nombre del archivo:");
        a1.setNombre(input.nextLine());	        
        a1.obtenerFecha();	        
        System.out.println("Introduce el contenido:");
        a1.setContenido(input.nextLine());	           
        return a1;
        	
   }
    
    //sobrescribir un archivo en una lista
    public static void anadirArchivoLista(LinkedList<archivo> Archivos, archivo auxiliar) {
		if (Archivos.size()==0) {
			Archivos.add (auxiliar);
		}
		
		else {
			for(int i=0;i < Archivos.size();i++) {
				if (auxiliar.getNombre().equals(Archivos.get(i).getNombre())) {
					System.out.println("estoy en el if");
					Archivos.set(i,auxiliar);
					break;
					
			    }
				else if (i+1 == Archivos.size()) {
					System.out.println("estoy en else if");
					Archivos.add (auxiliar);
					break;
					
				}
					
			}
		}
		
    }
    
}



