package equations;

class HorizontalLineEquation extends LineEquation{
	
	HorizontalLineEquation(double x1, double x2, double y) {
		this.constant = y;
		this.lowerBound = Math.min(x1, x2);
		this.upperBound = Math.max(x1, x2);
//		this.vector = new Vector(x2-x1, y);
	}

	@Override
	public String toString() {
		return "y="+constant +" for "+lowerBound+" <= x <= "+upperBound;
	}

	@Override
	public boolean isSuperposed(LineEquation newLine) {
		if(this.getClass() != newLine.getClass())
			return false;
		return this.constant == newLine.constant;
	}

}
