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
	static int seleccion = -1; //opci�n elegida del usuario
	static LinkedList<archivo> Archivos = new LinkedList<archivo>();
	static repository repositorio = new repository();
	
	public static void iniciarMenu() {
		
		repositorio = repository.gitInit();
		//Mientras la opci�n elegida sea 0, preguntamos al usuario
		while(seleccion != 7){
			//Try catch para evitar que el programa termine si hay un error
			try{
				
				System.out.println(
						"### SIMULACI�N DE GIT ###\r\n" +
						"1. add\r\n" + 
						"2. commit\r\n" + 
						"3. pull\r\n" + 
						"4. push\r\n" + 
						"5. status\r\n" + 
						"6. Crear nuevo archivo \r\n" +
						"7. Salir \r\n" + 
						"INTRODUZCA SU OPCI�N: ");
				//Obtener un numero por consola como integer
				seleccion = Integer.parseInt(input.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(seleccion){
				
				case 1:
					System.out.println("Seleccionaste add, escribe \"all\" (sin comillas) para a�adir todo");	
					System.out.println("o ingresa el nombre de los archivos separados por una coma (sin espacios)");
					System.out.println("Ej: \"all\" o \"archivo1.txt,archivo2.in,archivo3.out\" ");	
					List<String> nombresArchivos = new ArrayList<String>(Arrays.asList(input.nextLine().split(",")));
					
					repositorio.setIndex(workspace.gitAdd(nombresArchivos, repositorio.getWorkspace()) );
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
					status.gitStatus(repositorio);
					break;
					
				case 6: 
					archivo auxiliar = archivo.crearArchivo();
					//para evitar que existan dos archivos con el mismo nombre
					//si se crea un archivo con un nombre que ya existe se reemplazara el anterior por el nuevo
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
					
					printArchivos (Archivos);
					repositorio.setWorkspace(Archivos);
										
				case 7: 
					System.out.println("Finalizado");
					break;
					
				default:
					System.out.println("N�mero no reconocido");break;
				}
				
			}catch(Exception s){
				System.out.println("Ingresa un n�mero");
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
