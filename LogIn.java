import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;

public class LogIn extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image backGround;
	private Image java;
	private LogInWindow loginwindow;
	private LogInAnimation animation;
	private int width;
	private int height;
	private JFrame frame;
	boolean start = true;
	private String UserName = "No User Name :(";
	private boolean ints = true;
	
	public LogIn(int w, int h, JFrame f)
	{
		loginwindow = new LogInWindow(342, 192, 683, 384);
		super.setPreferredSize(new Dimension(w, h));
		super.setBackground(Color.YELLOW);
		width = w;
		height = h;
		frame = f;
	    backGround = Toolkit.getDefaultToolkit().getImage(super.getClass().getResource("DSC00593samll.jpg"));
	    java = Toolkit.getDefaultToolkit().getImage(super.getClass().getResource("java_powered.png"));
	    this.add(loginwindow);
	    //start();
	}
	
	public void start()
	{
		//System.out.println("Start logging");
		while (start)
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
		//System.out.println("login start..");
		}

		animation = new LogInAnimation(width, height, UserName, frame);
	    frame.remove(this);
		frame.add(animation);
		frame.pack();
		frame.revalidate();
		animation.start();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		//System.out.println("login repainting..");
		//System.out.println(start);
		if (ints)			//eSystem.out.println("login paint component (should happen twice if logging off)");
			ints = false;
		g.setColor(Color.white);
	    g.drawImage(backGround, 0, 0, width, height, this);
	    g.drawImage(java, 615, 500, 123, 170, this);
		    if (loginwindow.done())
		    {
		    	//System.out.println("leave repaint");
		    	start = false;
		    	UserName = loginwindow.UserName();
		    }
	}
}