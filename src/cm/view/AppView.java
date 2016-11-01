package cm.view;

import javax.swing.JFrame;

public class AppView {
	
	
	
	private JFrame frame;
	
	public AppView(){
		frame = new JFrame("Test");
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
