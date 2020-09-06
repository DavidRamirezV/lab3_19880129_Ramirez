package vista;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import modelo.*;

public class Menu {
	//Sacanner sirve para recoger texto por consola
	static Scanner input = new Scanner(System.in); 
	static int seleccion = -1; //opción elegida del usuario
	static LinkedList<Archivo> Archivos = new LinkedList<Archivo>();
	static Repository repositorio = new Repository() {};
	
	public static void iniciarMenu() {
		
		repositorio = Repository.gitInit();
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(seleccion != 7){
			//Try catch para evitar que el programa termine si hay un error
			try{
				
				System.out.println(
						"### SIMULACIÓN DE GIT ###\r\n" +
						"1. add\r\n" + 
						"2. commit\r\n" + 
						"3. push\r\n" + 
						"4. pull\r\n" + 
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
					
					repositorio.setIndex(Workspace.gitAdd(nombresArchivos, repositorio.getWorkspace()) );
					break;
					
				case 2: 
					System.out.println("Escribe un mensaje descriptivo para el commit: ");
					repositorio.setLocalRepository(Index.gitCommit(input.nextLine(),repositorio));
					repositorio.setIndex(null);
					break;
					
				case 3: 
					repositorio.setRemoteRepository(LocalRepository.gitPush(repositorio));
					break;
					
				case 4: 
					System.out.println("Aqui va gitPull");
					break;
					
				case 5: 
					Status.gitStatus(repositorio);
					break;
					
				case 6: 
					Archivo auxiliar = Archivo.crearArchivo();
					//para evitar que existan dos archivos con el mismo nombre
					//si se crea un archivo con un nombre que ya existe se reemplazara el anterior por el nuevo
					Archivo.anadirArchivoLista(Archivos, auxiliar);
					printArchivos (Archivos);
					repositorio.setWorkspace(Archivos);
					break;
										
				case 7: 
					System.out.println("Finalizado");
					break;
					
				default:
					System.out.println("Número no reconocido");
					break;
				}
				
			}catch(Exception s){
				System.out.println("Ingresa un número");
			}
			
		}

	}
	
	
	 
	//prints
	   public static void printArchivos (LinkedList<Archivo> Lista) {
		   
		   for(int i=0;i < Lista.size();i++) {
			    System.out.println("\r\n------------------------------------");
			    System.out.println(Lista.get(i).getNombre());
				System.out.println(Lista.get(i).getFecha());
				System.out.println(Lista.get(i).getContenido().toString());
		   }
		   System.out.println("------------------------------------\r\n");
	   }
	    

}
