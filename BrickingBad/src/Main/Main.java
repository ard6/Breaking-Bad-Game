package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import UI.GameEngine;
import UI.GameScreen;
import UI.HelpText;


 class BuildMode implements Runnable, ActionListener {
	 public Boolean startGame= false;
	 
	 private int sb;
	 private int hmb;
	 private int mb;
	 private int wb;

	@Override
	public void run() {
		
		GameScreen game = new GameScreen();
		GameEngine gameEngine = new GameEngine();
		HelpText text = new HelpText();
		 
		Thread  thread2 = new Thread(game);
		Thread  thread = new Thread(this);
		
		JFrame window=new JFrame("Building Mode");
		JButton start = new JButton("<html> <h3 style=\"color:black;\">Start </h3> </html>");
		JTextArea simplenumber= new JTextArea(1,5);
		JTextArea hmbnumber= new JTextArea(1,5);
		JTextArea minenumber= new JTextArea(1,5);
		JTextArea wrappernumber= new JTextArea(1,5);
		JLabel help = new JLabel(text.helpText);
		JLabel sbLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Simple Bricks</h4> </html>");
		JLabel hmbLabel = new JLabel("<html> <h4 style=\"color:gray;\">#Half-Metal Bricks</h4> </html>");
		JLabel mbLabel = new JLabel("<html> <h4 style=\"color:red;\">#Mine Bricks</h4> </html>");
		JLabel wbLabel = new JLabel("<html> <h4 style=\"color:rgb(255, 175, 190);\">#Wrapper Bricks</h4> </html>");
		simplenumber.setText("5");
		hmbnumber.setText("3");
		minenumber.setText("1");
		wrappernumber.setText("3");
		JPanel panel= new JPanel();
		panel.setSize(300,300);
		
		window.setBounds(10, 10, 700 , 600 );
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		panel.add(sbLabel);
		panel.add(hmbLabel);
		panel.add(mbLabel);
		panel.add(wbLabel);
		panel.add(simplenumber);
		panel.add(hmbnumber);
		panel.add(minenumber);
		panel.add(wrappernumber);
		
		sbLabel.setBounds(150, 50, 150, 15);
		simplenumber.setBounds(265, 50, 100, 15);
		hmbLabel.setBounds(150, 70, 150, 15);
		hmbnumber.setBounds(265,70,100,15);
		minenumber.setBounds(265,90,100,15);
		mbLabel.setBounds(150, 90, 150, 15);
		wrappernumber.setBounds(265,110,100,15);
		wbLabel.setBounds(150, 110, 150, 15);
		
		window.add(panel,BorderLayout.CENTER);
		panel.add(start);
		start.setBackground(Color.green);
		start.setBounds(370, 50, 100, 75);
		panel.add(help);
		help.setBounds(265, 130, 200, 400);

		window.setVisible(true);
		start.addActionListener (new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				 sb=Integer.parseInt(simplenumber.getText());
				 hmb=Integer.parseInt(hmbnumber.getText());
				 mb=Integer.parseInt(minenumber.getText());
				 wb=Integer.parseInt(wrappernumber.getText());
				if(sb>=5 && hmb>=3 && mb>=1 && wb>= 3 && (sb+hmb+mb+wb)<42) {

				
					gameEngine.setNumberSB(sb);
					gameEngine.setNumberHMB(hmb);
					gameEngine.setNumberMB(mb);
					gameEngine.setNumberWB(wb);
					thread2.start();	
				}
			}
			});
		
	}
	public Boolean getStartGame() {
		return startGame;
	}
	public void setStartGame(Boolean startGame) {
		this.startGame = startGame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Main {
	
	 
	
	public static void main(String[] args) {
	
		 BuildMode runnable =new BuildMode();
			Thread  thread = new Thread(runnable);
		
		 thread.start();
		 
	

	}
	
}