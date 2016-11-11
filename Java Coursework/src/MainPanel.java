import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

public class MainPanel extends PanelModel{
private BottomPanel Bpanel;
private OrderPanel 	Opanel;

	public MainPanel()
	{
		init();
	}
	
	
	public void init()
	{
		InvoicePanel Ipanel = new InvoicePanel("Invoice", 500,450);
		Opanel = new OrderPanel("Order", 500,450);
		Bpanel = new BottomPanel("bottomPanel", Opanel, Ipanel);
		
		
		
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
		EmptyPanel center = new EmptyPanel();
		
		add(Bpanel, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		center.add(Opanel);
		center.add(Ipanel);
		
		
	}
	
	
}
