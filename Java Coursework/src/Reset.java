import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Reset extends AbstractAction {
	private OrderPanel oPanel;
	private InvoicePanel iPanel;
	private LogPanel lPanel;

	public Reset(OrderPanel oPanel, InvoicePanel iPanel, LogPanel lPanel) {
		this.oPanel = oPanel;
		this.iPanel = iPanel;
		this.lPanel = lPanel;
	}

	public void actionPerformed(ActionEvent e) {

		if (!oPanel.isVisible()) {
			if (oPanel.basketSize() > 0) {
				while (oPanel.basketSize() > 0) {
					oPanel.clearBasket();
				}
				lPanel.print("\nYour basket has been cleared", false);
				iPanel.disableCheckOut();
				iPanel.printBasketInfo("Your basket currently has " + oPanel.basketSize() + " boxes");
			} else {
				lPanel.print("\nYour basket is empty", true);
			}

		}

	}

}
