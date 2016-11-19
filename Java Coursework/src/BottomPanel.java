import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends PanelModel{
private JButton addTo;
private JButton reset;
private JButton next;
private Submit submitOrder;
private Reset resetOrder;
private OrderPanel oPanel;
private InvoicePanel iPanel;
private LogPanel lPanel;

	public BottomPanel(String border) {
		super(border);
		setLayout(new BorderLayout());
		resetButton();
		nextButton();
		setBackground(Color.LIGHT_GRAY);
		
	}
	
	public void linkPanels(OrderPanel oPanel, InvoicePanel iPanel, LogPanel lPanel)
	{
		this.oPanel = oPanel;
		this.iPanel = iPanel;
		this.lPanel = lPanel;
	}
	
	
	public void addToButton()
	{
		addTo = new JButton("Add to basket");
		this.submitOrder = new Submit(oPanel, lPanel);
		addTo.addActionListener(submitOrder);
		add(addTo, BorderLayout.CENTER);
	}
	
	public void resetButton()
	{
		reset = new JButton("Reset");
		resetOrder = new Reset(oPanel);
		reset.addActionListener(resetOrder);
		add(reset,BorderLayout.WEST);
	}
	
	
	
	public void nextButton()
	{
		next = new JButton("Next");
		add(next,BorderLayout.EAST);
		
		next.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				
				oPanel.setVisible(false);
				iPanel.setVisible(true);
				iPanel.printBasketInfo(BasketInfo());
				hidePanels();
			}
			
		});
		
	}
	
	public void hidePanels()
	{
		if(oPanel.isVisible()){
			setVisible(true);
			lPanel.setVisible(true);
		}
		else
		{
			setVisible(false);
			lPanel.setVisible(false);
		}
	}
	
	public String BasketInfo()
	{
		String information = "Your basket currently has " +  oPanel.basketSize() + " boxes ";
		
		return information;
	}
}
