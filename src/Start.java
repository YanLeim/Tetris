import javax.swing.*;
 
public class Start {

	private TetrisField tf;
	private Block b;
	GUIThread guithread;
	private BlockTimer bt;
	public static void main(String[] args) {
		Start start = new Start();
		start.start();
	}
	public Start() {
		init();
	}
	public void timerNotified() {
		if(tf.isSpaceDown(b)) {
			b.moveDown();
			guithread.updateBlock(b);
		}
		else {
			tf.integrateBlockAndEliminateFullRows(b);
			guithread.updateGame();
			b = new Block();
			guithread.updateBlock(b);
			if(tf.isGameOver(b)) {
				System.out.print("GG");
				bt.gameOver();
			}
				
		}
	}
	public void init() {
		tf = new TetrisField();
		b = new Block();
		guithread = new GUIThread(tf,b,this);
		
	}
	public void start() {
		bt = new BlockTimer(500,this);
		
		SwingUtilities.invokeLater(this.guithread);
		bt.start();
	}
	public void moveLeft() {
		if(tf.isSpaceLeft(b)) {
			
			b.moveLeft();
			
			guithread.updateBlock(b);
		}
		
	}
	public void moveRight() {
		if(tf.isSpaceRight(b)) {
			
			b.moveRight();
			
			guithread.updateBlock(b);
		}
	}
	public void crashDown() {
		while(tf.isSpaceDown(b)) {
			b.moveDown();
		}
		tf.integrateBlockAndEliminateFullRows(b);
		guithread.updateGame();
		b = new Block();
		guithread.updateBlock(b);
	}
	public void rotateBlock() {
		b = tf.rotateBlock(b);
		
		guithread.updateBlock(b);
	}
	public void fastFalling() {
		bt.setBreakTime(100);
	}
	public void stopfastFalling() {
		bt.setBreakTime(500);
	}
}
