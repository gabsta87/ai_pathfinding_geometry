import java.util.LinkedList;
import java.util.List;

import geometry.Polygon;

public class Terrain {
	List<Polygon> polygons;

	public void addPolygon(Polygon p) {
		if(polygons == null) {
			this.polygons = new LinkedList<Polygon>();
		}
		this.polygons.add(p);
	}
	
	
}
