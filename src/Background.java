import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;

public class Background extends JPanel {

	public Background() {
		// TODO Auto-generated constructor stub
	}

	public Dimension getPreferredSize() {
        return new Dimension(400,800);
    }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0;i<20;i++) {
			g.drawLine(0, i*40, 400, i*40);
		}
		for(int i=0;i<10;i++) {
			g.drawLine(i*40, 0, i*40, 800);
		}
	}

}
