

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TetrisWindow  {
	private JFrame jframe;

	public TetrisWindow(GUIThread guith){
		jframe = new JFrame("Tetris");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(500, 100, 500, 750);
		jframe.setVisible(true);
		jframe.addKeyListener(new KeyListener() {  
		    public void keyPressed(KeyEvent e) {  
		    	switch (e.getKeyChar()) {
				case 'a':
					guith.moveLeft();
					break;
				case 'd':
					guith.moveRight();
					break;
				case 's':
					guith.crashDown();
					break;
				case 'r':
					guith.rotateBlock();
					break;
				case 'f':
					guith.fastFalling();
					break;
		    	}
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyChar()) {
				case 'f':
					guith.stopfastFalling();
					break;
				default:
					break;
		    	}
				
			}  
		});
		
	}
	public void add(GameGrid gg){
		jframe.add(gg);
		jframe.pack();
	}
	public void add(Background gg){
		jframe.add(gg);
		jframe.pack();
	}
	public void add(UIBlock gg){
		jframe.add(gg);
		jframe.pack();
	}

}
