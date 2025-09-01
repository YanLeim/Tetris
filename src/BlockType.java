import java.awt.Color;

public enum BlockType {
I{
	public Color getColor() {
		return Color.YELLOW;
	}
},O
{
	public Color getColor() {
		return Color.GREEN;
	}
},S{
	public Color getColor() {
		return Color.BLUE;
	}
},Z{
	public Color getColor() {
		return Color.RED;
	}
},T{
	public Color getColor() {
		return Color.PINK;
	}
},L{
	public Color getColor() {
		return Color.ORANGE;
	}
},J{
	public Color getColor() {
		return Color.CYAN;
	}
};
	public Color getColor() {
		return Color.BLACK;
	}
}
