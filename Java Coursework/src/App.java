import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame implements Runnable {

	
	public void run() {
		
		JFrame frame = new JFrame("FlexBox");
		frame.setSize(new Dimension(600,600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	
	public static void main(String[] args)
	{
		new Thread(new App()).start();
	}
}
