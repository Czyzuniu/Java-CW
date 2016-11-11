import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends PanelModel{
private JButton addTo;
private JButton reset;
private JButton checkOut;
private Submit submitOrder;
private Reset resetOrder;
private OrderPanel oPanel;
private InvoicePanel iPanel;

	public BottomPanel(String border, OrderPanel oPanel, InvoicePanel iPanel) {
		super(border);
		this.oPanel = oPanel;
		this.iPanel = iPanel;
		resetButton();
		addToButton();
		checkOutButton();
	
	}

	
	public void addToButton()
	{
		
		addTo = new JButton("Add to basket");
		submitOrder = new Submit(oPanel, iPanel);
		addTo.addActionListener(submitOrder);
		addTo.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				checkOut.setVisible(true);
				
			}
			
		});
		add(addTo);
		
	}
	
	public void resetButton()
	{
		reset = new JButton("Reset");
		resetOrder = new Reset(oPanel);
		reset.addActionListener(resetOrder);
		add(reset);
	}
	
	
	
	public void checkOutButton()
	{
		checkOut = new JButton("Checkout");
		add(checkOut);
		checkOut.setVisible(false);
		checkOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				
				oPanel.setVisible(false);
				iPanel.setVisible(true);
			}
			
		});
		
	}
	
}
