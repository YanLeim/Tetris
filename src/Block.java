
/**Tetris Stone that is falling */
public class Block {
	/** */
	private BlockType blocktype;
	private Tile centertile;
	private Tile tile2;
	private Tile tile3;
	private Tile tile4;
	private static RandomBlockTypeMaker randomblocktypemaker;
	public Block() {
		if(randomblocktypemaker == null)
			randomblocktypemaker = new RandomBlockTypeMaker();
		BlockType bt = randomblocktypemaker.getRandomBlockType();
		generateBlock(bt);

	}
	private Block(Tile t2,Tile t3,Tile t4,Tile ct,BlockType bt) {
		tile2 = t2;
		tile3 = t3;
		tile4 = t4;
		centertile = ct;
		blocktype = bt;
	}

	public Block createRotatedBlock() {
		Tile tiletwo= createTileAtRotatedPosition(getTile2());
		Tile tilethree = createTileAtRotatedPosition(getTile3());
		Tile tilefour = createTileAtRotatedPosition(getTile4());
		Tile tilecenter = new Tile(centertile.getX(),centertile.getY());
		return new Block(tiletwo,tilethree,tilefour,tilecenter,blocktype);
	}
	private Tile createTileAtRotatedPosition(Tile t) {
		//upper left
		if(getCenterTileX()>t.getX() && getCenterTileY()>t.getY())
			return new Tile(t.getX()+2,t.getY());
		//upper middle
		if(getCenterTileX()==t.getX() && getCenterTileY()>t.getY()) {
			if(getCenterTileY() - t.getY()== 2) {
				return new Tile(t.getX()+2,t.getY()+2);
			}else {
				return new Tile(t.getX()+1,t.getY()+1);
			}
		}	
		//upper right
		if(getCenterTileX()<t.getX() && getCenterTileY()>t.getY())
			return new Tile(t.getX(),t.getY()+2);
		//middle left
		if(getCenterTileX()>t.getX() && getCenterTileY()==t.getY()) {
			if(getCenterTileX() - t.getX()== 2) {
				return new Tile(t.getX()+2,t.getY()-2);
			}else {
				return new Tile(t.getX()+1,t.getY()-1);
			}
		}
		//middle right
		if(getCenterTileX()<t.getX() && getCenterTileY()==t.getY())
		 {
			if(t.getX() - getCenterTileX()== 2) {
				return new Tile(t.getX()-2,t.getY()+2);
			}else {
				return new Tile(t.getX()-1,t.getY()+1);
			}
		}
		//bottom left
		if(getCenterTileX()>t.getX() && getCenterTileY()<t.getY())
			return new Tile(t.getX(),t.getY()-2);
		//bottom middle
		if(getCenterTileX()==t.getX() && getCenterTileY()<t.getY()) {
			if(t.getY() - getCenterTileY() == 2) {
				return new Tile(t.getX()-2,t.getY()-2);
			}else {
				return new Tile(t.getX()-1,t.getY()-1);
			}
		}
		//bottom right
		if(getCenterTileX()<t.getX() && getCenterTileY()<t.getY())
			return  new Tile(t.getX()-2,t.getY());
		return null;
	}
	public void moveLeft() {
		centertile.setX(centertile.getX()-1);
		tile2.setX(tile2.getX()-1);
		tile3.setX(tile3.getX()-1);
		tile4.setX(tile4.getX()-1);
	}
	public void moveRight() {
		centertile.setX(centertile.getX()+1);
		tile2.setX(tile2.getX()+1);
		tile3.setX(tile3.getX()+1);
		tile4.setX(tile4.getX()+1);
	}
	public void moveDown() {
		centertile.setY(centertile.getY()+1);
		tile2.setY(tile2.getY()+1);
		tile3.setY(tile3.getY()+1);
		tile4.setY(tile4.getY()+1);
	}
	public void copyBlock(Block b) {
		blocktype = null;
		centertile.setTile(b.getCentertile());
		tile2.setTile(b.getTile2());
		tile3.setTile(b.getTile3());
		tile4.setTile(b.getTile4());
	}
	public void generateBlock(BlockType bt) {
		
		switch(bt) {
		case BlockType.S:
			centertile = new Tile(5,0);
			tile2 = new Tile(5,1);
			tile3 = new Tile(6,0);
			tile4 = new Tile(4,1);
			blocktype = BlockType.S;
			break;
		case BlockType.Z:
			centertile = new Tile(5,0);
			tile2 = new Tile(5,1);
			tile3 = new Tile(6,1);
			tile4 = new Tile(4,0);
			blocktype = BlockType.Z;
			break;
		case BlockType.L:
			centertile = new Tile(4,0);
			tile2 = new Tile(3,0);
			tile3 = new Tile(5,0);
			tile4 = new Tile(3,1);
			blocktype = BlockType.L;
			break;
		case BlockType.J:
			centertile = new Tile(4,0);
			tile2 = new Tile(3,0);
			tile3 = new Tile(5,0);
			tile4 = new Tile(5,1);
			blocktype = BlockType.J;
			break;
		case BlockType.T:
			centertile = new Tile(5,1);
			tile2 = new Tile(5,0);
			tile3 = new Tile(6,1);
			tile4 = new Tile(4,1);
			blocktype = BlockType.T;
			break;
		case BlockType.I:
			centertile = new Tile(4,0);
			tile2 = new Tile(3,0);
			tile3 = new Tile(5,0);
			tile4 = new Tile(6,0);
			blocktype = BlockType.I;
			break;
		case BlockType.O:
			centertile = new Tile(5,1);
			tile2 = new Tile(5,0);
			tile3 = new Tile(4,0);
			tile4 = new Tile(4,1);
			blocktype = BlockType.O;
			break;
		default:
			break;
			
		}
	}
	public int getCenterTileY() {
		return centertile.getY();
	}
	public int getCenterTileX() {
		return centertile.getX();
	}
	public int getTile2Y() {
		return tile2.getY();
	}
	public int getTile2X() {
		return tile2.getX();
	}
	public int getTile3Y() {
		return tile3.getY();
	}
	public int getTile3X() {
		return tile3.getX();
	}
	public int getTile4Y() {
		return tile4.getY();
	}
	public int getTile4X() {
		return tile4.getX();
	}
	public BlockType getBlockType() {
		return blocktype;
	}

	public Tile getCentertile() {
		return centertile;
	}

	public Tile getTile2() {
		return tile2;
	}

	public Tile getTile3() {
		return tile3;
	}

	public Tile getTile4() {
		return tile4;
	}
	public String toString() {
		String s = "Center:"+getCenterTileX()+" "+ getCenterTileY()+ "\n" + "Tile2:" + getTile2X()+" "+getTile2Y()+ "\n" + "Tile3:" + getTile3X()+" "+getTile3Y()
		+ "\n" + "Tile4:" + getTile4X()+" "+getTile4Y();
		return s;
	}
		
}
