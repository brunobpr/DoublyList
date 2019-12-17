package Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controller.Controller;



/**
 * @author Bruno Ribeiro - 2017138
 * https://github.com/brunobpr/DoublyList
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Bruno Pereira Ribeiro\n2017138\nCCT Dublin\n");
		// --------Set the value below to the number of fake people wanted!---------------------
		int generate = 100; // Use it wisely! It will generates millions if defined!!!!!
		DoublyLists db = new DoublyLists();
		FakeData generator = new FakeData();
		System.out.println("Generating fake data...");
		for (int i = 0; i < generate; i++) {
			db.newPerson(generator.firstName(), generator.lastName(), generator.passport(), generator.date(),
					generator.priority());
		}
		System.out.println(generate + " people added to the queue!\n");
		System.out.println("The ID for each person can be found at SHOW QUEUE menu option!");
		System.out.println("It is possible to copy and paste from there.\n");
		System.out.println("HOME       - Search a person by ID -> Show positon -> Delete and Update.");
		System.out.println("REGISTER   - Add a new person to the queue.");
		System.out.println("SHOW QUEUE - Shows a table containing Name, ID, Passport, Date of Arrival and Priority.");
		System.out.println("CUT QUEUE  - Delete the desired number of people from the end.");
		System.out.println("NEXT>      - Gets the next person.");
		Controller controller = new Controller(db);

	}
}