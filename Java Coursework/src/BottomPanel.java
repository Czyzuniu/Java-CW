import javax.swing.JButton;

public class BottomPanel extends PanelModel{
JButton submit;
JButton reset;

	public BottomPanel(String border) {
		super(border);
		resetButton();
		submitButton();
	}

	
	public void submitButton()
	{
		submit = new JButton("Submit");
		add(submit);
	}
	
	public void resetButton()
	{
		reset = new JButton("Reset");
		add(reset);
	}
}
