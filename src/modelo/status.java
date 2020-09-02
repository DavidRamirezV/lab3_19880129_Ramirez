package modelo;

public class status extends repository{
	
	public static void gitStatus(repository rep) {

		System.out.println("-----------------------------");
		System.out.println("Autor: " + rep.getAutor());
		System.out.println("Rama: " + rep.getRama());
		System.out.println("Fecha de creacion: " + rep.getFecha());
		
		System.out.println("---------WORKSPACE-----------");
		
		if(rep.getWorkspace() == null || rep.getWorkspace().size() == 0){
			System.out.println("Cantidad de Archivos: 0");		    
		}
		else {
			System.out.println("Cantidad de Archivos: " + rep.getWorkspace().size());
		}
		
	    System.out.println("-----------INDEX--------------");
	    
	    if(rep.getIndex() == null || rep.getIndex().size() == 0){
	    	System.out.println("Cantidad de Archivos: 0");
	    	
	    }
	    else {
	    	System.out.println("Cantidad de Archivos: " + rep.getIndex().size());
	    }
	    
	    System.out.println("-------LOCAL REPOSITORY-------");
	    
	    if(rep.getLocalRepository() == null || rep.getLocalRepository().size() == 0){
	    	System.out.println("Cantidad de Commits: 0");
	    }
	    else {
	    	System.out.println("Cantidad de Commits: " + rep.getLocalRepository().size());
	    }
	    
	    System.out.println("------REMOTE REPOSITORY-------");
	    //aqui se comparan los de local y remote
	    System.out.println("------------------------------");
	    
		   
	
	}
	
	
}
