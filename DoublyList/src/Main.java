import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controller.Controller;
import Model.DoublyLists;
import Model.FakeData;
import Model.Node;
import Model.Person;
import Model.Priority;

public class Main {

	public static void main(String[] args) {
		System.out.println("Bruno Pereira Ribeiro\n2017138\nCCT Dublin\n");
//--------Set the value below to the number of fake people wanted!---------------------
		int generate = 100;
		DoublyLists db = new DoublyLists();
		FakeData generator = new FakeData();
		for(int i = 0; i < generate; i++) {
		db.newPerson(generator.firstName(), generator.lastName(), generator.passport(), generator.date(), generator.priority());
		}
		System.out.println(generate + " people added to the queue!");
		Controller controller = new Controller(db);
		
	}
}