package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;

public class HomePanel extends JPanel {
	
	private Controller control;
	public HomePanel(Controller controller) {
		control = controller;
		buildHomePanel();
	}
	
	private void buildHomePanel() {
		JLabel jl = new JLabel("Home");
		add(jl);
		setBackground(Color.GREEN);
		setSize(new Dimension(40, 600));
	}
	
	
	
}
