
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameGrid extends JPanel {

	private TetrisField tf;
	private BufferedImage gridImage;
	private Graphics2D gridgraphics;

	public GameGrid(TetrisField tf) {
		this.tf = tf;
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	public Dimension getPreferredSize() {
        return new Dimension(400,800);
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Image i =gridImage;
		g.drawImage(gridImage,0,0,this);
		//g.drawImage(blockImage,0,0,this);	
	}

	public void updateField() {

		gridgraphics.clearRect(0, 0, getWidth(), getHeight());
		int column_w = getWidth()/tf.width();
		int column_h = getHeight()/tf.height();
		for(int i=0;i<tf.width();i++) {
			for(int j = 0;j<tf.height();j++) {
				if(tf.getFieldAt(j,i)!=null) {
					gridgraphics.setColor(tf.getFieldAt(j,i).getColor());
					gridgraphics.fillRect(i * column_w, j * column_h, column_w, column_h);
					gridgraphics.setColor(Color.BLACK);
					gridgraphics.drawRect(i * column_w, j * column_h, column_w, column_h);;
				}

			}
		}
		
		repaint();

	}
	public void initilizeImages() {
		gridImage = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
	     // To be sure, we use clearRect, which will (unlike fillRect) totally replace
	     // the current pixels with the desired color, even if it's fully transparent.
		gridgraphics = gridImage.createGraphics();
		gridgraphics.setBackground(new Color(0, true));
		gridgraphics.clearRect(0, 0, getWidth(), getHeight());

		
	}

}
