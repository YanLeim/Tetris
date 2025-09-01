import java.util.*;
public class RandomBlockTypeMaker {
	private Random r;
	private Map<Integer,BlockType> hm;
	public RandomBlockTypeMaker() {
		r = new Random();
		hm = new HashMap<>();
		hm.put(0,BlockType.O);
		hm.put(1,BlockType.I);
		hm.put(2,BlockType.L);
		hm.put(3,BlockType.J);
		hm.put(4,BlockType.T);
		hm.put(5,BlockType.S);
		hm.put(6,BlockType.Z);
	}
	public BlockType getRandomBlockType() {
		return hm.get(r.nextInt(7));
	}
}
