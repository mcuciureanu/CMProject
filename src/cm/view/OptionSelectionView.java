package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OptionSelectionView extends View{
	
	private String username;
	private JPanel optionSelectionPanel;
	private JLabel greetingLabel;
	private JLabel optionSelectionLabel;
	private final JButton[] optionButton;
	private boolean[] buttonAlreadyClicked;
	private JButton startGameButton;

	public OptionSelectionView(final String username){	
		this.username = username;

		optionSelectionPanel = new JPanel();
		greetingLabel = new JLabel("<html>Welcome, " + this.username + "!", SwingConstants.CENTER);
		optionSelectionLabel = new JLabel("Select a game theme: ", SwingConstants.CENTER);
		optionButton = new JButton[3];
		buttonAlreadyClicked = new boolean[3];
		Arrays.fill(buttonAlreadyClicked, true);
		startGameButton = new JButton("start");
		
		setFrame();
		setOptionSelectionPanel();
		setGreetingLabel();
		setOptionSelectionLabel();
		setOptionButton();
		setOptionButtonText();
		setStartGameButton();

		// needs improvement
		optionButton[0].addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(buttonAlreadyClicked[0]){
					  startGameButton.setEnabled(true);
					  buttonAlreadyClicked[0] = false;
				  }else{ 
					  startGameButton.setEnabled(false);
					  buttonAlreadyClicked[0] = true;
				  }
				  optionButton[1].setEnabled(buttonAlreadyClicked[0]);
				  optionButton[2].setEnabled(buttonAlreadyClicked[0]);
			  } 
		} );
		
		optionButton[1].addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(buttonAlreadyClicked[1]){
					  buttonAlreadyClicked[1] = false;
					  startGameButton.setEnabled(true);
				  }else{ 
					  startGameButton.setEnabled(false);
					  buttonAlreadyClicked[1] = true;
				  }
				  optionButton[0].setEnabled(buttonAlreadyClicked[1]);
				  optionButton[2].setEnabled(buttonAlreadyClicked[1]);
			  } 
		} );
		
		optionButton[2].addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(buttonAlreadyClicked[2]){
					  buttonAlreadyClicked[2] = false;
					  startGameButton.setEnabled(true);
				  }else{ 
					  startGameButton.setEnabled(false);
					  buttonAlreadyClicked[2] = true;
				  }
				  optionButton[0].setEnabled(buttonAlreadyClicked[2]);
				  optionButton[1].setEnabled(buttonAlreadyClicked[2]);
			  } 
		} );
		
		startGameButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  optionSelectionPanel.setVisible(false);
				  new GameView(username);
			  } 
		} );
		
		frame.revalidate();	
	}
	
	public void setOptionSelectionPanel(){
		frame.add(optionSelectionPanel);
		optionSelectionPanel.setLayout(null);
		optionSelectionPanel.setBackground(Color.white);
		optionSelectionPanel.add(greetingLabel);
		optionSelectionPanel.add(optionSelectionLabel);
		optionSelectionPanel.add(startGameButton);
	}
	
	public void setGreetingLabel(){
		greetingLabel.setLocation(0,10);
		greetingLabel.setSize(600,50);
	}
	
	public void setOptionSelectionLabel(){
		optionSelectionLabel.setLocation(0,60);
		optionSelectionLabel.setSize(600,50);
	}
	
	public void setStartGameButton(){
		startGameButton.setEnabled(false);
		startGameButton.setBackground(Color.white);
		startGameButton.setLocation(100,315);
		startGameButton.setSize(400,50);
	}
	
	public void setOptionButton(){
		for(int index = 0; index < optionButton.length; index++){
			optionButton[index] = new JButton();
			optionButton[index].setSize(150,200);
			optionButton[index].setLocation(setButtonXLocation(index), setButtonYLocation(index));
			optionSelectionPanel.add(optionButton[index]);
		}
	}
	
	public int setButtonXLocation(int index){
		if(index == 0)
			return 62;
		else if(index == 1)
			return 222;
		else
			return 382;
	}
	
	public int setButtonYLocation(int index){
		return 100;
	}
	
	public void setOptionButtonText(){
		optionButton[0].setText("Option 1");
		optionButton[1].setText("Option 2");
		optionButton[2].setText("Option 3");
		//...
	}
}
