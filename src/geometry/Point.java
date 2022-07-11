package geometry;

public class Point extends java.awt.Point {
	private static final long serialVersionUID = -831249750431354018L;

	public Point(int x1, int y1) {
		super(x1,y1);
	}

	@Override
	public String toString() {
		return "[x=" + x + ",y=" + y + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if( o == null || o.getClass() != this.getClass())
			return false;
		Point p = ((Point)o);
		return this.x == p.x && this.y == p.y;
	}

}
