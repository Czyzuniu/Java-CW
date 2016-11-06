import javax.swing.JButton;

public class BottomPanel extends PanelModel{
private JButton submit;
private JButton reset;
private Submit submitOrder;
private OrderPanel oPanel;

	public BottomPanel(String border, OrderPanel oPanel) {
		super(border);
		this.oPanel = oPanel;
		resetButton();
		submitButton();
		
	}

	
	public void submitButton()
	{
		
		submit = new JButton("Submit");
		submitOrder = new Submit(oPanel);
		submit.addActionListener(submitOrder);
		add(submit);
	}
	
	public void resetButton()
	{
		reset = new JButton("Reset");
		add(reset);
	}
	
	
}
