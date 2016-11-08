import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Reset extends AbstractAction{
private OrderPanel oPanel;
	
public Reset(OrderPanel oPanel)
	{
		this.oPanel = oPanel;
	}

	public void actionPerformed(ActionEvent e) {
		
		oPanel.reset();
		
	}

}
