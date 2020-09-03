package modelo;

import java.util.LinkedList;
import java.util.Scanner;

public class index extends repository{
	private static commit nuevoCommit;
	static Scanner input = new Scanner(System.in); 
	
	public static LinkedList<commit> gitCommit (LinkedList<archivo> workspace, repository rep){
		LinkedList<commit> listaDeCommits = new LinkedList<commit>();		
		System.out.println("Mensaje descriptivo:");
        nuevoCommit.setComentario(input.nextLine());	
		
        for (int i=0;i < workspace.size();i++) {
			//para cada archivo del workspace se debe comparar si este existe en el repositorio y que cambios tiene   
		}
         
		return listaDeCommits;
	}
	
}
