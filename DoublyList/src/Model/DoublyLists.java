package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Bruno Ribeiro - 2017138
 * 
 */

public class DoublyLists {
	private Node firstNode;
	private Node lastNode;
	private Node lastHighPriorityNode;
	private Node lastMediumPriorityNode;
	private int size;

	public DoublyLists() {
		this.size = 0;
		this.firstNode = null;
		this.lastNode = null;
	}

	/**
	 * @param person is object of type person which holds important information
	 */
	public void newPerson(Person person) {
		Node node = new Node(person);
		if (person.getPriority() == Priority.HIGH) {
			addHighPriorityPerson(node);
		} else if (person.getPriority() == Priority.MEDIUM) {
			addMediumPriorityPerson(node);
		} else {
			addLowPriorityPerson(node);
		}

		
	}

	public void addHighPriorityPerson(Node newNodeHigh) {
		// If the list is empty, the current node will be the first, last and also last
		// high priority
		if (size == 0) {
			firstNode = newNodeHigh;
			lastNode = newNodeHigh;
			lastHighPriorityNode = newNodeHigh;
			newNodeHigh.setNext(null);
			newNodeHigh.setPrevious(null);
		} else {
			// If there isn't any last high priority, it means that the queue has some
			// element, but none of them are high priority
			// For that reason the current Node will be the last high priority
			if (lastHighPriorityNode == null) {
				firstNode.setPrevious(newNodeHigh);
				newNodeHigh.setNext(firstNode);
				firstNode = newNodeHigh;
				lastHighPriorityNode = newNodeHigh;
			} else {
				// If the last high priority doens't have a next element, it means that the last
				// high is also the last element of the queue
				if (lastHighPriorityNode.getNext() == null) {
					lastNode = newNodeHigh;
					newNodeHigh.setPrevious(lastHighPriorityNode);
					newNodeHigh.setNext(null);
					lastHighPriorityNode.setNext(newNodeHigh);
					lastHighPriorityNode = newNodeHigh;
				} else {
					// In this case, there is at least one high priority in the queue and at least
					// on element of other priority
					// So the current Node will be placed at the end of the high priority queue, but
					// before the medium or low priority
					lastHighPriorityNode.getNext().setPrevious(newNodeHigh);
					newNodeHigh.setPrevious(lastHighPriorityNode);
					newNodeHigh.setNext(lastHighPriorityNode.getNext());
					lastHighPriorityNode.setNext(newNodeHigh);
					lastHighPriorityNode = newNodeHigh;
				}
			}
		}
		size++;
	}

	public void addMediumPriorityPerson(Node newNodeMedium) {
		// If the list is empty, the current node will be the first, last and also the
		// last medium priority
		if (size == 0) {
			firstNode = newNodeMedium;
			lastNode = newNodeMedium;
			lastMediumPriorityNode = newNodeMedium;
			newNodeMedium.setNext(null);
			newNodeMedium.setPrevious(null);
		} else {
			// If there isn't any medium or high priority, it means that the curret Node
			// will be placed first in the queue and also the last medium priority;
			if (lastMediumPriorityNode == null && lastHighPriorityNode == null) {
				firstNode.setPrevious(newNodeMedium);
				newNodeMedium.setNext(firstNode);
				firstNode = newNodeMedium;
				lastMediumPriorityNode = newNodeMedium;
			}
			// If there ins't any medium priority, but there is at least one high priority,
			// it means that the current Node will be placed after the last high priority
			// and it will be the first and last medium;
			else if (lastMediumPriorityNode == null && lastHighPriorityNode != null) {
				//If the last High priority is the last element of the entire queue
				//It means that there isn't any medium or low priority
				if (lastHighPriorityNode == lastNode) {
					lastHighPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
					newNodeMedium.setPrevious(lastHighPriorityNode);
					newNodeMedium.setNext(lastHighPriorityNode.getNext());
				}
				//In this cases there is at least one element after the last high priority
				else {
					lastHighPriorityNode.getNext().setPrevious(newNodeMedium);
					newNodeMedium.setPrevious(lastHighPriorityNode);
					newNodeMedium.setNext(lastHighPriorityNode.getNext());
					lastHighPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
				}
			}
			// If there ins't any element after the last medium, it means that the last
			// medium priority is also the last element of the whole queue;
			else if (lastMediumPriorityNode == null && lastMediumPriorityNode.getNext() == null) {
				lastNode = newNodeMedium;
				newNodeMedium.setPrevious(lastMediumPriorityNode);
				newNodeMedium.setNext(null);
				lastMediumPriorityNode.setNext(newNodeMedium);
				lastMediumPriorityNode = newNodeMedium;
			}
			// In this case, the queue already has the following elements: lastHigh, lastMedium
			else {
				//If the last medium priority doesn't have a next element
				//It means that the current one is also the last in the queue, therefore there isnt any low priority
				if (lastMediumPriorityNode.getNext() == null) {
					lastNode = newNodeMedium;
					newNodeMedium.setPrevious(lastMediumPriorityNode);
					newNodeMedium.setNext(lastMediumPriorityNode.getNext());
					lastMediumPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
				} 
				//In the last of the cases, the Node will be added after the last medium priority and before any low one.
				else {
					lastMediumPriorityNode.getNext().setPrevious(newNodeMedium);
					newNodeMedium.setPrevious(lastMediumPriorityNode);
					newNodeMedium.setNext(lastMediumPriorityNode.getNext());
					lastMediumPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
				}
			}
		}
		size++;
	}

	
	/** When a low priority person has been added to the queue, they must go straight to the end of it.
	 * @param newNodeLow Node of Low Priority Status
	 */
	public void addLowPriorityPerson(Node newNodeLow) {
		//If there isn't any element in the queue, it means that the current node will be the first and the last in the queue
		if (size == 0) {
			firstNode = newNodeLow;
			lastNode = newNodeLow;
			newNodeLow.setNext(null);
			newNodeLow.setPrevious(null);
		} 
		//If there is one element in the queue, it goes straigh to the end of the queue
		else {
			newNodeLow.setPrevious(lastNode);
			lastNode.setNext(newNodeLow);
			lastNode = newNodeLow;
		}
		size++;
	}

	/**
	 * @return getAll returns a ArrayList of all elements of the doubly list
	 */
	public ArrayList<Node> getQueue() {
		ArrayList<Node> list = new ArrayList<>();
		Node node = firstNode;
		list.add(firstNode);
		for (int i = 0; i <= size - 1; i++) {
			node = node.getNext();
			list.add(node);
		}
		return list;
	}

	/** The user can check to see what position in the queue a person currently is.
	 * @param name
	 * @return the position of the person in the queue
	 */
	public int checkPositionByName(String name) {
		int position = 0;
		Node n = firstNode;
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
	
	// At any time, the staff member should have the ability to see what position in the queue a person is, 
	// by typing in a unique ID number that is given to the person when they register in the system.
	public void updateInfoById(String name, String newName) {
		Node n = firstNode;
		//Looping through all the elements of the queue...
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
		Node n = lastNode;
		int sizeBeforeCut = size;
		//Loop starting from the end of the queue
		for (int i = 0; i < cut; i++) {
			lastNode = n.getPrevious();
			lastNode.setNext(null);
			size--;
		}
	}

	/**
	 * A person in any position can be deleted from the queue, 
	 * connecting the person who was in front of them to the person who was behind them.
	 * @param id unique id of the person
	 */
	public void deletePerson(String id) {
		Node n = firstNode;
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
		firstNode.getNext().setPrevious(null);;
		firstNode = firstNode.getNext();
	}
	
}
