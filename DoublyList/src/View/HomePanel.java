package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Controller.Controller;
import Model.Node;
import Model.Priority;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controller control;
	private Font font;
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JTextField findTextField = new JTextField(20);
	private JPanel contentPanel = new JPanel();
	private JPanel popupPanel = new JPanel();
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField passportTextField = new JTextField(20);
	private JTextField dateField = new JTextField(20);
	private String id;
	private JLabel jl = new JLabel();
	private int position;

	public HomePanel(Controller controller) {
		control = controller;
		buildHomePanel();
		setLayout(grid);
	}

	// This panel gives the option to search for a person by entering their ID
	// After clicking the button "FIND", a JOptionPane opens up.
	private void buildHomePanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(grid);
		JLabel jl = new JLabel("Search a person by ID");
		jl.setFont(font = new Font("Verdana", Font.BOLD, 18));
		JButton findButton = new JButton("FIND");
		findButton.addActionListener(control);
		findButton.setActionCommand("find_button_clicked");
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		topPanel.add(jl, gbc);
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		topPanel.add(findTextField, gbc);
		gbc.gridx = 1;
		topPanel.add(findButton, gbc);
		gbc.gridy = 0;
		gbc.gridx = 0;
		add(topPanel, gbc);
		gbc.weighty = 200;
		topPanel.setSize(new Dimension(40, 60));
	}

	/**
	 * This is the panel that opens up when the button "FIND" is clicked
	 * 
	 * @param position
	 *            position returned from DoublyList.checkPositionById()
	 * @param node
	 *            the 'person'
	 * @param errorMessage
	 *            An error message to be displayed if any"
	 */
	public void responsePanel(int position, Node node, String errorMessage) {
		// First option is that there is not a person with the ID given
		if (position < 1) {
			JOptionPane.showMessageDialog(this,
					"ID " + getFindTextField() + " does not match! Try a different ID.", "Person not found!",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			// The second option, there is a person with the ID
			buildPositionPanel(position, node, errorMessage);
		}

	}

	// In case the person is found, the user will be given the option to UPDATE them
	// This panel will also display the position.
	private void buildPositionPanel(int position, Node node, String errorMessage) {
		ImageIcon icon = new ImageIcon("logo.png");
		String name = node.getPerson().getFirstName();
		int update = JOptionPane.showOptionDialog(this, name + " is at position: " + position, "Person Found!",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,
				new String[] { "Update Info", "Close" }, "default");
		if (update == JOptionPane.OK_OPTION) {
			buildUpdateInfoPane(position, node, errorMessage);
		}

	}

	// If the user needs to UPDATE the person, a new panel will open up
	// In this new panel, it is possible to UPDATE or REMOVE the person.
	// It sets the current information into textfield giving the option to change
	// them
	// And while the input its not valid an error message is displayed
	public void buildUpdateInfoPane(int position, Node node, String errorText) {
		popupPanel.removeAll();
		this.position = position;
		JLabel errorMessage = new JLabel("");
		ImageIcon icon = new ImageIcon("logo.png");
		String firstName = node.getPerson().getFirstName();
		String lastName = node.getPerson().getLastName();
		String passport = node.getPerson().getPassport();
		String date = node.getPerson().getDate();
		id = node.getPerson().getId();
		JButton save = new JButton();
		JButton delete = new JButton();
		firstNameTextField.setText(firstName);
		lastNameTextField.setText(lastName);
		passportTextField.setText(passport);
		dateField.setText(date);
		save.addActionListener(control);
		save.setActionCommand("update_info_clicked");
		delete.addActionListener(control);
		delete.setActionCommand("delete_by_id_clicked");
		popupPanel.add(jl = new JLabel("Position: " + position));
		jl.setFont(font = new Font("Verdana", Font.BOLD, 14));
		popupPanel.add(jl = new JLabel("First name:"));
		popupPanel.add(firstNameTextField);
		popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.PAGE_AXIS));// a spacer
		popupPanel.add(jl = new JLabel("Last name:"));
		popupPanel.add(lastNameTextField);
		popupPanel.add(jl = new JLabel("Passport:"));
		popupPanel.add(passportTextField);
		popupPanel.add(jl = new JLabel("Date of arrival:"));
		popupPanel.add(dateField);
		if (errorText != null)
			errorMessage = new JLabel(errorText);
		errorMessage.setForeground(Color.RED);
		popupPanel.add(errorMessage);
		int joptPane = JOptionPane.showOptionDialog(null, popupPanel, "Update Information",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,
				new String[] { "Save", "Remove", "Close" }, "default");
		if (joptPane == 0) {
			save.doClick();
		} else if (joptPane == 1) {
			delete.doClick();
		}

	}

	public String getId() {
		return id;
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

	public String getDateField() {
		return dateField.getText();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFindTextField() {
		return findTextField.getText();
	}
}
