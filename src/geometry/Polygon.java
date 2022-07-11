package geometry;

public class Polygon{
	protected Point[] vertices;
	protected Line[] edges;

	public Polygon(Point ...points) {
		vertices = points;
		edges = new Line[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			edges[i] = new Line(vertices[i],vertices[(i+1)%(vertices.length)]);
		}
	}
	
	
	public boolean intersects(Line v) {
		int p1=-1, p2=-1;

		for(int i = 0; i < vertices.length; i++) {
			if(edges[i].intersectsLine(v))
				return true;
			if(vertices[i].equals(v.getStartingPoint()))
				p1 = i;
			if(vertices[i].equals(v.getEndingPoint()))
				p2 = i;
		}
	
		if(p1>=0 && p2>=0) {
			return Math.abs((p1-p2)) >= 2;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < vertices.length-1 ; i++) {
			result += vertices[i]+" - ";
		}
		result += vertices[vertices.length-1];
		return result;
	}
	
	public Point[] getVertices() {
		return vertices;
	}
}
