import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import geometry.Line;
import geometry.Polygon;
import view.Painter;

public class Launcher {
	
	public static void main(String[] args) {
		
		List<Polygon> polygons = new LinkedList<Polygon>();
		
		Polygon p0 = new Polygon(new Point(3,1),new Point(5,1),new Point(5,5),new Point(3,5));
		Polygon p1 = new Polygon(new Point(7,4),new Point(10,4),new Point(10,7),new Point(7,7));
		Polygon p2 = new Polygon(new Point(4,6),new Point(5,8),new Point(2,8));
		Polygon p3 = new Polygon(new Point(2,10),new Point(7,10),new Point(7,14),new Point(2,14));
		
		polygons.add(p0);
		polygons.add(p1);
		polygons.add(p2);
		polygons.add(p3);
		
		List<Line> lines = new LinkedList<Line>();
		
		Line v0 = new Line(1,4,8,9);
		Line v1 = new Line(8,1,8,9);
		Line v2 = new Line(2,2,9,9);
		Line v3 = new Line(7,2,2,7);
		Line v4 = new Line(1,1,3,9);
		Line v5 = new Line(2,8,4,11);
		Line v6 = new Line(8,11,11,8);
		Line v7 = new Line(1,14,9,14);
		Line v8 = new Line(0,5,4,11);
		
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
		
		Painter p = new Painter();
		p.addLines(lines);
		p.addPolygons(polygons);
	}
}
