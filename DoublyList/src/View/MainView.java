package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controller.Controller;
import Model.Person;

public class MainView extends JFrame {
	private Controller control;
	private JLabel jl = new JLabel();
	private ImageIcon icon = new ImageIcon();
	private GridBagConstraints gbc = new GridBagConstraints();
	public JPanel contentPanel = new JPanel();
	private JPanel smallInfoPanel = new JPanel();
	private Font font;
	private GridBagLayout grid = new GridBagLayout();
	public CardLayout cardLayout = new CardLayout();
	public HomePanel homePanel;
	public RegistrationPanel registrationPanel;
	public QueuePanel queuePanel;
	public CutOffPanel cutOffPanel;

	// This is the core frame of the application
	// It will always be seen while the app is running.
	// It contains a menu with: HOME, REGISTER, SHOW QUEU, CUT OFF and NEXT
	// Each buttons shows a different central panel, opens a new panel or update the
	// next person info
	public MainView(Controller controller) {
		control = controller;
		homePanel = new HomePanel(controller);
		registrationPanel = new RegistrationPanel(controller);
		queuePanel = new QueuePanel(controller);
		cutOffPanel = new CutOffPanel(controller);
		buildFrame();
		buildMenuPanel();
	}

	private void buildFrame() {
		font = new Font("arial", Font.BOLD, 32);
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		contentPanel.setLayout(cardLayout);
		// The contentPanel is the central panel, that is the only part of the window
		// that changes
		// It uses a card layout that allows to transit between panel easily
		contentPanel.add(homePanel, "Home");
		contentPanel.add(queuePanel, "Queue");
		contentPanel.add(registrationPanel, "Registration");
		contentPanel.add(cutOffPanel, "CutOff");
		contentPanel.setBackground(new Color(102, 204, 255));
		cardLayout.show(contentPanel, "Home");
		add(contentPanel, BorderLayout.CENTER);

	}

	public void buildMenuPanel() {
		JPanel buttons = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JButton homeButton = new JButton("HOME");
		JButton registrationButton = new JButton("REGISTER");
		JButton nextPersonButton = new JButton("NEXT >");
		JButton showQueueButton = new JButton("SHOW QUEUE");
		JButton cutOffQueueButton = new JButton("CUT QUEUE");
		homeButton.setPreferredSize(new Dimension(150, 30));
		registrationButton.setPreferredSize(new Dimension(150, 30));
		nextPersonButton.setPreferredSize(new Dimension(150, 30));
		showQueueButton.setPreferredSize(new Dimension(150, 30));
		cutOffQueueButton.setPreferredSize(new Dimension(150, 30));
		homeButton.addActionListener(control);
		registrationButton.addActionListener(control);
		nextPersonButton.addActionListener(control);
		showQueueButton.addActionListener(control);
		cutOffQueueButton.addActionListener(control);
		homeButton.setActionCommand("home");
		registrationButton.setActionCommand("registration");
		nextPersonButton.setActionCommand("next_person");
		showQueueButton.setActionCommand("show_queue");
		cutOffQueueButton.setActionCommand("cut_queue");
		buttons.setSize(new Dimension(40, 600));
		buttons.setLayout(grid);
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.ipady = 50;
		gbc.weighty = 1;
		buttons.add(jl = new JLabel(icon = new ImageIcon("logo.png")), gbc);
		gbc.ipady = 20;
		gbc.gridy = 1;
		gbc.weighty = 0;
		buttons.add(homeButton, gbc);
		gbc.gridy = 2;
		buttons.add(registrationButton, gbc);
		gbc.gridy = 3;
		buttons.add(showQueueButton, gbc);
		gbc.gridy = 4;
		buttons.add(cutOffQueueButton, gbc);
		gbc.gridy = 5;
		buttons.add(nextPersonButton, gbc);
		gbc.gridy = 6;
		gbc.weighty = 2;
		buttons.add(smallInfoPanel, gbc);
		buttons.setBackground(new Color(0, 0, 128));
		topPanel.setBackground(new Color(0, 0, 128));
		smallInfoPanel.setBackground(new Color(0, 0, 128));
		topPanel.setSize(new Dimension(800, 30));
		topPanel.add(jl = new JLabel("Immigration System"));
		rightPanel.setBackground(new Color(0, 0, 128));
		jl.setFont(font);
		jl.setForeground(Color.WHITE);
		add(buttons, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(rightPanel, BorderLayout.EAST);
		validate();
		repaint();
	}

	// This panel is updated after every click event
	// It is displayed at the bottom left side of the window if the queue is not
	// empty
	public void showSmallInfoPanel(Person person, int size) {
		if (person != null) {
			smallInfoPanel.removeAll();
			smallInfoPanel.add(jl = new JLabel("Next:"));
			jl.setForeground(Color.WHITE);
			smallInfoPanel.add(jl = new JLabel(person.getFirstName() + " " + person.getLastName()));
			jl.setFont(font = new Font("Arial", Font.BOLD, 14));
			jl.setForeground(Color.WHITE);
			smallInfoPanel.add(jl = new JLabel("Queue size:"));
			jl.setForeground(Color.WHITE);
			smallInfoPanel.add(jl = new JLabel(String.valueOf(size)));
			jl.setFont(font = new Font("Arial", Font.BOLD, 14));
			jl.setForeground(Color.WHITE);
			smallInfoPanel.setLayout(new BoxLayout(smallInfoPanel, BoxLayout.PAGE_AXIS));
			validate();
			repaint();
		}
	}

	public void refresh() {
		this.validate();
		this.repaint();
	}

}
