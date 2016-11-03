package cm.view;

import javax.swing.JFrame;

public class View implements IView{
	
	@Override
	public void setFrame() {
		frame.setSize(600,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
