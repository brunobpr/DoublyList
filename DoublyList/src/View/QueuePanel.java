package View;

import java.awt.Font;
import javax.swing.BoxLayout;
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
		table.getColumn("Name").setPreferredWidth(175);
		table.getColumn("Priority").setPreferredWidth(30);
		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}

}
