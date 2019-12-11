package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import View.*;

public class Controller implements ActionListener {
	private MainView mainView;

	public Controller() {
		MouseListener mouseListener = new MouseListener();
		mainView = new MainView(this, mouseListener);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	


}
