package geometry;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import equations.EquationCreator;
import equations.LineEquation;

public class Line extends Line2D implements Comparable<Line>{
	private Point startingPoint, endingPoint;
	private LineEquation lineEquation;
	
	public Line(Point start, Point end) {
		this.startingPoint = start;
		this.endingPoint = end;
		this.lineEquation = EquationCreator.getLineEquation(startingPoint.getX(), startingPoint.getY(), endingPoint.getX(), endingPoint.getY());
	}
	
	public Line(int x1, int y1, int x2, int y2) {
		this(new Point(x1, y1),new Point(x2, y2));
	}
	
	public boolean intersectsLine(Line l) {
		if(this == l)
			return false;
		
		if(this.lineEquation.isSuperposed(l.lineEquation))
			return false;
		
		if(this.startingPoint.equals(l.startingPoint) 
				|| this.startingPoint.equals(l.endingPoint) 
				|| this.endingPoint.equals(l.startingPoint)
				|| this.endingPoint.equals(l.endingPoint))
			return false;
		
		if(this.findMaxXValue() <= l.findMinXValue()
				|| this.findMinXValue() >= l.findMaxXValue()
				|| this.findMaxYValue() <= l.findMinYValue()
				|| this.findMinYValue() >= l.findMaxYValue()) {
			return false;
		}
		
		return super.intersectsLine(l);
	}
	
	public Point getStartingPoint() {
		return startingPoint;
	}
	
	public Point getEndingPoint() {
		return endingPoint;
	}
	
	public double getLength() {
		return startingPoint.distance(endingPoint);
	}
	
	private double findMinXValue() {
		return Math.min(getX1(), getX2());
	}
	
	private double findMinYValue() {
		return Math.min(getY1(), getY2());
	}
	
	private double findMaxXValue() {
		return Math.max(getX1(), getX2());
	}
	
	private double findMaxYValue() {
		return Math.max(getY1(), getY2());
	}
	
	@Override
	public boolean equals(Object o) {
		if( o == null || o.getClass() != this.getClass())
			return false;
		Line l = ((Line)o);
		return startingPoint.equals(l.startingPoint) && endingPoint.equals(l.endingPoint)
				|| startingPoint.equals(l.endingPoint) && endingPoint.equals(l.startingPoint);
	}
	
	@Override
	public String toString() {
		return startingPoint+"-"+endingPoint;
	}
	
	public String toStringWithEquation() {
		return this +" ("+lineEquation+")";
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return new Rectangle(startingPoint,
				new Dimension(
						(int)Math.ceil(endingPoint.getX()-startingPoint.getX()), 
						(int)Math.ceil(endingPoint.getX()-startingPoint.getY())));
	}

	@Override
	public double getX1() {
		return startingPoint.getX();
	}

	@Override
	public double getY1() {
		return startingPoint.getY();
	}

	@Override
	public Point2D getP1() {
		return startingPoint;
	}

	@Override
	public double getX2() {
		return endingPoint.getX();
	}

	@Override
	public double getY2() {
		return endingPoint.getY();
	}

	@Override
	public Point2D getP2() {
		return endingPoint;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		this.startingPoint = new Point((int)Math.round(x1), (int)Math.round(y1));
		this.endingPoint = new Point((int)Math.round(x2), (int)Math.round(y2));
	}

	@Override
	public int compareTo(Line o) {
		return java.lang.Double.compare(startingPoint.distance(endingPoint), o.startingPoint.distance(o.endingPoint));
	}
}
