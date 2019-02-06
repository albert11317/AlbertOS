import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class OperatingSystem extends JPanel{
	private static final long serialVersionUID = 1L;
	private static StartUp start;

	// Constructor
	public OperatingSystem(int w, int h, JFrame f) {
		super.setOpaque(true);
		super.setPreferredSize(new Dimension(1366, 768));
		super.setBackground(Color.BLACK);
		start = new StartUp(1366, 768, f);
		//Windows window = new Windows(1366, 768, f);
		this.add(start);
		//this.add(login);
	}
	
	public static void main(String[] args) 
	{
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame fr = new JFrame("Albert OS");
		fr.add(new OperatingSystem(1366, 768, fr));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocation(0, 0);
		fr.setResizable(true);
		fr.pack();
		fr.setVisible(true);
		start.start();
	}
}