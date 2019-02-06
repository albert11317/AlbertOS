import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Windows extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	Font font = new Font("Times New Roman", Font.PLAIN, 28);
	private Image backGround;
	private Image logOffIcon;
	private Image shutDownIcon;
	private Image paintIcon;
	private Image notepadIcon;
	private Image calculatorIcon;
	private Image reversi;
	private int width;
	private int height;
	private boolean shutdown = false;
	private boolean logoff = false;
	private JFrame fr;
	private LeaveAnimation leave;
	private Notepad n;
	private Paint p;
	private Calculator c;
	private Othello o;
	private LogIn login;

	// private boolean starts;

	public Windows(int w, int h, JFrame f) {
		super.setOpaque(true);
		super.setPreferredSize(new Dimension(w, h));
		super.setBackground(Color.BLACK);
		super.addMouseListener(this);
		width = w;
		height = h;
		fr = f;
		// starts = true;
		backGround = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("DSC02251.jpg"));
		logOffIcon = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("LogOff.png"));
		shutDownIcon = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("Shutdown.png"));
		paintIcon = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("paint.png"));
		notepadIcon = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("notepad.png"));
		calculatorIcon = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("calculator.png"));
		reversi = Toolkit.getDefaultToolkit().getImage(
				super.getClass().getResource("Reversi.png"));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// if (starts)
		{
			g.drawImage(backGround, 0, 0, width, height, this); // I'm trying to make them all match up, but this guy is being a dick
			 g.drawImage(shutDownIcon, 1110, 0, 200, 200, this);
			 g.drawImage(logOffIcon, 1110, 250, 200, 200, this);
			    g.drawImage(reversi, 1110, 500, 200, 200, this);
			     g.drawImage(notepadIcon, 0, 0, 200, 200, this);
			     g.drawImage(paintIcon, 0, 250, 200, 200, this);
			g.drawImage(calculatorIcon, 0, 500, 200, 200, this);
			// ImageObserver observer = null;
			// System.out.println(backGround.getHeight(observer));
			// starts = false;
		}
		
		if (shutdown || logoff)
		{
			g.setColor(Color.yellow);
			g.fillRect(0, 0, width, height);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2 && e.getX() >= 1110 && e.getX() <= 1310 && e.getY() >= 0 && e.getY() <= 200)
		{
			// System.out.println("Shutdown sequence activated");
			// Shutdown
			shutdown = true;
			// repaint();
			fr.remove(this);
			leave = new LeaveAnimation(1366, 768, true, fr);
			fr.add(leave);
			fr.pack();
			fr.revalidate();
			leave.start();
			// draw dialog box making sure it is ok to log off
		}
		
		else if (e.getClickCount() >= 2 && e.getX() >= 1110 && e.getX() <= 1310 && e.getY() >= 250 && e.getY() <= 450)
		{
			// Logoff, bitch
			// System.out.println("Logoff sequence activated");
			// fr.remove(this);
			// repaint();
			JFrame frame = new JFrame("AlbertOS");
			login = new LogIn(width, height, frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(login, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			login.start();
			fr.dispose();
			// draw dialog box making sure it is ok to log off
		}
		
		else if (e.getClickCount() >= 2 && e.getX() >= 1110 && e.getX() <= 1310 && e.getY() >= 500 && e.getY() <= 700)
		{
			// START MOTHERFUCKING REVERSI BITCHES!!?!?!?!?!
			// System.out.println("Othello sequence activated");
			JFrame frame = new JFrame("Othello (Reversi)");
			o = new Othello(1366, 768, frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(o, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			// o.newGame();
		}
		
		else if (e.getClickCount() >= 2 && e.getX() >= 0 && e.getX() <= 250 && e.getY() >= 0 && e.getY() <= 200)
		{
			// run notepad
			// System.out.println("Notepad sequence activated");
			JFrame frame = new JFrame("Notepad");
			n = new Notepad(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(n, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
		}
		
		else if (e.getClickCount() >= 2 && e.getX() >= 0 && e.getX() <= 250 && e.getY() >= 250 && e.getY() <= 450)
		{
			// run paint
			// System.out.println("Paint sequence activated");
			// fr.remove(this);
			JFrame frame = new JFrame("Paint");
			p = new Paint(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
		}
		
		else if (e.getClickCount() >= 2 && e.getX() >= 0 && e.getX() <= 250 && e.getY() >= 500 && e.getY() <= 700)
		{
			// run calculator
			// System.out.println("Calculator sequence activated");
			JFrame frame = new JFrame("Calculator");
			c = new Calculator(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(c, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			// System.out.println("Starting Calculator");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
