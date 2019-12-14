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

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (doublyList.getFirst() != null)
			mainView.showSmallInfoPanel(doublyList.getFirst().getPerson(), doublyList.size);
		switch (event.getActionCommand()) {
		// Menu Selection Buttons-----------------------------------------
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
			doublyList.dequeue();
			if (doublyList.getFirst() != null)
				mainView.showSmallInfoPanel(doublyList.getFirst().getPerson(), doublyList.size);
			break;
		// HomePanel Buttons-----------------------------------------
		case "find_button_pressed":
			mainView.homePanel.responsePanel(doublyList.checkPositionById(mainView.homePanel.getFindTextField()),
					doublyList.getPersonById(mainView.homePanel.getFindTextField()));
			break;
		case "update_info_clicked":
			String id = mainView.homePanel.getId();
			String firstName = mainView.homePanel.getFirstNameTextField();
			String lastName = mainView.homePanel.getLastNameTextField();
			String passport = mainView.homePanel.getPassportTextField();
			doublyList.updateInfoById(id, firstName, lastName, passport);
			break;
		case "delete_by_id_clicked":
			doublyList.deletePerson(mainView.homePanel.getId());
			break;
		// RegistrationPanel Buttons------------------------------------------
		case "new_person_button_clicked":
			firstName = mainView.registrationPanel.getFirstNameTextField();
			lastName = mainView.registrationPanel.getLastNameTextField();
			passport = mainView.registrationPanel.getPassportTextField();
			Priority priority = mainView.registrationPanel.getPriority();
			// Checking if the user entered all the required inputs, if not a error message
			// will be displayed
			if (firstName.isEmpty() || lastName.isEmpty() || passport.isEmpty()) {
				mainView.registrationPanel.showNullMessage();
			} else {
				if (isNotString(firstName))
					mainView.registrationPanel.setErrorMessage("first name");
				else {
					if (isNotString(lastName))
						mainView.registrationPanel.setErrorMessage("last name");
					else {
						if (isNotValidPass(passport))
							mainView.registrationPanel.setErrorMessage("passport number");
						else {
							doublyList.newPerson(firstName, lastName, passport, priority);
							mainView.cardLayout.show(mainView.contentPanel, "Home");
						}
					}
				}
			}
			break;
		// CutOffPanel Buttons-------------------------------------------------
		case "remove_from_the_end":
			doublyList.cutOff(mainView.cutOffPanel.getNumberToCut());
			break;
		}
	}

}
