package launch;
import java.util.List;

import generators.TerrainGenerator;
import geometry.Line;
import geometry.Point;
import geometry.Terrain;
import pathSearch.AStar;
import pathSearch.PathFinder;

public class LauncherDirectPaths {

	/**
	 * This launcher tests if the algorithm finds all correct reachable destinations (vertices) from a given point.
	 * A correct destination is a vertex with no obstacle between it and the starting point.
	 * @param args
	 */
	public static void main(String[] args) {

		Terrain t = TerrainGenerator.getTerrainV1();
		
		PathFinder pf = new AStar(t);
		
		Point startPoint = new Point(10,10);
		tryPoint(pf, startPoint);
		
		Point secondPoint = new Point(110,80);
		tryPoint(pf,secondPoint);
		
		Point thirdPoint = new Point(50,80);
		tryPoint(pf,thirdPoint);
		
	}

	private static void tryPoint(PathFinder pf, Point startPoint) {
		List<Line>result = pf.findReachableVertices(startPoint);
		System.out.println();
		
		System.out.println(result.size()+" allowed paths from "+startPoint+" : ");
		for (Line line : result) {
			System.out.println(line);
		}
	}
}
