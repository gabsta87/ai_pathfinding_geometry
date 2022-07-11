package equations;

public abstract class LineEquation {
	protected double constant, lowerBound, upperBound;
//	protected Vector vector;
//	protected Formatter f; 

	public LineEquation() {
//		f = new Formatter();
	}
	
	public abstract boolean isSuperposed(LineEquation otherLine);
}
