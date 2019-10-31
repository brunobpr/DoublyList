package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
		private GridBagConstraints gbc = new GridBagConstraints();
		private Font font;
		private GridBagLayout grid = new GridBagLayout();
		private JPanel mainPanel;
		public MainView(Controller controller) {
				control = controller;
				buildFrame();
				showMenu();
				
		}

		private void buildFrame() {
			mainPanel = new JPanel();
			GridBagLayout grid = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			font = new Font("arial", Font.BOLD, 14);
			setSize(800, 600);
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);
			
			//	add(mainPanel, BorderLayout.WEST);
			//Left hand side panel which will holds all the buttons needed
			
		}
		
		public void showMenu() {
			/*searchButton
			register
			next
			queue
			cut*/
			JPanel buttons = new JPanel();
			JButton searchButton = new JButton("FIND");
			JButton register = new JButton("REGISTER");
			JButton next = new JButton("NEXT");
			JButton queue = new JButton("SHOW QUEUE");
			JButton cut = new JButton("REMOVE PEOPLE");
			register.setPreferredSize(new Dimension(250, 20));
			searchButton.setPreferredSize(new Dimension(250, 20));
			searchButton.setPreferredSize(new Dimension(250, 20));
			register.setPreferredSize(new Dimension(250, 20));
			next.setPreferredSize(new Dimension(250, 20));
			queue.setPreferredSize(new Dimension(250, 20));
			cut.setPreferredSize(new Dimension(250, 20));
			buttons.setLayout(grid);
			gbc.gridx = 0;
			gbc.gridy = 0;
			buttons.add(jl = new JLabel("SEARCH FOR A PERSON"), gbc);
			jl.setFont(font);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.ipady = 200;
			buttons.add(search, gbc);
			gbc.ipady = 0;
			gbc.gridx = 0;
			gbc.gridy = 2;
			buttons.add(searchButton, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			buttons.add(register, gbc);
			gbc.gridx = 0;
			gbc.gridy = 4;
			buttons.add(next, gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			buttons.add(queue, gbc);
			gbc.gridx = 0;
			gbc.gridy = 6;
			buttons.add(cut, gbc);
			buttons.setBackground(Color.GRAY);
			add(buttons, BorderLayout.WEST);
			mainPanel.setBackground(Color.GRAY);
			validate();
			repaint();
		}
}
