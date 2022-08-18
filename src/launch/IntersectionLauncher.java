package launch;
import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import geometry.Polygon;
import geometry.Rectangle;
import geometry.Terrain;
import pathSearch.tools.Path;
import view.Painter;

public class IntersectionLauncher {
	
	public static void main(String[] args) {
		
		List<Rectangle> polygons = new LinkedList<Rectangle>();
		
		Rectangle p0 = new Rectangle(new Point(30,10),new Point(50,10),new Point(50,50),new Point(30,50));
		Rectangle p1 = new Rectangle(new Point(70,40),new Point(100,40),new Point(100,70),new Point(70,70));
		Rectangle p2 = new Rectangle(new Point(40,60),new Point(50,80),new Point(20,80));
		Rectangle p3 = new Rectangle(new Point(20,100),new Point(70,100),new Point(70,140),new Point(20,140));
		
		polygons.add(p0);
		polygons.add(p1);
		polygons.add(p2);
		polygons.add(p3);
		
		List<Line> lines = new LinkedList<Line>();
		
		Line v0 = new Line(10,40,80,90);
		Line v1 = new Line(80,10,80,90);
		Line v2 = new Line(20,20,90,90);
		Line v3 = new Line(70,20,20,70);
		Line v4 = new Line(10,10,30,90);
		Line v5 = new Line(20,80,40,110);
		Line v6 = new Line(80,110,110,80);
		Line v7 = new Line(10,140,90,14);
		Line v8 = new Line(0,50,40,110);
		
		lines.add(v0);
		lines.add(v1);
		lines.add(v2);
		lines.add(v3);
		lines.add(v4);
		lines.add(v5);
		lines.add(v6);
		lines.add(v7);
		lines.add(v8);
		
		int vectorCounter = 0;
		int polygonCounter = 0;
		
		for (Line line : lines) {
			System.out.print("Line "+vectorCounter +" intersects polygons ");
			for (Polygon polygon : polygons) {
				if(polygon.intersects(line)) {
					System.out.print(polygonCounter+", ");
				}
				polygonCounter++;
			}
			System.out.println();
			polygonCounter = 0;
			vectorCounter++;
		}
		
		int vector1Counter = 0;
		int vector2Counter = 0;
		
		for (Line line : lines) {
			System.out.print("Line "+vector1Counter+" intersects lines ");
			for (Line line2 : lines) {
				if(!line.equals(line2) && line2.intersectsLine(line)) {
					System.out.print(vector2Counter+", ");
				}
				vector2Counter++;
			}
			System.out.println();
			vector2Counter = 0;
			vector1Counter++;
		}
		Path pa = new Path(lines);
		Terrain t = new Terrain();
		t.addPolygons(polygons);

		Painter.printSolution(t, pa, "Intersection tests");
	}
}
