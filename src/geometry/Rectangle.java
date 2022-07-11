package geometry;

public class Rectangle extends Polygon{
	
	public Rectangle(Point ...points) {
		vertices = points;
		edges = new Line[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			edges[i] = new Line(vertices[i],vertices[(i+1)%(vertices.length)]);
		}
	}
}
