package cm.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	private JFrame frame;
	private JPanel panel;
    private JButton[] answerButton;
    private JButton nextButton;
    private JLabel questionLable;
	
	public Window(){
		setFrame();
		setPanel();
		setLable();
		setAnswerButtons(); 	
	}
	
	public void setFrame(){
		frame = new JFrame("Title");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public void setPanel(){
		panel = new JPanel();
		frame.add(panel);
	}
	
	public void setLable(){
		questionLable = new JLabel();
		questionLable.setText("question");
		//questionLable.setHorizontalAlignment(200);
		//questionLable.setVerticalAlignment(100);
		frame.add(questionLable);
	}
	
	public void setAnswerButtons(){
		answerButton = new JButton[4];
		 
		for(JButton button : answerButton){
			panel.add(button);
		}
	}
	
	public void setNextButton(){
		nextButton = new JButton("Next");
		panel.add(nextButton);
	}
}
