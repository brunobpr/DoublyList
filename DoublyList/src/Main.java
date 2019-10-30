import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controller.Controller;
import Model.DoublyLists;
import Model.Node;
import Model.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLists db = new DoublyLists();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i <= 3; i++) {
			{
				String name = "";
				String prio = "";
				try {
					System.out.println("Name: ");
					name = reader.readLine();
					System.out.println("Prio: ");
					prio = reader.readLine();
					Person p = new Person(name, prio);
					db.newPerson(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		ArrayList<Node> list = db.getAll();
		System.out.println("First " + list.get(0).getPerson().getFirstName() + " "
				+ list.get(0).getNext().getPerson().getFirstName());
		for (int i = 1; i < list.size() - 2; i++) {
			System.out.println(list.get(i).getPrevious().getPerson().getFirstName() + " "
					+ list.get(i).getPerson().getFirstName() + " " + list.get(i).getNext().getPerson().getFirstName());
		}
		System.out.println(list.get(3).getPrevious().getPerson().getFirstName() + " "
				+ list.get(3).getPerson().getFirstName() + " Last \n");
		String id;
		try {
			id = reader.readLine();
			db.deletePerson(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list = db.getAll();
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.println("Name: " + list.get(i).getPerson().getFirstName() + " " + "Prio: "
					+ list.get(i).getPerson().getPriority() + ".");
		}
		
		
		
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