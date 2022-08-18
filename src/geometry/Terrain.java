package geometry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Terrain {
	private List<Rectangle> polygons;
	private Point goal;
	
	public Terrain() {
		this.polygons = new ArrayList<Rectangle>();
	}

	public void addPolygon(Rectangle p1) {
		if(polygons == null) {
			this.polygons = new LinkedList<Rectangle>();
		}
		this.polygons.add(p1);
	}
	
	public void addPolygons(Rectangle...rectangles) {
		for(int i = 0; i < rectangles.length; i++) {
			this.addPolygon(rectangles[i]);
		}
	}
	
	public void setGoalPoint(Point p) {
		this.goal = p;
	}
	
	public void addPolygons(List<Rectangle> polygons) {
		this.polygons = polygons;
	}
	
	public List<Rectangle> getPolygons(){
		return polygons;
	}
	
	public List<Point> getAllVertices(){
		List<Point> result = new LinkedList<Point>();
		for(Polygon p : polygons) {
			for(Point elem : p.getVertices()) {
				result.add(elem);
			}
		}
		
		if(goal !=null)
			result.add(goal);
		
		return result;
	}
	
}
