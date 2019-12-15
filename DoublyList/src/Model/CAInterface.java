package Model;

public interface CAInterface {

	/*
	 * You have to implement a program to allow a staff member at the counter to add
	 * a new person into the queue. When a new person is added into the system, they
	 * will be required to add their first name, last name, date of arrival,
	 * passport number and priority level. When the person is added, after its
	 * information is collected, they should be added as a new object according to
	 * their priority level.
	 */
	void newPerson(String firstName, String lastName, String passport, String date, Priority priority);

	/*
	 * At any time, the staff member should have the ability to see what position in
	 * the queue a person is, by typing in a unique ID number that is given to the
	 * person when they register in the system. Keep in mind that the ID does not
	 * necessarily correspond to the position of the person in the queue.
	 */
	public int checkPositionById(String id);

	/*
	 * When a low priority person has been added to the queue, they must go straight
	 * to the end of it.
	 */
	public void addLowPriorityPerson(Node node);

	/*
	 * When a high priority person has been added to the queue, they must go
	 * straight to the start of the queue, unless the first person is of high
	 * priority, in such case they should be added after the last high priority
	 * person in the queue.
	 */
	public void addHighPriorityPerson(Node node);

	/*
	 * When a medium priority person has been added to the queue, the must go after
	 * all the high priority people, but before all the low priority people in the
	 * queue.
	 */
	public void addMediumPriorityPerson(Node node);

	/*
	 * At any time, the staff member should have the ability to delete a person from
	 * the system by entering in their unique ID number. If the person is removed
	 * from the queue, their object should be removed and whoever was in front of
	 * them should be jointed to the person who was behind them.
	 */
	public void deletePerson(String id);

	/*
	 * A method should exist to cut off the last N number of records from the queue.
	 * If the staff member types in 3. Then the last 3 objects on the linked list
	 * should be removed.
	 */
	public void cutOff(int cut);

	/*
	 * Given a person unique number, the staff member should be able to update the
	 * information for that person, without impacting where they currently are in
	 * the queue.
	 */
	public void updateInfoById(String id, String firstName, String lastName, String date, String passport);

	/*
	 * The user can remove the first person from the queue when this has been looked
	 * after. Code is well structured and commented.
	 */
	public Node dequeue();
}
