import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPanel extends PanelModel{
private BottomPanel Bpanel;
private OrderPanel 	Opanel;
private InvoicePanel Ipanel;
private LogPanel Lpanel;

	public MainPanel()
	{
		init();
	}
	
	
	public void init()
	{
		Lpanel = new LogPanel("Logger", 100, 50);
		Opanel = new OrderPanel("Order", 500,450);
		Ipanel = new InvoicePanel("Invoice", 500,450);
		Bpanel = new BottomPanel("bottomPanel");
		
		
		Ipanel.linkPanels(Opanel, Bpanel);
		Bpanel.linkPanels(Opanel, Ipanel, Lpanel);
		Opanel.linkPanels(Bpanel, Ipanel, Lpanel);
		Bpanel.addToButton();

		
		Dimension size = getPreferredSize();
		size.width = 600;
		size.height = 600;
		setPreferredSize(size);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createTitledBorder(""));
		
		setLayout(new BorderLayout());
		
		EmptyPanel left = new EmptyPanel();
		EmptyPanel right = new EmptyPanel();
		EmptyPanel center = new EmptyPanel();
		
		add(Bpanel, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(Lpanel, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		center.add(Opanel);
		center.add(Ipanel);
		
		
	}
	
}
