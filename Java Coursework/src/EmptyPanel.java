import java.awt.Color;
import java.awt.Dimension;

public class EmptyPanel extends PanelModel {

	public EmptyPanel() {
		Dimension size = getPreferredSize();
		size.width = 10;
		size.height = 30;
		setPreferredSize(size);
		setBackground(Color.LIGHT_GRAY);

	}
}
