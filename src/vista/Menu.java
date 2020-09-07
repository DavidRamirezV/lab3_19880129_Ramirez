package vista;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import modelo.*;

/** Esta clase representa una interfaz por consola que permite al usuario
 * interactuar con el resto del codigo.
 * @author David Ramirez
 *
 */
public class Menu {
	//Scanner sirve para recoger texto por consola
	static Scanner input = new Scanner(System.in); 
	static int seleccion = -1; //opci�n elegida del usuario
	static LinkedList<Archivo> Archivos = new LinkedList<Archivo>();
	static Repository repositorio = new Repository() {};
	
	
	/**
	 * Este metodo se encarga de inicializar el repositorio 
	 * y de mostrar al usuario metodos para poder interactuar con el codigo
	 * consultandole al usuario �que es lo que desea hacer? y consultando
	 * los parametros que se necesiten para utilizar ciertos metodos.
	 */
	public static void iniciarMenu() {

	    System.out.println("Introduce el nombre del autor del repositorio:");
	    String autor = input.nextLine();
        System.out.println("Introduce el nombre del repositorio:");
        String nombreRepositorio = input.nextLine();        
		repositorio = Repository.gitInit(autor,nombreRepositorio);
		
		//Mientras la opci�n elegida sea 0, preguntamos al usuario
		while(seleccion != 7){
			//Try catch para evitar que el programa termine si hay un error
			try{
				
				System.out.println(
						"### SIMULACI�N DE GIT ###\r\n" +
						"1. add\r\n" + 
						"2. commit\r\n" + 
						"3. push\r\n" + 
						"4. pull\r\n" + 
						"5. status\r\n" + 
						"6. Crear nuevo archivo \r\n" +
						"7. Salir \r\n" + 
						"INTRODUZCA SU OPCI�N: ");
				//Obtener un numero por consola como integer
				seleccion = Integer.parseInt(input.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(seleccion){
				
				case 1:
					System.out.println("Seleccionaste add, escribe \"all\" (sin comillas) para a�adir todo o ");	
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
					System.out.println("Se ha realizado un Push");
					break;
					
				case 4: 
					repositorio.setWorkspace(RemoteRepository.gitPull(repositorio));
					Archivos.clear();
					Archivos.addAll(repositorio.getWorkspace());
					System.out.println("Se ha realizado un Pull");
					break;
					
				case 5: 
					Status.gitStatus(repositorio);
					break;
					
				case 6: 
									
					System.out.println("Introduce el nombre del archivo:");
					String nombre = input.nextLine();
					System.out.println("Introduce el contenido:");
					String contenido = input.nextLine();
					
					Archivo auxiliar =  new Archivo(nombre,contenido);
					//para evitar que existan dos archivos con el mismo nombre
					//si se crea un archivo con un nombre que ya existe se reemplazara el anterior por el nuevo					
					Archivo.anadirArchivoLista(Archivos, auxiliar);					
					repositorio.setWorkspace(Archivos);					
					printArchivos (repositorio.getWorkspace());
					break;
										
				case 7: 
					System.out.println("Finalizado");
					input.close();
					break;
					
				default:
					System.out.println("N�mero no reconocido");
					break;
				}
				
			}catch(Exception s){
				System.out.println("Ingresa un n�mero");
			}
			
		}

	}
	
	
	 
	
	/**
	 * Imprime una Lista de Archivos por pantalla.
	 * @param Lista - Lista de clases Archivo
	 */
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
