import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class OrderPanel extends PanelModel {
private FlowLayout layout;
private JSlider width;
private JSlider height;
private JSlider length;
private JComboBox<Integer> gradeList;
private JComboBox<String> colourList;
private Integer[] grades = new Integer[] {1,2,3,4,5};
private String[] colours = new String[] {"no colour", "1 colour", "2 colours"};
private JRadioButton bottomR;
private JRadioButton cornerR;
private JRadioButton sealed;
private JTextField quantity;
	public OrderPanel(String border) {
		super(border);
		init();
		setLayout(layout = new FlowLayout());
		
	}
	
	public void init()
	{
		//Font font = new Font("Arial", 16, Font.BOLD);
		width = new JSlider();
		length = new JSlider();
		height = new JSlider();
		
		
		
		JLabel filler = new JLabel("                           ");
		JLabel lwidth = new JLabel(" specify your width in cm :   ");
		JLabel llength = new JLabel("  specify your length in cm : ");
		JLabel lheight = new JLabel("  specify your height in cm : ");
		JLabel lgrade = new JLabel("specify grade of your card : ");
		JLabel lcolor = new JLabel("specify colour printing of your box : ");
		JLabel lbottom = new JLabel("Would you like bottom reinforcement?: ");
		JLabel lcorner = new JLabel("Would you like corner reinforcement?: ");
		JLabel lsealed = new JLabel("Would you like your box to be sealed?");
		JLabel lquantity = new JLabel("How many of these boxes would you like?");
		
		

		gradeList = new JComboBox<Integer>(grades);
		colourList = new JComboBox<String>(colours);
		
		bottomR = new JRadioButton();
		cornerR = new JRadioButton();
		sealed = new JRadioButton();
		
		quantity = new JTextField();
		quantity.setColumns(10);
		
		
		
		add(lwidth);
		add(width);
		
		add(llength);
		add(length);
		
		add(lheight);
		add(height);
		
		
		add(lgrade);
		add(gradeList);
		add(filler);
		
		add(lcolor);
		add(colourList);
		
		add(lbottom);
		add(bottomR);
		add(lcorner);
		add(cornerR);
		add(lsealed);
		add(sealed);
		add(lquantity);
		add(quantity);
	}

	public int getgradeList()
	{
		return grades[gradeList.getSelectedIndex()];
	}
	
	public int getColourList()
	{
		return colourList.getSelectedIndex();
	}
	
	public boolean isSealed()
	{
		return sealed.isSelected();
	}

	public boolean bottom()
	{
		return bottomR.isSelected();
	}
	
	public boolean corner()
	{
		return cornerR.isSelected();
	}
	
	public int getChosenWidth()
	{
		return width.getValue();
	}
	
	public int getChosenLength()
	{
		return length.getValue();
	}
	
	public int getChosenHeight()
	{
		return height.getValue();
	}
	
	public int getQuantity()
	{
		return Integer.parseInt(quantity.getText());
	}
	
}
