import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame implements Runnable {
MainPanel mainPanel;
	
	public void run() {
		
		mainPanel = new MainPanel();
		JFrame frame = new JFrame("FlexBox"); // creates a JFrame with title
		frame.setSize(new Dimension(600,600)); // sets the width and height
		frame.setResizable(false); // not allowing to resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // every time opens the app in middle of the screen
		frame.add(mainPanel);
		frame.setVisible(true); // makes the frame visible
		
	}

	
	public static void main(String[] args)
	{
		new Thread(new App()).start(); // starts a new thread 
	}
}
