package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndView extends View {
	private JButton closeGameButton;
	private JPanel endGamePanel;
	
	public EndView(){
		setFrame();
		
		endGamePanel = new JPanel();
		closeGameButton = new JButton("End Game");
		
		setEndGamePanel();
		setCloseGameButton();
		
		closeGameButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 frame.dispose(); //Close window
			  } 
		} );
		
		frame.revalidate();	
	}
	
	public void setEndGamePanel(){
		frame.add(endGamePanel);
		endGamePanel.setLayout(null);
		endGamePanel.setBackground(Color.black);
	}
	
	public void setCloseGameButton(){
		endGamePanel.add(closeGameButton);
		closeGameButton.setLocation(100,315);
		closeGameButton.setSize(400,50);
	}
}
