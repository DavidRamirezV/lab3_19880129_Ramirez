package modelo;

import java.util.LinkedList;

public class LocalRepository extends Repository{
	
	public static LinkedList<Commit> gitPush (Repository rep){
		LinkedList<Commit> commitsRemote = new LinkedList<Commit>();
	
  	    commitsRemote.addAll(rep.getLocalRepository());
  	    
        return commitsRemote;
	}
	
}
