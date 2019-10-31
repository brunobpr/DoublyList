package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import View.*;

public class Controller implements ActionListener {
	private MainView mainView;
	
	public Controller() {
		mainView = new MainView(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
