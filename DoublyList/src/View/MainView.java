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

public class MainView extends JFrame{
		private Controller control;
		private JTextField search = new JTextField(20);
		private JLabel jl = new JLabel();
		private ImageIcon icon = new ImageIcon();
		private GridBagConstraints gbc = new GridBagConstraints();
		private JPanel contentPanel = new JPanel();
		private Font font;
		private GridBagLayout grid = new GridBagLayout();
		private MouseListener mouseListener; 
		public CardLayout cl = new CardLayout();
		public HomePanel homePanel;
		public RegistrationPanel registrationPanel;
		public MainView() {};
		
		public MainView(Controller controller, MouseListener mouseListener) {
				control = controller;
				homePanel = new HomePanel(controller);
				registrationPanel = new RegistrationPanel(controller);
				this.mouseListener = mouseListener;
				buildFrame();
				buildMenuPanel();
		}

		
		private void buildFrame() {
			font = new Font("arial", Font.BOLD, 32);
			setSize(800, 600);
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);
			contentPanel.setLayout(cl);
			contentPanel.add(homePanel, "Home");
			cl.show(contentPanel, "Home");
			//	add(mainPanel, BorderLayout.WEST);
			//Left hand side panel which will holds all the buttons needed
			add(contentPanel, BorderLayout.CENTER);
		}
		
		public void buildMenuPanel() {
			/*home
			register
			next
			queue
			cut*/
			ArrayList<Integer> i = new ArrayList<>();
			JPanel buttons = new JPanel();
			JPanel topPanel = new JPanel();
			JButton homeButton = new JButton("HOME");
			JButton registrationButton = new JButton("REGISTER");
			JButton nextPersonButton = new JButton("NEXT >");
			JButton showQueueButton = new JButton("SHOW QUEUE");
			JButton cutOffQueueButton = new JButton("REMOVE PEOPLE");
			homeButton.setPreferredSize(new Dimension(150, 30));
			registrationButton.setPreferredSize(new Dimension(150, 30));
			nextPersonButton.setPreferredSize(new Dimension(150, 30));
			showQueueButton.setPreferredSize(new Dimension(150, 30));
			cutOffQueueButton.setPreferredSize(new Dimension(150, 30));
			buttons.setSize(new Dimension(40, 600));
			buttons.setLayout(grid);
			gbc.gridy = 0;
			gbc.gridx = 0;	
			gbc.ipady = 50;
			buttons.add(jl = new JLabel(icon = new ImageIcon("logo.png")), gbc);
			gbc.ipady = 20;
			gbc.gridy = 1;
			buttons.add(homeButton, gbc);
			gbc.gridy = 2;
			buttons.add(registrationButton, gbc);
			gbc.gridy = 3;
			buttons.add(showQueueButton, gbc);
			gbc.gridy = 4;
			buttons.add(cutOffQueueButton, gbc);
			gbc.gridy = 5;
			buttons.add(nextPersonButton, gbc);
			buttons.setBackground(new Color(0, 0, 128));
			buttons.addMouseListener(mouseListener);
			topPanel.setBackground(new Color(0, 0, 128));
			topPanel.setSize(new Dimension(800, 30));
			topPanel.add(jl = new JLabel("Immigration System"));
			jl.setFont(font);
			jl.setForeground(Color.WHITE);
			add(buttons, BorderLayout.WEST);
			add(topPanel, BorderLayout.NORTH);
			validate();
			repaint();
		}
}
