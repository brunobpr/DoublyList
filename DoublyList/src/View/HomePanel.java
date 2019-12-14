package View;
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

public class HomePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Controller control;
	private Font font;
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JTextField findTextField = new JTextField(20);
	private JPanel contentPanel = new JPanel();
	private Node personFound;
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField passportTextField = new JTextField(20);
	private String id;
	private int position;

	public HomePanel(Controller controller) {
		control = controller;
		buildHomePanel();
		setLayout(grid);
	}

	private void buildHomePanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(grid);
		JLabel jl = new JLabel("Search a person by ID");
		jl.setFont(font = new Font("Verdana", Font.BOLD, 18));
		JButton findButton = new JButton("FIND");
		findButton.addActionListener(control);
		findButton.setActionCommand("find_button_pressed");
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

	public String getFindTextField() {
		return findTextField.getText();
	}

	public void responsePanel(int position, Node node) {
		if (position < 1) {
			JOptionPane.showMessageDialog(this, "ID " + this.getFindTextField() + " does not exist! Try a different ID.",
					"Person not found!", JOptionPane.PLAIN_MESSAGE);
		} else {
			buildPositionPanel(position, node);
		}

	}

	private void buildPositionPanel(int position, Node node) {
		ImageIcon icon = new ImageIcon("logo.png");
		String name = node.getPerson().getFirstName();
		int update = JOptionPane.showOptionDialog(this, name+" is at position: " + position, "Person Found!",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,
				new String[] { "Update Info", "Close" }, "default");
		if (update == JOptionPane.OK_OPTION) {
			buildUpdateInfoPane(position, node);
		}
		
	}

	private void buildUpdateInfoPane(int position, Node node) {
		this.position = position;
		ImageIcon icon = new ImageIcon("logo.png");
		JLabel jl = new JLabel("Position: " + position);
		jl.setFont(font = new Font("Verdana", Font.BOLD, 14));
		String firstName = node.getPerson().getFirstName();
		String lastName = node.getPerson().getLastName();
		String passport = node.getPerson().getPassport();
		id = node.getPerson().getId();
		JButton save = new JButton();
		JButton delete = new JButton();
		firstNameTextField.setText(firstName);
		lastNameTextField.setText(lastName);
		passportTextField.setText(passport);
		JPanel myPanel = new JPanel();
		save.addActionListener(control);
		save.setActionCommand("update_info_clicked");
		delete.addActionListener(control);
		delete.setActionCommand("delete_by_id_clicked");
		myPanel.add(jl);
		myPanel.add(new JLabel("First name:"));
		myPanel.add(firstNameTextField);
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));// a spacer
		myPanel.add(new JLabel("Last name:"));
		myPanel.add(lastNameTextField);
		myPanel.add(new JLabel("Passport:"));
		myPanel.add(passportTextField);
		int joptPane = JOptionPane.showOptionDialog(null, myPanel, "Update Information",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,
				new String[] { "Save and Close", "Delete", "Close" }, "default");
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
	
	public void setId(String id) {
		this.id = id;
	}

}
