package GameBoard;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Coordinate translate(int x, int y) {
		return new Coordinate(this.x + x, this.y + y);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Coordinate) {
			Coordinate c = (Coordinate)o;
			if (c.x == this.x && c.y == this.y)
				return true;
		}
		return false;
	}
	
	public int hashCode() {
		int hash = 1;
		hash = hash * 31 + x;
		hash = hash * 31 + y;
		return hash;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
