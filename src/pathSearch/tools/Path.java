package pathSearch.tools;

import java.util.List;

import geometry.Line;

public class Path {
	private List<Line> segments;
	private double cost;
	
	public Path(List<Line> segments) {
		this.segments = segments;
		double temp = 0;
		if(segments != null) {
			for(Line l : segments) {
				temp += l.getLength();
			}
			this.cost = temp;
		}
	}
	
	@Override
	public String toString() {
		if(segments == null || segments.size() == 0)
			return "Invalid path";
		
		String result = "Path ("+cost+") : "+segments.get(0).getStartingPoint();
		for (Line line : segments) {
			result += " - "+line.getEndingPoint();
		}
		return result;
	}
	
	public List<Line> getSegments(){
		return segments;
	}
}
