package generators;

import geometry.Point;
import geometry.Rectangle;
import geometry.Terrain;

public class TerrainGenerator {
	public static Terrain getTerrainV1() {

		Terrain t = new Terrain();
		
		Rectangle p0 = new Rectangle(new Point(30,10),new Point(50,10),new Point(50,50),new Point(30,50));
		Rectangle p1 = new Rectangle(new Point(70,40),new Point(100,40),new Point(100,70),new Point(70,70));
		Rectangle p2 = new Rectangle(new Point(40,60),new Point(50,80),new Point(20,80));
		Rectangle p3 = new Rectangle(new Point(20,100),new Point(70,100),new Point(70,140),new Point(20,140));
		
		t.addPolygon(p0);
		t.addPolygon(p1);
		t.addPolygon(p2);
		t.addPolygon(p3);
		
		return t;
	}
	
	public static Terrain getTerrainV2() {

		Terrain t = new Terrain();
		
		t.addPolygon(PolygonGenerator.createRectangle(10,10,20,40));
		t.addPolygon(PolygonGenerator.createRectangle(30,20,60,40));
		t.addPolygon(PolygonGenerator.createRectangle(70,10,90,70));
		t.addPolygon(PolygonGenerator.createRectangle(20,50,50,70));
		t.addPolygon(PolygonGenerator.createRectangle(30,80,80,100));
		t.addPolygon(PolygonGenerator.createRectangle(10,80,20,130));
		t.addPolygon(PolygonGenerator.createRectangle(100,10,140,40));
		t.addPolygon(PolygonGenerator.createRectangle(130,50,150,80));
		t.addPolygon(PolygonGenerator.createRectangle(140,90,160,120));
		t.addPolygon(PolygonGenerator.createRectangle(150,10,160,40));
		
		t.addPolygon(PolygonGenerator.createRectangle(180,10,200,60));
		t.addPolygon(PolygonGenerator.createRectangle(180,70,200,110));
		t.addPolygon(PolygonGenerator.createRectangle(180,120,230,130));
		t.addPolygon(PolygonGenerator.createRectangle(210,10,230,40));
		t.addPolygon(PolygonGenerator.createRectangle(220,50,250,80));
		t.addPolygon(PolygonGenerator.createRectangle(210,90,250,110));
		
		t.addPolygon(PolygonGenerator.createRectangle(320,10,340,40));
		t.addPolygon(PolygonGenerator.createRectangle(320,50,340,80));
		t.addPolygon(PolygonGenerator.createRectangle(350,10,440,30));
		
		t.addPolygon(PolygonGenerator.createRectangle(10,170,30,200));
		t.addPolygon(PolygonGenerator.createRectangle(10,210,50,220));
		t.addPolygon(PolygonGenerator.createRectangle(10,230,80,240));
		
		t.addPolygon(PolygonGenerator.createRectangle(150,220,220,240));
		t.addPolygon(PolygonGenerator.createRectangle(200,170,220,210));
		t.addPolygon(PolygonGenerator.createRectangle(230,200,250,230));
		t.addPolygon(PolygonGenerator.createRectangle(230,170,270,190));
		t.addPolygon(PolygonGenerator.createRectangle(260,210,280,240));
		t.addPolygon(PolygonGenerator.createRectangle(290,230,350,240));
		
		t.addPolygon(PolygonGenerator.createRectangle(370,170,400,200));
		t.addPolygon(PolygonGenerator.createRectangle(370,210,390,240));
		t.addPolygon(PolygonGenerator.createRectangle(410,170,440,190));
		
		// Remplacement des angles par une combinaison de rectangles
		
		t.addPolygon(PolygonGenerator.createRectangle(40,110,120,130));
		t.addPolygon(PolygonGenerator.createRectangle(100,50,120,110));

		t.addPolygon(PolygonGenerator.createRectangle(120,170,140,240));
		t.addPolygon(PolygonGenerator.createRectangle(140,170,190,190));

		t.addPolygon(PolygonGenerator.createRectangle(40,170,60,190));
		t.addPolygon(PolygonGenerator.createRectangle(60,170,80,220));

		t.addPolygon(PolygonGenerator.createRectangle(240,10,260,30));
		t.addPolygon(PolygonGenerator.createRectangle(260,10,280,60));

		t.addPolygon(PolygonGenerator.createRectangle(260,70,280,120));
		t.addPolygon(PolygonGenerator.createRectangle(240,120,280,130));

		t.addPolygon(PolygonGenerator.createRectangle(280,170,330,190));
		t.addPolygon(PolygonGenerator.createRectangle(330,170,350,220));

		t.addPolygon(PolygonGenerator.createRectangle(320,90,340,130));
		t.addPolygon(PolygonGenerator.createRectangle(340,110,380,130));

		t.addPolygon(PolygonGenerator.createRectangle(360,50,380,80));
		t.addPolygon(PolygonGenerator.createRectangle(360,80,400,100));

		t.addPolygon(PolygonGenerator.createRectangle(420,50,440,110));
		t.addPolygon(PolygonGenerator.createRectangle(390,110,440,130));

		t.addPolygon(PolygonGenerator.createRectangle(400,220,440,240));
		t.addPolygon(PolygonGenerator.createRectangle(420,200,440,220));

		
		// Test de construction des polygones complexes
//		Polygon p1 = new Polygon(new Point(40,110),new Point(100,110),new Point(100,50),new Point(120,50),new Point(120,130),new Point(40,130));
//		t.addPolygon(p1);
//		
//		Polygon p2 = new Polygon(new Point(40,190),new Point(60,190),new Point(60,220),new Point(80,220),new Point(80,170),new Point(40,170));
//		t.addPolygon(p2);
//
//		Polygon p3 = new Polygon(new Point(190,190),new Point(140,190),new Point(140,240),new Point(120,240),new Point(120,170),new Point(190,170));
//		t.addPolygon(p3);
//
//		Polygon p4 = new Polygon(new Point(240,30),new Point(260,30),new Point(260,60),new Point(280,60),new Point(280,10),new Point(240,10));
//		t.addPolygon(p4);
//		
//		Polygon p5 = new Polygon(new Point(260,70),new Point(260,120),new Point(240,120),new Point(240,130),new Point(280,130),new Point(280,70));
//		t.addPolygon(p5);
//
//		Polygon p6 = new Polygon(new Point(280,190),new Point(330,190),new Point(330,220),new Point(350,220),new Point(350,170),new Point(280,170));
//		t.addPolygon(p6);
//
//		Polygon p7 = new Polygon(new Point(340,90),new Point(340,110),new Point(380,110),new Point(380,130),new Point(320,130),new Point(320,90));
//		t.addPolygon(p7);
//
//		Polygon p8 = new Polygon(new Point(380,50),new Point(380,80),new Point(380,100),new Point(400,100),new Point(360,100),new Point(360,50));
//		t.addPolygon(p8);
//
//		Polygon p9 = new Polygon(new Point(420,50),new Point(420,110),new Point(390,110),new Point(390,130),new Point(440,130),new Point(440,50));
//		t.addPolygon(p9);
//
//		Polygon p10 = new Polygon(new Point(420,200),new Point(420,220),new Point(400,220),new Point(400,240),new Point(440,240),new Point(440,200));
//		t.addPolygon(p10);

		return t;
	}
}
