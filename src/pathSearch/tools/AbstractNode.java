package pathSearch.tools;

import java.util.LinkedList;
import java.util.List;

import geometry.Point;

public class AbstractNode implements Comparable<AbstractNode>{
	private AbstractNode parent;
	private List<AbstractNode> children;
	protected Point point;
	protected double evaluatedDistanceToGoal;
	protected double pathCostToPoint;

	public AbstractNode(AbstractNode parent, Point point) {
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

	public void addChild(AbstractNode n) {
		if (this.children == null)
			this.children = new LinkedList<AbstractNode>();
		this.children.add(n);
	}

	public List<AbstractNode> getChildren() {
		return this.children;
	}
	
	public AbstractNode getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "" + this.point + " Cost = " + pathCostToPoint + "; Evaluation = "
				+ evaluatedDistanceToGoal;
	}

	@Override
	public int compareTo(AbstractNode o) {
		return Double.compare(evaluatedDistanceToGoal, o.evaluatedDistanceToGoal);
	}

}
