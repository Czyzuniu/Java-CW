import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class LogPanel extends PanelModel{

private JTextArea logBox;	
	
	public LogPanel(String border, int width, int height){
		super(border, width, height);
		logBox();
	}
	
	
	public void logBox()
	{
		logBox = new JTextArea();
		logBox.setEditable(false);
		logBox.setEnabled(false);
		add(logBox);
	}
	
	public void print(String what, boolean isError)
	{
		
		if(isError == true)
		{
			logBox.setDisabledTextColor(Color.RED);
		}
		else
		{
			logBox.setDisabledTextColor(Color.GREEN);
		}
		
		logBox.setText(what);
	}
	
	public void clear()
	{
		logBox.setText(null);
	}
}	

	
