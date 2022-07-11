package pathSearch.tools;

import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import pathSearch.PathFinder;

public class ExplorationTree{
	private Node selectedNode;
	
	public ExplorationTree(Point startingPoint) {
		this.selectedNode = new Node(null,startingPoint);
	}
	
	/**
	 * Expands the currently selected node by searching the possible routes and returns its children
	 * @param pf the PathFinder that allows to search the possible routes
	 * @return the children nodes of the currently selected node
	 */
	public List<Node> expandSelectedNode(PathFinder pf) {
		
		for(Line l : pf.findReachableVertices(selectedNode.getPoint())) {
			Node temp = new Node(selectedNode,l.getEndingPoint());
			selectedNode.addChild(temp);
		}
		return selectedNode.getChildren();
	}
	
	public Node getSelectedNode() {
		return selectedNode;
	}
	
	public void selectNode(Node n) {
		this.selectedNode = n;
	}
	
	public Path getPathToSelectedNode() {
		List<Line> reverseList = new LinkedList<Line>();

		while(!selectedNode.isRoot()) {
			reverseList.add(0,new Line(selectedNode.getParent().getPoint() ,selectedNode.getPoint()));
			selectNode(selectedNode.getParent());
		}
		return new Path(reverseList);
	}
}
