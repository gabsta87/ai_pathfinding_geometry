package equations;

class StandardLineEquation extends LineEquation{
	private double coeff;
	
	StandardLineEquation(double x1, double y1, double x2, double y2) {
//		vector = new Vector(x2-x1, y2-y1);

		if(x2==x1) {
			coeff = 0;
		}else {
			coeff = (y2-y1)/(x2-x1);
		}
		
		constant = y1-x1*((y2-y1)/(x2-x1));
		
		lowerBound = Math.min(x1, x2);
		upperBound = Math.max(x1, x2);
	}
	
	@Override
	public String toString() {
		return "y="+ coeff+"x + "+constant+" for "+lowerBound+" <= x <= "+upperBound;
	}
	
	@Override
	public boolean isSuperposed(LineEquation newLine) {
		if(this.getClass() != newLine.getClass())
			return false;
		return this.constant == newLine.constant && this.coeff == ((StandardLineEquation)newLine).coeff;
	}
	
}
