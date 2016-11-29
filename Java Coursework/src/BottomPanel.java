import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BottomPanel extends PanelModel {
	private JButton addTo;
	private JButton reset;
	private JButton next;
	private Submit submitOrder;
	private OrderPanel oPanel;
	private InvoicePanel iPanel;
	private LogPanel lPanel;

	public BottomPanel(String border) {
		super(border);
		setLayout(new BorderLayout());
		resetButton();
		nextButton();
		setBackground(Color.LIGHT_GRAY);

	}

	public void linkPanels(OrderPanel oPanel, InvoicePanel iPanel, LogPanel lPanel) {
		this.oPanel = oPanel;
		this.iPanel = iPanel;
		this.lPanel = lPanel;
	}

	public void addToButton() {
		addTo = new JButton("Add to basket");
		this.submitOrder = new Submit(oPanel, lPanel, iPanel);
		addTo.addActionListener(submitOrder);
		add(addTo, BorderLayout.CENTER);
	}

	public void resetButton() {
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				oPanel.reset();
			}

		});
		add(reset, BorderLayout.WEST);
	}

	public void nextButton() {
		next = new JButton("Next");
		add(next, BorderLayout.EAST);

		next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				oPanel.setVisible(false);
				iPanel.setVisible(true);
				iPanel.printBasketInfo(BasketInfo());
				disableClicks();
			}

		});

	}

	public void disableClicks() {
		if (oPanel.isVisible()) {
			addTo.setEnabled(true);
			reset.setEnabled(true);
			next.setEnabled(true);
		} else {
			addTo.setEnabled(false);
			reset.setEnabled(false);
			next.setEnabled(false);

		}
	}

	public void enableEverything() {
		addTo.setEnabled(true);
		reset.setEnabled(true);
		next.setEnabled(true);
	}

	public void disableEverything() {
		addTo.setEnabled(false);
		reset.setEnabled(false);
		next.setEnabled(false);
	}

	public String BasketInfo() {
		String information = "Your basket currently has " + oPanel.basketSize() + " boxes ";

		return information;
	}
}
