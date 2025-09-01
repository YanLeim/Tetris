import java.util.*;
public class TetrisField {
	
	private BlockType[][] playfield;
	private static final int FIELDWIDTH = 10;
	private static final int FIELDHEIGHT = 20;
	public TetrisField() {
		playfield = new BlockType[FIELDHEIGHT][FIELDWIDTH];

	}

	
	public BlockType getFieldAt(int i, int j) {
		return this.playfield[i][j];
	}

	public void setTile(int i, int j, BlockType bt) {
		playfield[i][j] = bt;
	}


	public int height() {
		return FIELDHEIGHT;
	}


	public int width() {
		return FIELDWIDTH;
	}


	public void integrateBlockAndEliminateFullRows(Block b) {
		integrateBlock(b);
		Set<Integer> rowstocheck = setRowsToCheck(b);
		List<Integer> fullrows = checkFullRows(rowstocheck);
		
		deleteFullRows(fullrows);
	}
	private void integrateBlock(Block b) {
		setTile(b.getCenterTileY(),b.getCenterTileX(),b.getBlockType());
		setTile(b.getTile2Y(),b.getTile2X(),b.getBlockType());
		setTile(b.getTile3Y(),b.getTile3X(),b.getBlockType());
		setTile(b.getTile4Y(),b.getTile4X(),b.getBlockType());
	}


	private Set<Integer> setRowsToCheck(Block b) {
		Set<Integer> rowstocheck = new HashSet<>();
		rowstocheck.add(b.getCenterTileY());
		rowstocheck.add(b.getTile2Y());
		rowstocheck.add(b.getTile3Y());
		rowstocheck.add(b.getTile4Y());
		return rowstocheck;
	}


	private List<Integer> checkFullRows(Set<Integer>rowstocheck) {
		List<Integer> fullrows = new ArrayList<>();
		
		for(int row : rowstocheck) {
			int counter = 0;
			for (int i = 0; i<width();i++) {
				if(playfield[row][i] != null) {
					counter++;
				}
			}
			if(counter == width()) {
				fullrows.add(row);
			}
		}
		fullrows.sort(null);
		return fullrows;
	}
	private void deleteFullRows(List<Integer> fullrows) {
		if(fullrows.isEmpty()) {
			return;
		}

		for(int row : fullrows) {
			deleteRow(row);
		}
		int gapsize = 0;
		for(int i = fullrows.getLast();i>=0;i--) {
			if(!fullrows.isEmpty() && i == fullrows.getLast()) {
				fullrows.removeLast();
				gapsize++;
			}else {
				for(int j = 0;j<width();j++) {
					
					playfield[i+gapsize][j]=playfield[i][j];
				}
			}
		}

	}
	private void deleteRow(int row) {
		for (int i = 0; i<width();i++) {
			playfield[row][i] = null;
		}
	}


	/** */
	public boolean isSpaceDown(Block b) {
		//hit ground
		if(b.getCenterTileY()+1 ==height() || b.getTile2Y()+1 ==height() ||
				b.getTile3Y()+1	==height() || b.getTile4Y()+1 ==height() )
			return false;
		//doesn't hit another tile
		return isSpaceFree(b,0,1);
	}
	public boolean isSpaceLeft(Block b) {
		if(isBoundaryLeft(b))
			return false;
		return isSpaceFree(b,-1,0);
	
	}
	private boolean isBoundaryLeft(Block b) {
		if(b.getCenterTileX()-1 ==-1 || b.getTile2X()-1 ==-1 ||
				b.getTile3X()-1	==-1 || b.getTile4X()-1 ==-1 )
			return true;
		return false;
	}
	public boolean isSpaceRight(Block b) {
		if(isBoundaryRight(b))
			return false;
		return isSpaceFree(b,1,0);
	}
	private boolean isBoundaryRight(Block b) {
		if(b.getCenterTileX()+1 ==width() || b.getTile2X()+1 ==width() ||
				b.getTile3X()+1	==width() || b.getTile4X()+1 ==width() ) {
			return true;
		}
		return false;
	}
	private boolean isSpaceFree(Block b,int offsetX,int offsetY) {
		if(playfield[b.getCenterTileY()+offsetY][b.getCenterTileX()+offsetX] == null &&
				playfield[b.getTile2Y()+offsetY][b.getTile2X()+offsetX] == null &&
				playfield[b.getTile3Y()+offsetY][b.getTile3X()+offsetX] == null &&
				playfield[b.getTile4Y()+offsetY][b.getTile4X()+offsetX] == null) {
					
				return true;
		}
		return false;
	}
	public Block rotateBlock(Block b) {
		if(b.getBlockType()==BlockType.O)
			return b;
		Block rotatedBlock = b.createRotatedBlock();
		if(!outSideBoundaryRight(rotatedBlock)&&!outsideBoundaryLeft(rotatedBlock)&&blockFitsinField(rotatedBlock)) {
			return rotatedBlock;
		}
		return b;
	}
	private boolean outSideBoundaryRight(Block b) {
		if(b.getCenterTileX() >= width() || b.getTile2X() >= width() ||
				b.getTile3X() >= width() || b.getTile4X() >= width() ) {
			return true;
		}
		return false;
	}


	private boolean outsideBoundaryLeft(Block b) {
		if(b.getCenterTileX() <=-1 || b.getTile2X() <=-1 ||
				b.getTile3X()	<=-1 || b.getTile4X()<=-1 )
			return true;
		return false;
	}


	private boolean blockFitsinField(Block b) {
		//TODO check for grid boundary
		return isSpaceFree(b,0,0);
	}
	public boolean isGameOver(Block b) {
		return !isSpaceFree(b,0,0);
	}


	public void playfieldString() {
		for(int i=0;i<height();i++) {
			for(int j=0;j<width();j++) {
				if(playfield[i][j]==null) {
					System.out.print(0);
				}else {
					System.out.print(1);
				}
					
			}System.out.println();
		}System.out.println();
	}
}
