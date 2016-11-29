import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class PanelModel extends JPanel {

	public PanelModel()
	{
		
	}
	
	public PanelModel(String border)
	{
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		//Font newFont = new Font("Arial",Font.BOLD, 22);
		
	}
	
	public PanelModel(String border, int width, int height)
	{
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		Dimension size = getPreferredSize();
		size.width = width;
		size.height = height;
		setPreferredSize(size);
	}

}
