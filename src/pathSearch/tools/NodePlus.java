package pathSearch.tools;

import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import pathSearch.PathFinder;

public class NodePlus implements Comparable<NodePlus>{
	private NodePlus parent;
	private Point point;
	private Point goal;
	/**
	 * Heuristic for distance to goal
	 * h(n)
	 */
	private double evaluatedDistanceToGoal;
	/**
	 * Cost to reach current node
	 * g(n)
	 */
	private double pathCostToPoint;
	/**
	 * f-limit of this node
	 * f(n) = max( g(n)+h(n) , limit)
	 */
	private double fCost;

	public NodePlus(NodePlus parent, Point point, Point goal) {
		this.parent = parent;
		this.goal = goal;
		this.point = point;
		if (parent != null) {
			pathCostToPoint += parent.pathCostToPoint + parent.point.distance(point);
		} else {
			pathCostToPoint = 0;
		}
		evaluatedDistanceToGoal = point.distance(goal);
		setfCost(evaluatedDistanceToGoal + pathCostToPoint);
	}

	public List<NodePlus> exploreNode(PathFinder pf) {
		List<NodePlus> result = new LinkedList<NodePlus>();
		for(Line l : pf.findReachableVertices(getPoint())) {
			NodePlus temp = new NodePlus(this,l.getEndingPoint(),goal);
			result.add(temp);
		}
		return result;
	}
	
	public Point getPoint() {
		return point;
	}

	public boolean isRoot() {
		return parent == null;
	}
	
	public boolean isGoal() {
		return this.point.equals(goal);
	}

	public double getfCost() {
		return fCost;
	}

	public void setfCost(double fCost) {
		this.fCost = fCost;
	}

	public NodePlus getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "" + this.point + " C = " + pathCostToPoint + "; E = " + evaluatedDistanceToGoal+"; F = "+fCost;
	}

	@Override
	public int compareTo(NodePlus o) {
		return Double.compare(fCost, o.fCost);
	}

}
