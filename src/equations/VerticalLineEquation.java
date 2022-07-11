package equations;

class VerticalLineEquation extends LineEquation{
	
	VerticalLineEquation(double x, double y1, double y2) {
		this.constant = x;
		lowerBound = Math.min(y1, y2);
		upperBound = Math.max(y1, y2);
//		this.vector = new Vector(x, y2-y1);
	}

	@Override
	public String toString() {
		return "x="+constant +" for "+lowerBound+" <= y <= "+upperBound;
	}

	@Override
	public boolean isSuperposed(LineEquation newLine) {
		if(this.getClass() != newLine.getClass())
			return false;
		return this.constant == newLine.constant;
	}
}
