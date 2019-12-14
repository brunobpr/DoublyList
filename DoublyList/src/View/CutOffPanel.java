package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;

public class CutOffPanel extends JPanel {
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Controller control;
	private JTextField numberToCut;
	private JLabel jl;
	
	public CutOffPanel(Controller controller) {
		control = controller;
		setLayout(grid);
		
	}

	public void buildCutOffPanel(int size) {
		JPanel popupPanel = new JPanel();
		JButton removeButton = new JButton();
		removeButton.addActionListener(control);
		removeButton.setActionCommand("remove_from_the_end");
		popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.PAGE_AXIS));
		JLabel jl = new JLabel("Current queue size: 1020");
		numberToCut = new JTextField();
		popupPanel.add(jl = new JLabel("Current queue size: " + size));
		popupPanel.add(jl = new JLabel("How many people to be removed?"));
		popupPanel.add(numberToCut);
		ImageIcon icon = new ImageIcon("logo.png");
		int cut = JOptionPane.showOptionDialog(this, popupPanel , "Delete End of the Queue",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,
				new String[] { "Remove", "Cancel" }, "default");
		if (cut == JOptionPane.OK_OPTION) {
			removeButton.doClick();
		}
	}

	public int getNumberToCut() {
		return Integer.valueOf(numberToCut.getText());
	}
}

