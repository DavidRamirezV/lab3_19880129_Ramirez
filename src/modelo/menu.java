package modelo;

import java.util.Scanner;
import java.util.LinkedList;

public class menu {
	//Sacanner sirve para recoger texto por consola
	static Scanner input = new Scanner(System.in); 
	static int seleccion = -1; //opción elegida del usuario
	static LinkedList<archivo> Archivos = new LinkedList<archivo>();
	static repository repositorio = new repository();
	
	public static void main(String[] args) {
		
		repositorio = repository.gitInit();
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
					Archivos.add (archivo.crearArchivo());
					printArchivos (Archivos);
										
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
	
	
	 
	   
	   public static void printArchivos (LinkedList<archivo> Lista) {
		   
		   for(int i=0;i < Lista.size();i++) {
			    System.out.println("\r\n------------------------------------");
			    System.out.println(Lista.get(i).getNombre());
				System.out.println(Lista.get(i).getFecha());
				System.out.println(Lista.get(i).getContenido().toString());
		   }
		   System.out.println("------------------------------------\r\n");
	   }
	    

}
