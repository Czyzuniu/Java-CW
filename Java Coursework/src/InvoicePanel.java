import java.awt.BorderLayout;
import java.awt.Color;
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
private LogPanel lPanel;
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
	
	public void linkPanels(OrderPanel oPanel, BottomPanel bPanel, LogPanel lPanel)
	{
		this.oPanel = oPanel;
		this.bPanel = bPanel;
		this.lPanel = lPanel;
	}
	
	
	public void createBackButton()
	{
		backButton = new JButton("add something else?");
		add(backButton,BorderLayout.NORTH);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				oPanel.setVisible(true);
				bPanel.disableClicks();
			}
			
		});
		
	}
	
	public void createCheckOut()
	{
		checkOut = new JButton("Checkout");
		checkOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
			
				checkOut();
				backButton.setEnabled(false);
				
			}
			
		});
		add(checkOut,BorderLayout.SOUTH);
		
		
	}
	
	public void createTextField()
	{
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setBorder(BorderFactory.createTitledBorder("Invoice TextBox"));
		add(textArea, BorderLayout.CENTER);
		
	}
	
	public void printBasketInfo(String info){
		textArea.setText(info);
	}
	
	public void checkOut()
	{
		lPanel.print("Order successfully placed, thank you for your custom", false);
		double total = 0;
		for(BoxModel b: oPanel.getBasket())
		{
			b.calculateCost();
			total += b.getCost();
		}
		
		textArea.setText("Total cost of your order is : " + total);
	}
	
}
