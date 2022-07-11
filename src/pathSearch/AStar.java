package pathSearch;

import java.util.LinkedList;
import java.util.List;

import geometry.Point;
import geometry.Terrain;
import pathSearch.tools.ExplorationTree;
import pathSearch.tools.Node;
import pathSearch.tools.Path;

public class AStar extends PathFinder {

	public AStar(Terrain t) {
		super(t);
	}
	
	// TODO Corriger algorithme non-optimal
	public Path findRoute(Point start, Point goal){
		terrain.setGoalPoint(goal);
		
		ExplorationTree et = new ExplorationTree(start);
		List<Node> frontier = new LinkedList<Node>();
		List<Node> newNodes;
		
		while(!et.getSelectedNode().getPoint().equals(goal)) {
			
			newNodes = et.expandSelectedNode(this);
			
			for(Node n : newNodes) {
				n.setEvaluatedCost(n.getPathCost()+n.getPoint().distance(goal));
				frontier.add(n);
			}
			
			frontier.remove(et.getSelectedNode());
			
			Node bestNode = frontier.get(0);
			
			for (Node node : frontier) {
				if(bestNode.compareTo(node) > 0)
					bestNode = node;
			}
			
			et.selectNode(bestNode);
		}
		
		return et.getPathToSelectedNode();
	}
}

