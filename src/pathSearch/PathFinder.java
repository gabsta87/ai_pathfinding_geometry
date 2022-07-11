package pathSearch;

import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import geometry.Terrain;
import pathSearch.tools.Path;

public abstract class PathFinder {
	protected Terrain terrain;
	
	public PathFinder(Terrain t) {
		this.terrain = t;
	}
	
	public abstract Path findRoute(Point start, Point goal);
	
	public List<Line> findReachableVertices(Point p){
		List<Line> result = new LinkedList<Line>();
		Line temporaryLine;
		List<Point> vertices = terrain.getAllVertices();
		for(int i = 0; i < vertices.size(); i++) {
			boolean intersects = false;
			if(!p.equals(vertices.get(i))) {
				temporaryLine = new Line(p, vertices.get(i));
				for(int j = 0; j < terrain.getPolygons().size() && !intersects; j++) {
					
					if(terrain.getPolygons().get(j).intersects(temporaryLine))
						intersects = true;
					
				}
				if(!intersects && !result.contains(temporaryLine)) {
					result.add(temporaryLine);
				}
			}
		}
		return result;
	}
}
