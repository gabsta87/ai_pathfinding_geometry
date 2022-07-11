package pathSearch;

import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import geometry.Terrain;
import pathSearch.tools.NodePlus;
import pathSearch.tools.Path;

public class RecursiveBestFirst extends PathFinder {

	public RecursiveBestFirst(Terrain t) {
		super(t);
	}

	@Override
	public Path findRoute(Point start, Point goal) {
		this.terrain.setGoalPoint(goal);

		NodePlus root = new NodePlus(null, start, goal);
		
		Answer answer = exploreNode(root, Double.POSITIVE_INFINITY);

		Path solution = null;
		
		if(answer.isSuccess())
			solution = ((Success)answer).getSolution();
		
		return solution;
	}

	private Answer exploreNode(NodePlus n, double limit) {
		
		if(n.isGoal())
			return new Success(n);
		
		List<NodePlus> children = n.exploreNode(this);
		
		if(children.isEmpty())
			return new Failure(Double.POSITIVE_INFINITY);
		
		double temp;
		
		for(NodePlus childNode : children) {
			temp = Math.max(n.getfCost(),childNode.getfCost());
			childNode.setfCost(temp);
		}

		while(true) {
			children.sort(null);
			if(children.get(0).getfCost() > limit) 
				return new Failure(children.get(0).getfCost());
			Answer a = exploreNode(children.get(0), Math.min(limit,children.get(1).getfCost()));
			if(a.isSuccess()) {
				return a;
			}else {
				children.get(0).setfCost(((Failure)a).fLimit);
			}
		}
	}
	
	abstract class Answer{
		boolean isSuccess() {
			return this.getClass() == Success.class;
		}
	}
	
	class Success extends Answer{
		Path solution;
		
		public Success(NodePlus n) {
			List<Line> segments = new LinkedList<Line>();
			while(!n.isRoot()) {
				segments.add(0,new Line(n.getParent().getPoint(), n.getPoint()));
				n = n.getParent();
			}
			solution = new Path(segments);
		}
		
		public Path getSolution() {
			return solution;
		}
	}
	
	class Failure extends Answer{
		double fLimit;
		public Failure(double newLimit) {
			this.fLimit = newLimit;
		}
		@Override
		public String toString() {
			return ""+fLimit;
		}
	}
}
