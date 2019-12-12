import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controller.Controller;
import Model.DoublyLists;
import Model.Node;
import Model.Person;
import Model.Priority;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		
		DoublyLists db = new DoublyLists();
		Person one = new Person("Bruno", "Ribeiro", "2015-10-12", "FM594881", Priority.LOW);
		Person two = new Person("Rodrigo", Priority.MEDIUM);
		Person three = new Person("Luciene", Priority.LOW);
		Person four = new Person("Evandro", Priority.HIGH);
		db.newPerson(one);
		db.newPerson(two);
		db.newPerson(three);
		db.newPerson(four);
		Node n = db.firstNode;
		while (n !=null) {
			System.out.println(n.getPerson().getFirstName() + " " + n.getPerson().getPriority()+ " " + n.getPerson().getId());
			n = n.getNext();
		}
		Controller controller = new Controller(db);
		
		/*
		 * ArrayList<Node> list = db.getAll(); for(int i = 0; i < list.size() - 1; i++)
		 * { System.out.println("Name: " + list.get(i).getPerson().getFirstName() + " "
		 * + "Prio: " + list.get(i).getPerson().getPriority() + ".");
		 * 
		 * 
		 * System.out.println("Rod is at position: " + db.checkPosition("Rod"));
		 * 
		 * 
		 * }
		 */

	}
}