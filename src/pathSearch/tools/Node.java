package pathSearch.tools;

import java.util.LinkedList;
import java.util.List;

import geometry.Point;

public class Node implements Comparable<Node>{
	private Node parent;
	private List<Node> children;
	private Point point;
	private double evaluatedDistanceToGoal;
	private double pathCostToPoint;

	public Node(Node parent, Point point) {
		this.parent = parent;
		this.point = point;
		if (parent != null) {
			pathCostToPoint += parent.pathCostToPoint + parent.point.distance(point);
		} else {
			pathCostToPoint = 0;
		}
	}

	public Point getPoint() {
		return point;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public double getPathCost() {
		return pathCostToPoint;
	}

	public void setEvaluatedCost(double cost) {
		evaluatedDistanceToGoal = cost;
	}

	public void addChild(Node n) {
		if (this.children == null)
			this.children = new LinkedList<Node>();
		this.children.add(n);
	}

	public List<Node> getChildren() {
		return this.children;
	}
	
	public Node getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "" + this.point + " Cost = " + pathCostToPoint + "; Evaluation = "
				+ evaluatedDistanceToGoal;
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(evaluatedDistanceToGoal, o.evaluatedDistanceToGoal);
	}

}
