package solutionSearch;

public abstract class PathFinder {
	protected Problem problem;
	
	public PathFinder(Problem p) {
		this.problem = p;
	}
	
	public abstract Answer findRoute();
	
	public abstract String getName();
}
