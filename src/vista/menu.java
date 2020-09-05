package vista;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import modelo.*;

public class menu {
	//Sacanner sirve para recoger texto por consola
	static Scanner input = new Scanner(System.in); 
	static int seleccion = -1; //opción elegida del usuario
	static LinkedList<archivo> Archivos = new LinkedList<archivo>();
	static repository repositorio = new repository() {};
	
	public static void iniciarMenu() {
		
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
					System.out.println("Seleccionaste add, escribe \"all\" (sin comillas) para añadir todo o ");	
					System.out.println("ingresa el nombre de los archivos separados por una coma (sin espacios):");
					System.out.println("(Ej:\"all\" o \"archivo1.txt\" o \"archivo1.txt,archivo2.in,archivo3.out\")");	
					List<String> nombresArchivos = new ArrayList<String>(Arrays.asList(input.nextLine().split(",")));
					
					repositorio.setIndex(workspace.gitAdd(nombresArchivos, repositorio.getWorkspace()) );
					break;
					
				case 2: 
					//REPARAR!!!!!!!!!!!!!!
					System.out.println("Escribe un mensaje descriptivo para el commit: ");
					repositorio.setLocalRepository(index.gitCommit(input.nextLine(),repositorio));
					
					
					break;
					
				case 3: 
					System.out.println("Aqui va giPull");
					break;
					
				case 4: 
					System.out.println("Aqui va gitPush");
					break;
					
				case 5: 
					status.gitStatus(repositorio);
					break;
					
				case 6: 
					archivo auxiliar = archivo.crearArchivo();
					//para evitar que existan dos archivos con el mismo nombre
					//si se crea un archivo con un nombre que ya existe se reemplazara el anterior por el nuevo
					archivo.anadirArchivoLista(Archivos, auxiliar);
					printArchivos (Archivos);
					repositorio.setWorkspace(Archivos);
										
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
	
	
	 
	//prints
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
