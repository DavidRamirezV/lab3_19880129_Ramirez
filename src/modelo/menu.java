package modelo;

import java.util.Scanner;

public class menu {
	//Sacanner sirve para recoger texto por consola
	static Scanner input = new Scanner(System.in); 
	static int seleccion = -1; //opción elegida del usuario
	static archivo Archivo;
	
	
	public static void main(String[] args) {
		
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(seleccion != 7){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println(
						"### SIMULACIÓN DE GIT ###\r\n" +
						"1. add\r\n" + 
						"2. commit\r\n" + 
						"3. pull\r\n" + 
						"4. push\r\n" + 
						"5. status\r\n" + 
						"6. Crear nuevo archivo \r\n" +
						"7. Salir \r\n" + 
						"INTRODUZCA SU OPCIÓN: ");
				//Obtener un numero por consola como integer
				seleccion = Integer.parseInt(input.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(seleccion){
				
				case 1: 
					System.out.println("Aqui va gitAdd");
					break;
					
				case 2: 
					System.out.println("Aqui va giCommit");
					break;
					
				case 3: 
					System.out.println("Aqui va giPull");
					break;
					
				case 4: 
					System.out.println("Aqui va gitPush");
					break;
					
				case 5: 
					System.out.println("Aqui va status");
					break;
					
				case 6: 
					Archivo = crearArchivo();
					System.out.println(Archivo.getNombre());
					System.out.println(Archivo.getFecha());
					System.out.println(Archivo.getContenido());
			        System.out.println("\r\n"); 
					
					
					break;
					
				case 7: 
					System.out.println("Finalizado");
					break;
					
				default:
					System.out.println("Número no reconocido");break;
				}
				
			}catch(Exception s){
				System.out.println("Ingresa un número");
			}
			
		}

	}
	
	
	   public static archivo crearArchivo(){
		    archivo a1 = new archivo();
		    System.out.println("Introduce el nombre del archivo:");
	        a1.setNombre(input.nextLine());	        
	        a1.obtenerFecha();	        
	        System.out.println("Introduce el contenido (usar saltos de linea):");
	        a1.setContenido(input.nextLine());
	           
	        return a1;
	   }
	    

}
