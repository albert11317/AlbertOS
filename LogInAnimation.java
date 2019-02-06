import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class LogInAnimation extends JPanel{

	private static final long serialVersionUID = 1L;
	private boolean playMusic = false;
	private String UserName = "";
	private AudioInputStream firstTone;
	private Clip music;
	private int i = 0;
	private int width;
	private int height;
	private JFrame fr;
	private Windows windows;
	
	// Constructor
	public LogInAnimation(int w, int h, String userName, JFrame f)
	{
		UserName = userName;
		super.setOpaque(true);
		super.setBackground(Color.BLACK);
		super.setPreferredSize(new Dimension(w, h));
		width = w;
		height = h;
		fr = f;
		//System.out.println("logoffing");
	}
	
	public void start()
	{
		for (i = 0; i<630; i++) //initial i = 0
		{
			repaint();
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//System.out.print("Windows about to start...");
		fr.remove(this);
		windows = new Windows(width, height, fr);
		fr.add(windows);
		fr.pack();
		fr.revalidate();
		//windows.start();
	}


	// Perform any custom painting (if necessary) in this method
	@Override
	public void paintComponent(Graphics g)
	{
		//System.out.append("asfdg");
		String Line1 ="Welcome " + UserName + "...";
		g.setColor(Color.black);
		g.fillRect(0,0, width, height);
		g.setColor(Color.white);

		if (i>0&&i<255)
		{
			g.setColor(new Color(i,i,i));
			Font StartFont = new Font("Edwardian Script ITC", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line1, 550, 350);
		}
		if (i==255)
		{
			playMusic = true;
		}
		if (i>254&&i<509)
		{
			g.setColor(new Color(255-(i-254),255-(i-254),255-(i-254)));
			Font StartFont = new Font("Edwardian Script ITC", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString(Line1, 550, 350);
		}
		//---------------------------------------MUSIC---------------------------------------//
		if (playMusic==true)
		{
			playMusic=false;
		try {
			music = AudioSystem.getClip();
			firstTone = AudioSystem.getAudioInputStream(getClass().getResource("Zen Buddhist Temple Bell-SoundBible.com-331362457.wav"));
			music.open(firstTone);
			music.start();
			}
			catch (LineUnavailableException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			catch (UnsupportedAudioFileException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}