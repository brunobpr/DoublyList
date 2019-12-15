package Model;

/**
 * 
 * @author Bruno Ribeiro - 2017138
 *
 */
public class Node {

	private Node previous;
	private Node next;
	private Person person;

	/**
	 * @param p
	 *            new person being registered into the queue
	 */
	public Node(Person p) {
		this.person = p;
		this.next = null;
		this.previous = null;
	}

	public Person getPerson() {
		return this.person;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return this.previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}