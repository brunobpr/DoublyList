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
		DoublyLists db = new DoublyLists();
		Controller controller = new Controller(db);
	}
}