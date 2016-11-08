import javax.swing.JButton;

public class BottomPanel extends PanelModel{
private JButton submit;
private JButton reset;
private Submit submitOrder;
private Reset resetOrder;
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
		resetOrder = new Reset(oPanel);
		reset.addActionListener(resetOrder);
		add(reset);
	}
	
	
}
