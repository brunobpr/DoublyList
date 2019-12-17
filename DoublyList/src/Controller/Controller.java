package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class Controller extends Validator implements ActionListener {
	private MainView mainView;
	private DoublyLists doublyList;

	public Controller(DoublyLists db) {
		doublyList = db;
		mainView = new MainView(this);
		// If there is at least one person, its name will be shown on the bottom left
		// side of the main view
		if (doublyList.getFirst() != null)
			mainView.showSmallInfoPanel(doublyList.getFirst().getPerson(), doublyList.size);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		// Menu Selection Buttons-----------------------------------------
		// mainView.cardLayout.show is the 'command' to display the corresponding panel
		case "home":
			mainView.cardLayout.show(mainView.contentPanel, "Home");
			break;
		case "show_queue":
			mainView.cardLayout.show(mainView.contentPanel, "Queue");
			mainView.queuePanel.buildQueuePanel(doublyList.getQueueToTable());
			break;
		case "registration":
			mainView.cardLayout.show(mainView.contentPanel, "Registration");
			mainView.registrationPanel.buildRegistrationPanel();
			break;
		case "cut_queue":
			mainView.cutOffPanel.buildCutOffPanel(doublyList.size);
			break;
		case "next_person":
			// Remove the first person of the queue
			doublyList.dequeue();
			// If there is at least one person, its name will be shown on the bottom left
			// side of the main view
			if (doublyList.getFirst() != null)
				mainView.showSmallInfoPanel(doublyList.getFirst().getPerson(), doublyList.size);
			break;
		// HomePanel Buttons-----------------------------------------
		case "find_button_clicked":
			//
			mainView.homePanel.responsePanel(doublyList.checkPositionById(mainView.homePanel.getFindTextField()),
					doublyList.getPersonById(mainView.homePanel.getFindTextField()), null);
			break;
		case "update_info_clicked":
			String id = mainView.homePanel.getId();
			String firstName = mainView.homePanel.getFirstNameTextField();
			String lastName = mainView.homePanel.getLastNameTextField();
			String passport = mainView.homePanel.getPassportTextField();
			String date = mainView.homePanel.getDateField();
			// Checking if the user entered all the required inputs,
			// if not a error message will be displayed
			if (firstName.isEmpty() || lastName.isEmpty() || passport.isEmpty()) {
				mainView.homePanel.buildUpdateInfoPane(doublyList.checkPositionById(id), doublyList.getPersonById(id),
						"Please fill all the fields!");
			} else {
				// Checking if each input maches with the expected value
				// First and last name must be only letter
				// Each if statement will be true when the input is not valid
				if (notOnlyLetters(firstName))
					mainView.homePanel.buildUpdateInfoPane(doublyList.checkPositionById(id),
							doublyList.getPersonById(id), "Not valid first name. Only letters");
				else {
					// Therefore each else will be 'true' when the input is valid
					if (notOnlyLetters(lastName))
						mainView.homePanel.buildUpdateInfoPane(doublyList.checkPositionById(id),
								doublyList.getPersonById(id), "Not valid last name. Only letters");
					else {
						if (isNotValidPass(passport))
							mainView.homePanel.buildUpdateInfoPane(doublyList.checkPositionById(id),
									doublyList.getPersonById(id), "Not valid passport. Letters and numbers");
						else {
							if (isNotValidDate(date))
								mainView.homePanel.buildUpdateInfoPane(doublyList.checkPositionById(id),
										doublyList.getPersonById(id), "This is not a valid date. dd/mm/yy");
							else {
								// If all the inputs are valid, the information will be created.
								doublyList.updateInfoById(id, firstName, lastName, date, passport);
								// And the user will be sent to the Home page.
								mainView.cardLayout.show(mainView.contentPanel, "Home");
							}
						}
					}
				}
			}
			break;

		case "delete_by_id_clicked":
			doublyList.deletePerson(mainView.homePanel.getId());
			break;

		// RegistrationPanel Buttons------------------------------------------
		case "new_person_button_clicked":
			firstName = mainView.registrationPanel.getFirstNameTextField();
			lastName = mainView.registrationPanel.getLastNameTextField();
			passport = mainView.registrationPanel.getPassportTextField();
			date = mainView.registrationPanel.getDate();
			Priority priority = mainView.registrationPanel.getPriority();
			// Checking if the user entered all the required inputs, if not a error message
			// will be displayed
			if (firstName.isEmpty() || lastName.isEmpty() || passport.isEmpty()) {
				mainView.registrationPanel.showNullMessage();
			} else {
				// Checking if each input maches with the expected value
				// First and last name must be only letter
				// Each if statement will be true when the input is not valid
				if (notOnlyLetters(firstName))
					mainView.registrationPanel.setErrorMessage("first name!");
				else {
					// Therefore each else will be 'true' when the input is valid
					if (notOnlyLetters(lastName))
						mainView.registrationPanel.setErrorMessage("last name!");
					else {
						if (isNotValidPass(passport))
							mainView.registrationPanel.setErrorMessage("passport number!");
						else {
							if (isNotValidDate(date))
								mainView.registrationPanel.setErrorMessage("date!");
							else {
								// If all the inputs are valid, the new person will be created.
								doublyList.newPerson(firstName, lastName, passport, date, priority);
								// And the user will be sent to the Home page.
								mainView.cardLayout.show(mainView.contentPanel, "Home");
							}
						}
					}
				}
			}
			break;
		// CutOffPanel Buttons-------------------------------------------------
		case "remove_from_the_end":
			if (isNotOnlyNumbers(mainView.cutOffPanel.getNumberToCut()))
				mainView.cutOffPanel.buildCutOffPanel(doublyList.size);
			else {
				doublyList.cutOff(Integer.valueOf(mainView.cutOffPanel.getNumberToCut()));
			}
			break;
		}
		// Update important information after every click event
		// The small panel on the bottom left
		if (doublyList.getFirst() != null)
			mainView.showSmallInfoPanel(doublyList.getFirst().getPerson(), doublyList.size);
		// The table on SHOW QUEUE
		mainView.queuePanel.buildQueuePanel(doublyList.getQueueToTable());
	}

}
