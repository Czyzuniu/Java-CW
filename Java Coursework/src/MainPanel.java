import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
private BottomPanel Bpanel;
private OrderPanel 	Opanel;


	public MainPanel()
	{
		init();
	}
	
	
	public void init()
	{
		Opanel = new OrderPanel("Order");
		Bpanel = new BottomPanel("bottomPanel", Opanel);
		
		
		Dimension size = getPreferredSize();
		size.width = 600;
		size.height = 600;
		setPreferredSize(size);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createTitledBorder(""));
		
		setLayout(new BorderLayout());
		
		EmptyPanel left = new EmptyPanel();
		EmptyPanel right = new EmptyPanel();
		EmptyPanel north = new EmptyPanel();
		
		add(Bpanel, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(north, BorderLayout.NORTH);
		add(Opanel, BorderLayout.CENTER);
		
		
		
	}
	
	
}
