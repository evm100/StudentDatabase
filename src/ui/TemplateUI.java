package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TemplateUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	protected int totalButtons = 1;
	protected int buttonHeight = 20;
	
	public TemplateUI()
	{
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//Back
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				close();
			}
		});
		btnExit.setBounds(20, 330, 60, 30);
		btnExit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		getContentPane().add(btnExit);
		
		JLabel lblGame = new JLabel(name());
		lblGame.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblGame.setBounds(10, 11, 200, 14);
		getContentPane().add(lblGame);
	}
	
	public void close() 
	{
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
		setVisible(false);
	}
	
	public String name() 
	{
		return "NOT IMPLEMENTED";
	}
	
	public int spaceButtons(int button)
	{
		int space = 375/(totalButtons+2);
		return space*(2*button+1)/2-(buttonHeight/2);
	}
}
