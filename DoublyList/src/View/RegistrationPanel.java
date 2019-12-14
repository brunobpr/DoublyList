package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField passportTextField = new JTextField(20);
	private JRadioButton highPriorityButton = new JRadioButton("High");
	private JRadioButton mediumPriorityButton = new JRadioButton("Medium");
	private JRadioButton lowPriorityButton = new JRadioButton("Low");

	public RegistrationPanel(Controller controller) {
		control = controller;
		setLayout(grid);
	}

	public void buildRegistrationPanel() {
		//resetForm();
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
		gbc.gridwidth = 4;
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
		ButtonGroup group = new ButtonGroup();
		group.add(highPriorityButton);
		group.add(mediumPriorityButton);
		group.add(lowPriorityButton);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		add(new JLabel("Priority:"), gbc);
		gbc.gridx = 1;
		add(highPriorityButton, gbc);
		gbc.gridx = 2;
		add(mediumPriorityButton, gbc);
		gbc.gridx = 3;
		add(lowPriorityButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		add(newPersonButton, gbc);
		lowPriorityButton.setSelected(true);
	}

	private void resetForm() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		passportTextField.setText("");
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
		if(highPriorityButton.isSelected()) {
		return Priority.HIGH;
		}else if(mediumPriorityButton.isSelected()) {
			return Priority.MEDIUM;
		}
		return Priority.LOW;
	}
	
}
