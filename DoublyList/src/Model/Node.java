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
	 * @param p new person being registered into the queue
	 */
	public Node(Person p) {
		this.person = p;
		this.next = null;
		this.previous = null;
	}
	
	public Node(Person p, Node next, Node previous){
		this.person = p;
        this.next = next;
        this.previous = previous;
    }
	
	//The first or last node of the list does not have a next or a previous node
	public Node(Person p, Node n){
		this.person = p;
        this.previous = null;
        this.next = null;
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