import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UIBlock extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics2D blockgraphics;
	private BufferedImage blockImage;
	private Block block;
	private int tetrisfieldwidth;
	private int tetrisfieldheight;
	public UIBlock(Block b, int w, int h) {
		block = new Block();
		block.copyBlock(b);
		tetrisfieldwidth = w;
		tetrisfieldheight = h;
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	public Dimension getPreferredSize() {
        return new Dimension(400,800);
    }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(blockImage,0,0,this);	
	}
	public void updateBlock(Block b) {

		removeOldBlockFromImage();
		addNewBlockToImage(b);
		block.copyBlock(b);
		repaint();
	}
	public void removeOldBlockFromImage() {
		int offset = 1;
		int column_w = getWidth()/tetrisfieldwidth;
		int column_h = getHeight()/tetrisfieldheight;
		
		blockgraphics.clearRect(block.getCenterTileX() * column_w, block.getCenterTileY() * column_h, column_w+offset, column_h+offset);
		blockgraphics.clearRect(block.getTile2X() * column_w, block.getTile2Y() * column_h, column_w+offset, column_h+offset);
		blockgraphics.clearRect(block.getTile3X() * column_w, block.getTile3Y() * column_h, column_w+offset, column_h+offset);
		blockgraphics.clearRect(block.getTile4X() * column_w, block.getTile4Y() * column_h, column_w+offset, column_h+offset);
		
	}
	public void addNewBlockToImage(Block b) {
		int column_w = getWidth()/tetrisfieldwidth;
		int column_h = getHeight()/tetrisfieldheight;
		blockgraphics.setColor(b.getBlockType().getColor());
		blockgraphics.fillRect(b.getCenterTileX() * column_w, b.getCenterTileY() * column_h, column_w, column_h);
		blockgraphics.fillRect(b.getTile2X() * column_w, b.getTile2Y() * column_h, column_w, column_h);
		blockgraphics.fillRect(b.getTile3X() * column_w, b.getTile3Y() * column_h, column_w, column_h);
		blockgraphics.fillRect(b.getTile4X() * column_w, b.getTile4Y() * column_h, column_w, column_h);
		blockgraphics.setColor(Color.BLACK);
		blockgraphics.drawRect(b.getCenterTileX() * column_w , b.getCenterTileY() * column_h , column_w , column_h);
		blockgraphics.drawRect(b.getTile2X() * column_w, b.getTile2Y() * column_h, column_w, column_h);
		blockgraphics.drawRect(b.getTile3X() * column_w, b.getTile3Y() * column_h, column_w, column_h);
		blockgraphics.drawRect(b.getTile4X() * column_w, b.getTile4Y() * column_h, column_w, column_h);
	}
	public void initilizeImage() {
		blockImage = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
	    blockgraphics = blockImage.createGraphics();
	     // To be sure, we use clearRect, which will (unlike fillRect) totally replace
	     // the current pixels with the desired color, even if it's fully transparent.
	    blockgraphics.setBackground(new Color(0, true));
	    blockgraphics.clearRect(0, 0, getWidth(), getHeight());
	    
	}

}
