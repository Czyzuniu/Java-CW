import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class Submit extends AbstractAction {
private int width,height,length,grade,colours,type, quantity;
private double totalCost;
private boolean bottom,corner,sealed;
private OrderPanel oPanel;
private LogPanel lPanel;

	public Submit(OrderPanel oPanel, LogPanel lPanel)
	{
		this.oPanel = oPanel;
		this.lPanel = lPanel;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		width = oPanel.getChosenWidth();
		height = oPanel.getChosenHeight();
		length = oPanel.getChosenLength();
		grade = oPanel.getgradeList();
		colours = oPanel.getColourList();
		quantity = oPanel.getQuantity();
		bottom = oPanel.bottom();
		corner = oPanel.corner();
		sealed = oPanel.isSealed();
		
		
		
		if(oPanel.getBasket().size() + quantity <= 25)
		{
			
			if(calculateType() == 1)
			{	
				
				for(int i = 0; i < quantity; i++)
				{
					oPanel.getBasket().add(new BoxType1(width,height,length,grade,colours,sealed,bottom,corner));
				}
	
				
			}
			
			if(calculateType() == 2)
			{
			
				for(int i = 0; i < quantity; i++)
				{
					oPanel.getBasket().add(new BoxType2(width,height,length,grade,colours,sealed,bottom,corner));
				}
				
			}
			
			if(calculateType() == 3)
			{
				
				for(int i = 0; i < quantity; i++)
				{
					oPanel.getBasket().add(new BoxType3(width,height,length,grade,colours,sealed,bottom,corner));
				}
				
			}
			
			if(calculateType() == 4)
			{
	
	
				for(int i = 0; i < quantity; i++)
				{
					oPanel.getBasket().add(new BoxType4(width,height,length,grade,colours,sealed,bottom,corner));
				}
				
			}
			
			if(calculateType() == 5)
			{
	
				for(int i = 0; i < quantity; i++)
				{
					oPanel.getBasket().add(new BoxType5(width,height,length,grade,colours,sealed,bottom,corner));
				}
				
			}
			
			if(calculateType() == 0)
				
			{
				lPanel.print("Sorry, but we are not producing boxes of your specifications", true);
			}
			else if(quantity <= 0)
			{
				lPanel.print("Please enter a number in quantity field", true);
			}
			else
			{
				lPanel.print(quantity + " boxes of type " + type + " were added to your basket", false);
			}
		
			type = 0;
		}
		else
		{
			lPanel.print("You cannot exceed more then 25 boxes in total", true);
		}
		
		
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
	
	/*
	public String more()
	{
		int t1 = 0;
		int t2 = 0;
		int t3 = 0;
		int t4 = 0;
		int t5 = 0;
		String information = "";
		
		for(BoxModel b: boxes)
		{
			if(b.getBoxType() == t1)
			{
				t1++;
			}
			if(b.getBoxType() == t2)
			{
				t2++;
			}
			if(b.getBoxType() == t3)
			{
				t3++;
			}
			if(b.getBoxType() == t4)
			{
				t4++;
			}
			if(b.getBoxType() == t5)
			{
				t5++;
			}
		}
		
		
		return information;
	}
*/

}
