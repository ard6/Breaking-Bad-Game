package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameScreen implements Runnable {
	

	ButtonPanel buttons = new ButtonPanel();
	
	JFrame window=new JFrame("Bricking Bad Game");
	JButton pause = new JButton("Pause/Resume");
	JButton quit= new JButton("Quit");
	JButton load= new JButton("Load");
	JButton save= new JButton("Save");
	
	private Clip music;
	
	public Clip getMusic() {
		return music;
	}
	
	public void setMusic(Clip music) {
		this.music = music;
	}
	
	@Override
	public void run() {
		
		GameEngine gamePlay = new GameEngine();
		
		try {
			URL url = this.getClass().getResource("missionimpossible.wav");
			AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			setMusic(AudioSystem.getClip());
			getMusic().open(audio);
			getMusic().loop(-1);
		} catch (Exception e) {
			System.out.println("Music can not be played.");
		}
		
		quit.addActionListener (new ActionListener () {
			 public void actionPerformed (ActionEvent e) {
			  System.exit(0);
			 }
			});
		pause.addActionListener (new ActionListener () {
			 public void actionPerformed (ActionEvent e) {
				 if(gamePlay.timer.isRunning()) {
					 gamePlay.timer.stop();
						
					}else {
						gamePlay.timer.restart();
					
					}
			 }
			});

		buttons.add(load);
		buttons.add(save);
		buttons.add(pause); 
		buttons.add(quit);
		  
		window.setBounds(10, 10, 700 , 620 );
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		window.add(buttons, BorderLayout.PAGE_START);

		window.add(gamePlay, BorderLayout.CENTER);
		window.setVisible(true);

	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	
	}
			
}