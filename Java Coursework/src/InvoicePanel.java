import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class InvoicePanel extends PanelModel {
	
private JButton backButton;
private JTextArea textArea;
private OrderPanel oPanel;
private BottomPanel bPanel;
private JButton checkOut;

	public InvoicePanel(String border , int width, int height)
	{
		super(border, width, height);
	
		setLayout(new BorderLayout());
		setVisible(false);
		createBackButton();
		createTextField();
		createCheckOut();
	}
	
	public void linkPanels(OrderPanel oPanel, BottomPanel bPanel)
	{
		this.oPanel = oPanel;
		this.bPanel = bPanel;
	}
	
	
	public void createBackButton()
	{
		backButton = new JButton("add something else?");
		add(backButton,BorderLayout.NORTH);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				oPanel.setVisible(true);
				bPanel.hidePanels();
			}
			
		});
		
	}
	
	public void createCheckOut()
	{
		checkOut = new JButton("Checkout");
		checkOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				checkOut();
				
			}
			
		});
		add(checkOut,BorderLayout.SOUTH);
		
		
	}
	
	public void createTextField()
	{
		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createTitledBorder("Invoice TextBox"));
		add(textArea, BorderLayout.CENTER);
		
	}
	
	public void printBasketInfo(String info){
		textArea.setText(info);
	}
	
	public void checkOut()
	{
		double total = 0;
		for(BoxModel b: oPanel.getBasket())
		{
			b.calculateCost();
			total += b.getCost();
		}
		
		textArea.setText("Total cost of your order is : " + total);
	}
	
}
