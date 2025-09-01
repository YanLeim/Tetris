

public class GUIThread implements Runnable {
	
	private TetrisWindow tw;
	private GameGrid gg;
	private Background bg;
	private UIBlock uib;
	private Start start;
	public GUIThread() {
		// TODO Auto-generated constructor stub
	}
	public GUIThread(TetrisField tf,Block b, Start start) {
		this.start=start;
		this.tw = new TetrisWindow(this);
		this.gg = new GameGrid(tf);
		this.bg = new Background();
		this.uib = new UIBlock(b,tf.width(),tf.height());
		tw.add(bg);
		tw.add(uib);
		uib.setOpaque(false);
		bg.setOpaque(false);
		gg.setOpaque(false);
		tw.add(gg);

	}
	@Override
	public void run() {
		gg.initilizeImages();
		uib.initilizeImage();
	}
	
	public void updateGame() {
		gg.updateField();
	}
	public void updateBlock(Block b) {
		uib.updateBlock(b);
	}

	public void moveLeft() {
		
		start.moveLeft();
	}
	public void moveRight() {
		start.moveRight();
	}
	public void crashDown() {
		start.crashDown();
	}
	public void rotateBlock() {
		start.rotateBlock();
	}
	public void fastFalling() {
		start.fastFalling();
	}
	public void stopfastFalling() {
		
		start.stopfastFalling();
	}

}
