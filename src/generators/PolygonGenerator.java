package generators;

import geometry.Point;
import geometry.Rectangle;

public class PolygonGenerator {
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return a polygon defined by its bottom left and top right corners
	 */
	public static Rectangle createRectangle(int x1, int y1, int x2, int y2) {
		return new Rectangle(new Point(x1,y1),new Point(x2,y1), new Point(x2,y2), new Point(x1,y2));
	}
}
