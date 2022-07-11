package equations;

public class EquationCreator {
	
	public static LineEquation getLineEquation(double x1, double y1, double x2, double y2) {
		if(x1 == x2) {
			return new VerticalLineEquation(x1, y1, y2);
		}else if (y1 == y2) {
			return new HorizontalLineEquation(x1, x2, y1);
		}else {
			return new StandardLineEquation(x1, y1, x2, y2);
		}
	}

}
