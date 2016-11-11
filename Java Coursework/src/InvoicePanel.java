import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class InvoicePanel extends PanelModel {
	
private JButton backButton;
private JTextArea textArea;
	public InvoicePanel(String border , int width, int height)
	{
		super(border, width, height);
		setLayout(new BorderLayout());
		setVisible(false);
		createBackButton();
		createTextField();
	}
	
	
	public void createBackButton()
	{
		backButton = new JButton("back?");
		add(backButton,BorderLayout.NORTH);
		
	}
	
	public void createTextField()
	{
		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createTitledBorder("Invoice TextBox"));
		add(textArea, BorderLayout.CENTER);
		
	}
	
	public void printOut(String what)
	{
		textArea.append("Your total cost of whole order was : this is not working yet.... lol" );
		
	}
	
}
