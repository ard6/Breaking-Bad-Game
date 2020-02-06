package UI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
	JPanel buttons = new JPanel();
	JButton pause = new JButton("Pause");
	
	public ButtonPanel() {
		buttons.setBackground(Color.white);
		buttons.add(pause);
	}
	
}
