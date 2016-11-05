import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class PanelModel extends JPanel {

	public PanelModel()
	{
		
	}
	
	public PanelModel(String border)
	{
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createTitledBorder(border));
	}
	
	
}
