package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controller;

public class QueuePanel extends JPanel {
	private Controller control;
	private Font font;

	public QueuePanel(Controller controller) {
		control = controller;
	}

	public void buildQueuePanel(String[][] queue) {
		removeAll();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		String[] columnNames = {"Name", "ID","Passport", "Arrival Date","Priority" };
		JTable table = new JTable(queue, columnNames);
		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}

}
