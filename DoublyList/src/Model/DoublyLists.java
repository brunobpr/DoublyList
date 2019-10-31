package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DoublyLists {
	private Node first;
	private Node last;
	private Node lastHigh;
	private Node lastMed;
	private int size;

	public DoublyLists() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}

	/**
	 * @param person is object of type person which holds important information
	 */
	public void newPerson(Person person) {
		Node node = new Node(person);
		if (person.getPriority().equals("High")) {
			addHigh(node);
		} else if (person.getPriority().equals("Med")) {
			addMed(node);
		} else {
			addNon(node);
		}

	}

	public void addHigh(Node highPrio) {
		// If the list is empty, the current node will be the first, last and also last
		// high priority
		if (size == 0) {
			first = highPrio;
			last = highPrio;
			lastHigh = highPrio;
			highPrio.setNext(null);
			highPrio.setPrevious(null);
		} else {
			// If there isn't any last high priority, it means that the queue has some
			// element, but none of them are high priority
			// For that reason the current Node will be the last high priority
			if (lastHigh == null) {
				first.setPrevious(highPrio);
				highPrio.setNext(first);
				first = highPrio;
				lastHigh = highPrio;
			} else {
				// If the last high priority doens't have a next element, it means that the last
				// high is also the last element of the queue
				if (lastHigh.getNext() == null) {
					last = highPrio;
					highPrio.setPrevious(lastHigh);
					highPrio.setNext(null);
					lastHigh.setNext(highPrio);
					lastHigh = highPrio;
				} else {
					// In this case, there is at least one high priority in the queue and at least
					// on element of other priority
					// So the current Node will be placed at the end of the high priority queue, but
					// before the medium or low priority
					lastHigh.getNext().setPrevious(highPrio);
					highPrio.setPrevious(lastHigh);
					highPrio.setNext(lastHigh.getNext());
					lastHigh.setNext(highPrio);
					lastHigh = highPrio;
				}
			}
		}
		size++;
	}

	public void addMed(Node medPrio) {
		// If the list is empty, the current node will be the first, last and also the
		// last medium priority
		if (size == 0) {
			first = medPrio;
			last = medPrio;
			lastMed = medPrio;
			medPrio.setNext(null);
			medPrio.setPrevious(null);
		} else {
			// If there isn't any medium or high priority, it means that the curret Node
			// will be placed first in the queue and also the last medium priority;
			if (lastMed == null && lastHigh == null) {
				first.setPrevious(medPrio);
				medPrio.setNext(first);
				first = medPrio;
				lastMed = medPrio;
			}
			// If there ins't any medium priority, but there is at least one high priority,
			// it means that the current Node will be placed after the last high priority
			// and will be the last medium;
			else if (lastMed == null && lastHigh != null) {
				//If the last High priority is the last element of the entire queue
				//It means that there isn't any medium or low priority
				if (lastHigh == last) {
					lastHigh.setNext(medPrio);
					lastMed = medPrio;
					medPrio.setPrevious(lastHigh);
					medPrio.setNext(lastHigh.getNext());
				}
				//In this cases there is at least one element after the last high priority
				else {
					lastHigh.getNext().setPrevious(medPrio);
					medPrio.setPrevious(lastHigh);
					medPrio.setNext(lastHigh.getNext());
					lastHigh.setNext(medPrio);
					lastMed = medPrio;
				}
			}
			// If there ins't any element after the last medium, it means that the last
			// medium priority is also the last element of the whole queue;
			else if (lastMed == null && lastMed.getNext() == null) {
				last = medPrio;
				medPrio.setPrevious(lastMed);
				medPrio.setNext(null);
				lastMed.setNext(medPrio);
				lastMed = medPrio;
			}
			// In this case, the queue already has the following elements: lastHigh, lastMedium
			else {
				//If the last medium priority doesn't have a next element
				//It means that the current one is also the last in the queue, therefore there isnt any low priority
				if (lastMed.getNext() == null) {
					last = medPrio;
					medPrio.setPrevious(lastMed);
					medPrio.setNext(lastMed.getNext());
					lastMed.setNext(medPrio);
					lastMed = medPrio;
				} 
				//In the last of the cases, the Node will be added after the last medium priority and before any low one.
				else {
					lastMed.getNext().setPrevious(medPrio);
					medPrio.setPrevious(lastMed);
					medPrio.setNext(lastMed.getNext());
					lastMed.setNext(medPrio);
					lastMed = medPrio;
				}
			}
		}
		size++;
	}

	public void addNon(Node nonPrio) {
		//If there isn't any element in the queue, it means that the current node will be the first and the last in the queue
		if (size == 0) {
			first = nonPrio;
			last = nonPrio;
			nonPrio.setNext(null);
			nonPrio.setPrevious(null);
		} 
		//If there is one element in the queue, it goes straigh to the end of the queue
		else {
			nonPrio.setPrevious(last);
			last.setNext(nonPrio);
			last = nonPrio;
		}
		size++;
	}

	/**
	 * @return getAll returns a ArrayList of all elements of the doubly list
	 */
	public ArrayList<Node> getAll() {
		ArrayList<Node> list = new ArrayList<>();
		Node n = first;
		list.add(first);
		for (int i = 0; i <= size - 1; i++) {
			n = n.getNext();
			list.add(n);
		}
		return list;
	}

	/** The user can check to see what position in the queue a person currently is.
	 * @param name
	 * @return the position of the person in the queue
	 */
	public int checkPosition(String name) {
		int position = 0;
		Node n = first;
		//Looping through all the elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			//...until it reaches the person with the given ID
			if (n.getPerson().getFirstName().equals(name)) {
				return position;
			}//if not, go for the next element
			n = n.getNext();
			position++;
		}
		return position = -1;
	}
	
	//Can update information for a single person, without impacting their position in the list.
	public void changeInfo(String name, String newName) {
		Node n = first;
		//Loop though all the elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			//...until it reaches the person with the given ID
			if (n.getPerson().getFirstName().equals(name)) {
//---+++---	//Setting the new information
				n.getPerson().setFirstName(newName);
			}
			n = n.getNext();
		}
	}

	/**	The user can delete N number of records from the end of the queue.
	 * @param cut the number of people that will be removed from the end of the queue
	 */
	public void cutOff(int cut) {
		Node n = last;
		int sizeBeforeCut = size;
		//Loop starting from the end of the queue
		for (int i = 0; i < cut; i++) {
			last = n.getPrevious();
			last.setNext(null);
			size--;
		}
	}

	/**
	 * A person in any position can be deleted from the queue, 
	 * connecting the person who was in front of them to the person who was behind them.
	 * @param id unique id of the person
	 */
	public void deletePerson(String id) {
		Node n = first;
		//Loop through all elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			//Until it reaches the person with the given ID
			if (n.getPerson().getId().contains(id)) {
				System.out.println(n.getPerson().getFirstName() + " is being deleted from the queue!");
				n.getPrevious().setNext(n.getNext());
				n.getNext().setPrevious(n.getPrevious());
				n = null;
				size--;
			} else {
				n = n.getNext();
			}
		}
	}
	
	/**
	 * The user can remove the first person from the queue when this has been looked after. 
	 */
	public void goToNext() {
		first.getNext().setPrevious(null);;
		first = first.getNext();
	}
	
}
