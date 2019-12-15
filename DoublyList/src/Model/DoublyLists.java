package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Bruno Ribeiro - 2017138
 * 
 */

public class DoublyLists implements CAInterface {
	public Node firstNode;
	private Node lastNode;
	private Node lastHighPriorityNode;
	private Node lastMediumPriorityNode;
	public int size;

	public DoublyLists() {
		this.size = 0;
		this.firstNode = null;
		this.lastNode = null;
	}

	/**
	 * @param firstName
	 *            First name
	 * @param lastName
	 *            last name
	 * @param passport
	 *            passport
	 * @param date
	 *            date of arrival
	 * @param priority
	 *            priority level
	 */
	@Override
	public void newPerson(String firstName, String lastName, String passport, String date, Priority priority) {
		Person person = new Person(firstName, lastName, passport, date, priority);
		Node node = new Node(person);
		if (person.getPriority() == Priority.HIGH) {
			addHighPriorityPerson(node);
		} else if (person.getPriority() == Priority.MEDIUM) {
			addMediumPriorityPerson(node);
		} else {
			addLowPriorityPerson(node);
		}

	}

	/**
	 * @param newNodeHigh
	 *            Node of High Priority being added to the queue
	 */
	@Override
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

	/**
	 * @param newNodeMedium
	 *            Node of Medium Priority being added to the queue
	 */
	@Override
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
			// If there isn't any medium or high priority, it means that the current Node
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
				// If the last High priority is the last element of the entire queue
				// It means that there isn't any medium or low priority
				if (lastHighPriorityNode == lastNode) {
					lastHighPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
					newNodeMedium.setPrevious(lastHighPriorityNode);
					lastNode = newNodeMedium;
				}
				// In this cases there is at least one element after the last high priority
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
			// In this case, the queue already has the following elements: lastHigh,
			// lastMedium
			else {
				// If the last medium priority doesn't have a next element
				// It means that the current one is also the last in the queue, therefore there
				// isnt any low priority
				if (lastMediumPriorityNode.getNext() == null) {
					lastNode = newNodeMedium;
					newNodeMedium.setPrevious(lastMediumPriorityNode);
					newNodeMedium.setNext(lastMediumPriorityNode.getNext());
					lastMediumPriorityNode.setNext(newNodeMedium);
					lastMediumPriorityNode = newNodeMedium;
				}
				// In the last of the cases, the Node will be added after the last medium
				// priority and before any low one.
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

	/**
	 * @param newNodeLow
	 *            Node of Low Priority being added to the queue
	 */
	@Override
	public void addLowPriorityPerson(Node newNodeLow) {
		// If there isn't any element in the queue, it means that the current node will
		// be the first and the last in the queue
		if (size == 0) {
			firstNode = newNodeLow;
			lastNode = newNodeLow;
			newNodeLow.setNext(null);
			newNodeLow.setPrevious(null);
		}
		// If there is one element in the queue, it goes straigh to the end of the queue
		else {
			newNodeLow.setPrevious(lastNode);
			lastNode.setNext(newNodeLow);
			lastNode = newNodeLow;
		}
		size++;
	}

	/**
	 * The user can check to see what position in the queue a person currently is.
	 * 
	 * @param input
	 *            input entered by the user on the HomePanel class at
	 * @return the position of the person in the queue
	 */
	@Override
	public int checkPositionById(String input) {
		int position = 1;
		Node n = firstNode;
		// Looping through all the elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			// ...until it reaches the person with the given ID
			if (n.getPerson().getId().equals(input)) {
				return position;
			} // if not, go for the next element
			n = n.getNext();
			position++;
		}
		return -1;
	}

	/**
	 * @param id
	 *            unique id of the person
	 * @param firstName
	 *            First name
	 * @param lastName
	 *            last name
	 * @param passport
	 *            passport
	 * @param date
	 *            date of arrival
	 * @param priority
	 *            priority level
	 */
	@Override
	public void updateInfoById(String id, String firstName, String lastName, String date, String passport) {
		Node n = firstNode;
		// Looping through all the elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			// ...until it reaches the person with the given ID
			if (n.getPerson().getId().equals(id)) {
				Person updatingPerson = n.getPerson();
				updatingPerson.setFirstName(firstName);
				updatingPerson.setLastName(lastName);
				updatingPerson.setPassport(passport);
				updatingPerson.setDate(date);
			}
			n = n.getNext();
		}
	}

	/**
	 * @param cut
	 *            the number of people that will be removed from the end of the
	 *            queue
	 */
	@Override
	public void cutOff(int cut) {
		// Loop starting from the end of the queue
		while (size > 0 && cut > 0) {
			size--;
			cut--;
			if (lastNode.getPrevious() != null)
				lastNode.getPrevious().setNext(null);
			lastNode = lastNode.getPrevious();
		}
	}

	/**
	 * @param id
	 *            unique id of the person
	 */
	@Override
	public void deletePerson(String id) {
		Node n = firstNode;
		// Loop through all elements of the queue...
		while (n != null) {
			// Until it reaches the person with the given ID
			if (n.getPerson().getId().contains(id)) {
				if (size > 1) {
					if (n == firstNode) {
						dequeue();
					} else if (n == lastNode) {
						cutOff(1);
					} else {
						n.getPrevious().setNext(n.getNext());
						n.getNext().setPrevious(n.getPrevious());
						size--;
					}
				} else {
					firstNode = null;
					lastNode = null;
					size--;
				}
				break;
			} else {
				n = n.getNext();
			}
		}
	}

	/**
	 * @return the first node of the queue that its been removed
	 */
	public Node dequeue() {
		if (size != 0) {
			Node nodeOut = firstNode;
			if (firstNode == lastNode)
				firstNode = null;
			if (firstNode == lastHighPriorityNode)
				lastHighPriorityNode = null;
			if (firstNode == lastMediumPriorityNode)
				lastMediumPriorityNode = null;
			else {
				firstNode.getNext().setPrevious(null);
				firstNode = firstNode.getNext();

			}
			size--;
			return nodeOut;
		}
		return null;
	}

	/**
	 * @return getAll returns a 2D array of all elements of the doubly list
	 */
	public String[][] getQueueToTable() {
		String[][] queue = new String[this.size][5];
		if (size == 0) {
			return queue;
		} else {
			Node node = firstNode;
			int position = 0;
			do {
				queue[position][0] = String.valueOf(position + 1) + " - " + node.getPerson().getFirstName() + " "
						+ node.getPerson().getLastName();
				queue[position][1] = node.getPerson().getId();
				queue[position][2] = node.getPerson().getPassport();
				queue[position][4] = String.valueOf(node.getPerson().getPriority());
				queue[position][3] = node.getPerson().getDate();
				position++;
				node = node.getNext();
			} while (node != null);
			return queue;
		}
	}

	/**
	 * @param input
	 *            unique ID entered on the HomePanel
	 * @return the node with the person found
	 */
	public Node getPersonById(String input) {
		int position = 1;
		Node n = firstNode;
		// Looping through all the elements of the queue...
		for (int i = 0; i <= size - 1; i++) {
			// ...until it reaches the person with the given ID
			if (n.getPerson().getId().equals(input)) {
				return n;
			} // if not, go for the next element
			n = n.getNext();
			position++;
		}
		return null;
	}

	/**
	 * @return the first node of the queue
	 */
	public Node getFirst() {
		return firstNode;
	}

}
