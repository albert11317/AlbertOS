import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class LeaveAnimation extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int i = 0;
	private int width;
	private int height;
	
	// Constructor
	public LeaveAnimation(int w, int h, boolean shutDown, JFrame f)
	{
		super.setOpaque(true);
		super.setBackground(Color.BLACK);
		super.setPreferredSize(new Dimension(w, h));
		width = w;
		height = h;
		//System.out.println("Constructor");
	}

	public void start()
	{
		//System.out.println("start method");
			for (i = 0; i<509; i++)
			{
				//System.out.println("second step");
				this.paintComponent(getGraphics());
				//super.repaint(); //shutdown doesn't work otherwise
				try
				{
					Thread.sleep(10); //CANT GO NO FASTER!!!!
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
				System.exit(0);
		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		//System.out.println("paint component");
		//just for Shutdown
		g.setColor(Color.black);
		g.fillRect(0,0, width, height);
		g.setColor(Color.white);

		if (i>0&&i<255)
		{
			g.setColor(new Color(i,i,i));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString("Goodnight.",550, 350);
		}
		if (i>254&&i<509)
		{
			g.setColor(new Color(255-(i-254),255-(i-254),255-(i-254)));
			Font StartFont = new Font("Algerian", Font.PLAIN, 48);
			g.setFont(StartFont);
			g.drawString("Goodnight.",550, 350);
		}
	}
}