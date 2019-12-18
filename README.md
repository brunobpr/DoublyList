
# Data Structures and Algorithms Project
### Visitor List in Immigration Department
October 2019
Lecturer: Amilcar Aponte

The Immigration department has contacted you outlining that they currently do not have a method of processing who is next in line to be seen by the immigration officer at the counter. As the immigration department is quite busy in the months of September and February due to new students in the country, often people take a ticket, leave and then come back later to see if it is their time to meet with the immigration officer.
Sometimes, some people need special treatment due to special conditions, that need to jump into the middle of the list of waiting people.
Design and implement a piece of software that allows the immigration officer in the immigration department to add new candidates to a queue, check the position of a person by id in the queue, and add or remove people from the queue at different positions depending on their priority status.
Use a Linked List based queue data structure to store the data.
#### Specific Requirements
##### This assignment is focused upon the utilisation of a Doubly Linked List data storage solution as underlying structure for a queue.
You have to implement a program to allow a staff member at the counter to add a new person into the queue. When a new person is added into the system, they will be required to add their first name, last name, date of arrival, passport number and priority level. When the person is added, after its information is collected, they should be added as a new object according to their priority level.
* At any time, the staff member should have the ability to see what position in the queue a person is, by typing in a unique ID number that is given to the person when they register in the system. Keep in mind that the ID does not necessarily correspond to the position of the person in the queue.
* There should be three priority levels:
**High Priority
** Medium Priority 
** Low Priority
* When a low priority person has been added to the queue, they must go straight to the end of it.
* When a high priority person has been added to the queue, they must go straight to the start of the queue, unless the first person is of high priority, in such case they should be added after the last high priority person in the queue.
* When a medium priority person has been added to the queue, the must go after all the high priority people, but before all the low priority people in the queue.
* At any time, the staff member should have the ability to delete a person from the system by entering in their unique ID number. If the person is removed from the queue, their object should be removed and whoever was in front of them should be jointed to the person who was behind them.
* For each of the operations which are being performed on the queue, individual methods should be created to encapsulate the functionality.
* A method should exist to cut off the last N number of records from the queue. If the staff member types in 3. Then the last 3 objects on the linked list should be removed.
* Given a person unique number, the staff member should be able to update the information for that person, without impacting where they currently are in the queue.

# Screenshot

![N|Solid](https://scontent-dub4-1.xx.fbcdn.net/v/t1.15752-9/80365459_449568232637094_7978250727002734592_n.png?_nc_cat=108&_nc_ohc=a3iBcmtExPgAQlDwcNvtqCVoI7HVyJXwCxxqwBLxWUjSLk1b0Iof3xx6g&_nc_ht=scontent-dub4-1.xx&oh=1a41120d7d16b1739ba99d4e5e14ef46&oe=5EB3C266)
![N|Solid](https://scontent-dub4-1.xx.fbcdn.net/v/t1.15752-9/79794349_2377364875908759_538466535300136960_n.png?_nc_cat=106&_nc_ohc=-pGSY86XYAoAQn7CRiIHncAU_YN6JCtV4Y-HFMpGBG8y3N6EunkHGTS8g&_nc_ht=scontent-dub4-1.xx&oh=88e02b27beb4943245c21e728af79c33&oe=5E675D90)
![N|Solid](https://scontent-dub4-1.xx.fbcdn.net/v/t1.15752-9/79800815_576259946284021_6453571572107051008_n.png?_nc_cat=107&_nc_ohc=w_c-7DOjoooAQk-MdmUqliLx7ByyPx_jYEiHGvgdWll9v1TPXxVM7U7Rw&_nc_ht=scontent-dub4-1.xx&oh=84261869df58e6c857b4340fee631c09&oe=5E6E7086)
![N|Solid](https://scontent-dub4-1.xx.fbcdn.net/v/t1.15752-9/80430816_606775350091874_6786822066038374400_n.png?_nc_cat=103&_nc_ohc=h3br2cxL4fsAQlKuv-jftQuR4Y43MG346ga_6qeupFl36rA8GR8dttqgA&_nc_ht=scontent-dub4-1.xx&oh=68ae4964ae86f6cdde67aa0d0674561c&oe=5E78CE85)
