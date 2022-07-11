package solutionSearch;

import java.util.LinkedList;
import java.util.List;

public class Success extends Answer{
	private List<Node> solution;
	
	public Success(Node n) {
		solution = new LinkedList<Node>();
		
		Node currentNode = n;
		
		do {
			solution.add(0,currentNode);
			currentNode = currentNode.getParent();
		}while(!currentNode.isRoot());
		
	}
	
	public List<Node> getSolution() {
		return solution;
	}
	
	public Node getLastNode() {
		return solution.get(solution.size()-1);
	}
	
	public double getCost() {
		return solution.get(solution.size()-1).getCost();
	}

	@Override
	public boolean isSuccess() {
		return true;
	}
	
	@Override
	public String toString() {
		return ""+solution;
	}
}