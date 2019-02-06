import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class StartUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean playMusic = false;
	private boolean playMusic2 = false;
	private AudioInputStream Pirates;
	private AudioInputStream firstTone;
	private Clip music;
	private int i = 0;
	private Image backGround;
	private LogIn login;
	private JFrame fr;

	// Constructor
	public StartUp(int w, int h, JFrame f) {
		super.setOpaque(true);
		super.setPreferredSize(new Dimension(w, h));
		super.setBackground(Color.BLACK);
		backGround = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("DSC00593samll.jpg"));
		fr = f;
	}

	public void start() {
		for (i = 0; i < 180; i++) // initial i = 0
		{
			repaint();
			try {
				Thread.sleep(40); // should be 25
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (i = 180; i < 4400; i++) // initial i = 0
		{
			repaint();
			try {
				Thread.sleep(25); // should be 25
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		fr.remove(this);
		login = new LogIn(1366, 768, fr);
		fr.add(login);
		fr.pack();
		fr.revalidate();
		login.start();
	}

	// Perform any custom painting (if necessary) in this method
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(i);
		String Line1 = "Welcome Friends...";
		String Line2 = "...To the Future";
		String Line3 = "AlbertOS";
		String Line4 = "Loading...";

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.white);
		if (i == 80) {
			playMusic = true;
		}
		if (i > 120 && i < 375) {
			g.setColor(new Color(i - 120, i - 120, i - 120));
			Font StartFont = new Font("Edwardian Script ITC", Font.ITALIC, 48);
			g.setFont(StartFont);
			g.drawString(Line1, 200 + (i), 200);
		}
		if (i > 374 && i < 629) {
			g.setColor(new Color(255 - (i - 374), 255 - (i - 374),
					255 - (i - 374)));
			Font StartFont = new Font("Edwardian Script ITC", Font.ITALIC, 48);
			g.setFont(StartFont);
			g.drawString(Line1, 200 + (i), 200);
		}
		if (i > 750 && i < 1005) {
			g.setColor(new Color((i - 750), (i - 750), (i - 750)));
			Font StartFont = new Font("Edwardian Script ITC", Font.ITALIC, 48);
			g.setFont(StartFont);
			g.drawString(Line2, 1600 - (i), 500);
		}
		if (i > 1004 && i < 1259) {
			g.setColor(new Color(255 - (i - 1004), 255 - (i - 1004),
					255 - (i - 1004)));
			Font StartFont = new Font("Edwardian Script ITC", Font.ITALIC, 48);
			g.setFont(StartFont);
			g.drawString(Line2, 1600 - (i), 500);
		}
		if (i == 1400) {
			playMusic2 = true;
		}
		if (i > 1400 && i < 4075) {
			g.setColor(Color.WHITE);
			Font StartFont = new Font("Comic Sans MS", Font.PLAIN, 180);
			g.setFont(StartFont);
			g.drawString(Line3, 250, 400);
		}
		if (i > 2800 && i < 3055) {
			g.setColor(new Color((i - 2800), (i - 2800), (i - 2800)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
		}

		if (i > 3054 && i < 3309) {
			g.setColor(new Color(255 - (i - 3054), 255 - (i - 3054),
					255 - (i - 3054)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
		}

		if (i > 3310 && i < 3565) {
			g.setColor(new Color((i - 3310), (i - 3310), (i - 3310)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
		}

		if (i > 3564 && i < 3819) {
			g.setColor(new Color(255 - (i - 3564), 255 - (i - 3564),
					255 - (i - 3564)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
		}

		if (i > 3820 && i < 4075) {
			g.setColor(new Color((i - 3820), (i - 3820), (i - 3820)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
		}

		if (i > 4074 && i < 4329) {
			g.setColor(new Color(255 - (i - 4074), 255 - (i - 4074),
					255 - (i - 4074)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line4, 600, 600);
			StartFont = new Font("Comic Sans MS", Font.PLAIN, 180);
			g.setFont(StartFont);
			g.drawString(Line3, 250, 400);
		}

		if (i > 4330 && i < 4400) {
			g.drawImage(backGround, 3, -5, super.getWidth(), super.getHeight(),
					this);
		}

		// ---------------------------------------MUSIC---------------------------------------//

		if (playMusic == true) {
			playMusic = false;
			try {
				// System.out.println("help");
				music = AudioSystem.getClip();
				firstTone = AudioSystem.getAudioInputStream(getClass()
						.getResource("Katniss.wav"));
				Pirates = AudioSystem.getAudioInputStream(getClass()
						.getResource("pirates_of_caribbean.wav"));
				music.open(firstTone);
				music.start();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Stop old music and Start Pirates
		if (playMusic2 == true) {
			playMusic2 = false;
			try {
				music.stop();
				music.close();
				music.open(Pirates);
				music.start();
			} catch (NullPointerException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("nullpointerexception at playmusic2");
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Line Unavailable at playmusic2");
			}

		}
	}

}