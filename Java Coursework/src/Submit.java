import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Submit extends AbstractAction {

OrderPanel oPanel;

	public Submit(OrderPanel oPanel)
	{
		this.oPanel = oPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(oPanel.getgradeList());
		
	}

}
