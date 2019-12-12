package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.*;
import View.*;

public class Controller implements ActionListener {
	private MainView mainView;
	private DoublyLists doublyList;

	public Controller(DoublyLists db) {
		doublyList = db;
		MouseListener mouseListener = new MouseListener();
		mainView = new MainView(this, mouseListener);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "find_button_pressed":
			mainView.homePanel.responsePanel(doublyList.checkPositionById(mainView.homePanel.getFindTextField()),
					doublyList.getPersonById(mainView.homePanel.getFindTextField()));
					break;
		case "update_info_clicked":
			String id = mainView.homePanel.getId();
			String firstName = mainView.homePanel.getFirstNameTextField();
			String lastName = mainView.homePanel.getLastNameTextField();
			String passport = mainView.homePanel.getPassportTextField();
			Priority priority = mainView.homePanel.getPriority();
			doublyList.updateInfoById(id, firstName, lastName, passport, priority);
			break;
		case "delete_by_id_clicked":
				doublyList.deletePerson(mainView.homePanel.getId());
			break;
			
		}
	}

}
