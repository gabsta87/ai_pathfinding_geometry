package solutionSearch;

import java.util.List;

public class UniformCostSearch extends PathFinder{

	public UniformCostSearch(Problem p) {
		super(p);
	}

	@Override
	public Answer findRoute() {
		Node actualNode = new Node(problem);
		List<Node> frontier = actualNode.exploreNode();
		
		while(!actualNode.isSolved()) {
			if(frontier.isEmpty())
				return new Failure();
			
			frontier.sort(null);
			
			actualNode = frontier.remove(0);
			
			for (Node n: actualNode.exploreNode()) {
				frontier.add(n);
			}
		}
		return new Success(actualNode);
	}

	@Override
	public String getName() {
		return "Uniform Cost Search";
	}
}
