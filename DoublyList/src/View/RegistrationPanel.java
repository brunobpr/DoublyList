package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Node;
import Model.Priority;

public class RegistrationPanel extends JPanel {
	private Controller control;
	private Font font;
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JTextField firstNameTextField = new JTextField(25);
	private JTextField lastNameTextField = new JTextField(25);
	private JTextField passportTextField = new JTextField(25);
	private JRadioButton highPriorityButton = new JRadioButton("High");
	private JRadioButton mediumPriorityButton = new JRadioButton("Medium");
	private JRadioButton lowPriorityButton = new JRadioButton("Low");
	private JLabel errorMessage = new JLabel("");
	private JComboBox<String> dayComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> yearComboBox;
	private JLabel nullMessage = new JLabel("Please fill all the fields!");

	public RegistrationPanel(Controller controller) {
		control = controller;
		setLayout(grid);
	}

	// This panel works as a form
	// It contains text fields and jcombobox
	// If the input is not valid an error message is displayed
	public void buildRegistrationPanel() {
		resetForm();
		ImageIcon icon = new ImageIcon("logo.png");
		JLabel jl = new JLabel("Register A New Person");
		JButton newPersonButton = new JButton("Register");
		newPersonButton.addActionListener(control);
		newPersonButton.setActionCommand("new_person_button_clicked");
		jl.setFont(font = new Font("Verdana", Font.BOLD, 18));
		setLayout(grid);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 20;
		gbc.gridwidth = 6;
		add(jl, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(jl = new JLabel("First name:"), gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 0;
		add(firstNameTextField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(new JLabel("Last name:"), gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		add(lastNameTextField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		add(new JLabel("Passport:"), gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		add(passportTextField, gbc);
		String[] day = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "Day" };
		String[] month = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "Month" };
		String[] year = { "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"Year" };
		// Create the combo box, select item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		dayComboBox = new JComboBox<String>(day);
		dayComboBox.setSelectedIndex(31);
		monthComboBox = new JComboBox<String>(month);
		monthComboBox.setSelectedIndex(12);
		yearComboBox = new JComboBox<String>(year);
		yearComboBox.setSelectedIndex(15);
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		add(new JLabel("Arrival date:"), gbc);
		gbc.gridx = 1;
		add(dayComboBox, gbc);
		gbc.gridx = 2;
		add(monthComboBox, gbc);
		gbc.gridx = 3;
		add(yearComboBox, gbc);
		ButtonGroup group = new ButtonGroup();
		group.add(highPriorityButton);
		group.add(mediumPriorityButton);
		group.add(lowPriorityButton);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		add(new JLabel("Priority:"), gbc);
		gbc.gridx = 1;
		add(highPriorityButton, gbc);
		gbc.gridx = 2;
		add(mediumPriorityButton, gbc);
		gbc.gridx = 3;
		add(lowPriorityButton, gbc);
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		gbc.gridy = 8;
		add(newPersonButton, gbc);
		lowPriorityButton.setSelected(true);
	}

	public void setErrorMessage(String invalidInput) {
		remove(nullMessage);
		String errorText = "This is not a valid " + invalidInput;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		add(errorMessage, gbc);
		errorMessage.setText(errorText);
		errorMessage.setForeground(Color.RED);
	}

	public void showNullMessage() {
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		gbc.gridy = 7;
		add(nullMessage, gbc);
		nullMessage.setForeground(Color.RED);
		validate();
		repaint();
	}

	// Delete all the text fields and remove the error messages.
	private void resetForm() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		passportTextField.setText("");
		remove(nullMessage);
		remove(errorMessage);
	}

	public String getFirstNameTextField() {
		return firstNameTextField.getText();
	}

	public String getLastNameTextField() {
		return lastNameTextField.getText();
	}

	public String getPassportTextField() {
		return passportTextField.getText();
	}

	public Priority getPriority() {
		if (highPriorityButton.isSelected()) {
			return Priority.HIGH;
		} else if (mediumPriorityButton.isSelected()) {
			return Priority.MEDIUM;
		}
		return Priority.LOW;
	}

	public String getDate() {
		String date = String.valueOf(dayComboBox.getSelectedItem() + "/" + monthComboBox.getSelectedItem() + "/"
				+ yearComboBox.getSelectedItem());
		return date;
	}

}
