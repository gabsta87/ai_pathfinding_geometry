package launch;
import generators.TerrainGenerator;
import geometry.Point;
import geometry.Terrain;
import pathSearch.AStar;
import pathSearch.PathFinder;
import pathSearch.RecursiveBestFirst;
import pathSearch.tools.Path;
import view.Painter;

public class PerformanceComparisonLauncher {

	/**
	 * This launcher tests both A* and RBFS algorithms to see which one is faster and which one finds a better solution
	 * @param args
	 */
	public static void main(String[] args) {
		Terrain t = TerrainGenerator.getTerrainV2();

		PathFinder aStarFinder = new AStar(t);
		PathFinder rbfsFinder = new RecursiveBestFirst(t);
		
		Point start = new Point(0, 0);
		Point goal = new Point(450, 250);

		long startAStarTime = System.currentTimeMillis();
		
		Path p = aStarFinder.findRoute(start, goal);

		long endAStarTime = System.currentTimeMillis();
		
		System.out.println("Astar : "+getTime(endAStarTime-startAStarTime));
		System.out.println(p);
		Painter.printSolution(t, p, "A*");
		
		long startRBFSTime = System.currentTimeMillis();
		
		Path p2 = rbfsFinder.findRoute(start, goal);

		long endRBFSTime = System.currentTimeMillis();
		
		System.out.println("RBFS: "+getTime(endRBFSTime-startRBFSTime));
		System.out.println(p2);
		Painter.printSolution(t, p2, "RBFS").setLocation(Painter.tspGeographicMaxDistance*1, 0);;

	}
	
	private static String getTime(long totalTime) {
		totalTime = totalTime/1000;
		long hours = totalTime/3600;
		long minutes = totalTime%3600/60;
		long seconds = totalTime%3600%60;
		return (hours>0?hours+"h":"")+(minutes>0?minutes+"m":"")+(seconds>0?seconds+"s":"");
	}

}
