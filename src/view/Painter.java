package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import geometry.Line;
import geometry.Rectangle;
import geometry.Terrain;
import pathSearch.tools.Path;

public class Painter extends Component{
	private static final long serialVersionUID = 6497705870337870842L;
	public static int tspGeographicMaxDistance = 500;
	
	private Terrain t;
	private Path p;
	
	public Painter(Terrain t, Path p) {
		this.t = t;
		this.p = p;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		for(Rectangle r : t.getPolygons()) {
			paintPolygon(g2d,r);
		}
		
		g2d.setColor(Color.RED);
		for(Line l : p.getSegments()){
			g2d.drawLine(l.getStartingPoint().x,l.getStartingPoint().y,l.getEndingPoint().x,l.getEndingPoint().y);
		}
	}

	private void paintPolygon(Graphics2D g2d,Rectangle r) {
		int size = r.getVertices().length;
		int xPoints[] = new int[size];
		int yPoints[] = new int[size];
		
		for(int i = 0; i < r.getVertices().length; i++) {
			xPoints[i] = r.getVertices()[i].x;
			yPoints[i] = r.getVertices()[i].y;
		}
		
		g2d.drawPolygon(xPoints,yPoints,size);
	}
	
	public static Frame printSolution(Terrain t, Path p,String frameTitle) {
		Frame f = new Frame();
		f.add(new Painter(t,p));
		int frameWidth = tspGeographicMaxDistance +50;
		int frameHeight = tspGeographicMaxDistance+50;
		f.setSize(frameWidth, frameHeight);
		f.setVisible(true);
		f.setTitle(frameTitle);
		return f;
	}	
}
