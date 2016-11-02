package cm.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//
public class AppView {
	private JFrame frame;
	private JPanel panel;
	private JLabel usernameLabel;
	private JLabel scoreLabel;
	private JLabel label;
	private JLabel timeLabel;
	private JButton startButton;
	private JButton[] answerButton;
	
	/**
	 * 
	 */
	public AppView(){
		frame = new JFrame();
		panel = new JPanel();
		usernameLabel = new JLabel("username: *****", SwingConstants.LEFT);
		scoreLabel = new JLabel("score: 0", SwingConstants.RIGHT);
		label = new JLabel("Question", SwingConstants.CENTER);
		timeLabel = new JLabel("0:00", SwingConstants.CENTER);
		startButton = new JButton();
		answerButton = new JButton[4];
		
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.add(label);
		panel.add(startButton);
		panel.add(timeLabel);
		panel.add(scoreLabel);
		panel.add(usernameLabel);
		
		for(int index = 0; index < answerButton.length; index++){
			answerButton[index] = new JButton();
			answerButton[index].setSize(270,50);
			answerButton[index].setLocation(setAnswerButtonXLocation(index), setAnswerButtonYLocation(index));
			panel.add(answerButton[index]);
		}
		
		setAnwerButtonsText();
		
		usernameLabel.setBackground(Color.BLACK);
		usernameLabel.setLocation(22,10);
		usernameLabel.setSize(120,20);
		
		scoreLabel.setBackground(Color.blue);
		scoreLabel.setLocation(10,30);
		scoreLabel.setSize(58,20);
		
		label.setBackground(Color.blue);
		label.setLocation(0,100);
		label.setSize(592,50);
	
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setLocation(0,317);
		timeLabel.setSize(592,50);
		
//		startButton.setBackground(Color.white);
//		startButton.setText("Start");
//		startButton.setLocation(200,200);
//		startButton.setSize(200,100);
//			
//		pressStartButton();
		
		frame.setSize(600,400);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int setAnswerButtonXLocation(int index){
		if(index % 2 == 0)
			return 23;
		else
			return 300;
	}
	
	public int setAnswerButtonYLocation(int index){
		if(index < 2)
			return 210;
		else
			return 265;
	}
	//...
	public void setAnwerButtonsText(){
		answerButton[0].setText("A");
		answerButton[1].setText("B");
		answerButton[2].setText("C");
		answerButton[3].setText("D");
	}
	
	public void pressStartButton(){
		startButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    startButton.setVisible(false);
			  } 
			} );
	}
}