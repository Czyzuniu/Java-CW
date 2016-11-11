import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class Submit extends AbstractAction {
private int width,height,length,grade,colours,type, quantity;
private double totalCost;
private boolean bottom,corner,sealed;
private ArrayList<BoxModel>boxes;
private String another;
private OrderPanel oPanel;
private InvoicePanel iPanel;

	public Submit(OrderPanel oPanel, InvoicePanel iPanel)
	{
		this.oPanel = oPanel;
		this.iPanel = iPanel;
		boxes = new ArrayList<BoxModel>();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		iPanel.setVisible(false);
		oPanel.setVisible(true);
		width = oPanel.getChosenWidth();
		height = oPanel.getChosenHeight();
		length = oPanel.getChosenLength();
		grade = oPanel.getgradeList();
		colours = oPanel.getColourList();
		quantity = oPanel.getQuantity();
		bottom = oPanel.bottom();
		corner = oPanel.corner();
		sealed = oPanel.isSealed();
		
		if(calculateType() == 1)
		{
			System.out.println("Type 1 was selected for this order");
			for(int i = 0; i < quantity; i++)
			{
				boxes.add(new BoxType1(width,height,length,grade,colours,sealed,bottom,corner));
			}

			
			
		}
		
		if(calculateType() == 2)
		{
			System.out.println("Type 2 was selected for this order");
			for(int i = 0; i < quantity; i++)
			{
				boxes.add(new BoxType2(width,height,length,grade,colours,sealed,bottom,corner));
			}
			
		}
		
		if(calculateType() == 3)
		{
			System.out.println("Type 3 was selected for this order");
			for(int i = 0; i < quantity; i++)
			{
				boxes.add(new BoxType3(width,height,length,grade,colours,sealed,bottom,corner));
			}
			
		}
		
		if(calculateType() == 4)
		{

			System.out.println("Type 4 was selected for this order");
			for(int i = 0; i < quantity; i++)
			{
				boxes.add(new BoxType4(width,height,length,grade,colours,sealed,bottom,corner));
			}
			
		}
		
		if(calculateType() == 5)
		{

			System.out.println("Type 5 was selected for this order");
			for(int i = 0; i < quantity; i++)
			{
				boxes.add(new BoxType5(width,height,length,grade,colours,sealed,bottom,corner));
			}
			
		}
		
		if(calculateType() == 0)
			
		{
			System.out.println("Sorry, but we are not producing boxes of your specifications");
		}
	
		//System.out.println("");
		iPanel.printOut("You currently have " + boxes.size() + " items in your order");
		
		type = 0;
	
	

		
	}
	
	
	public int calculateType()
	{
		if(grade >0 && grade < 6)
		{
		
			if(grade >= 1 && grade <= 3 && colours == 0 && bottom == false && corner == false)
			{
				return type = 1;
			}
			if(grade >= 2 && grade <= 4 && colours == 1 && bottom == false && corner == false)
			{
				return type = 2;
			}
			if(grade >= 2 && grade <= 5 && colours == 2 && bottom == false && corner == false)
			{
				return type = 3;
			}
			if(grade >= 2 && grade <= 5 && colours == 2 && bottom == true && corner == false)
			{
				return type = 4;
			}
			if(grade >= 3 && grade <= 5 && colours == 2 && bottom == true && corner == true)
			{
				return type = 5;
			}
	
		}
		else
		{
			return type = 0;
		}
		
		return type;
	}


}
