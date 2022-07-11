import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import generators.TerrainGenerator;
import geometry.Line;
import geometry.Terrain;

class TesterForIntersections {

	@Test
	void test() {
		
		Terrain t = TerrainGenerator.getTerrainV1();
		
		List<Line> lines = new LinkedList<Line>();
		
		lines.add(new Line(1,4,8,9));
		lines.add(new Line(8,1,8,9));
		lines.add(new Line(2,2,9,9));
		lines.add(new Line(7,2,2,7));
		lines.add(new Line(1,1,3,9));
		lines.add(new Line(2,8,4,11));
		lines.add(new Line(8,11,11,8));
		lines.add(new Line(1,14,9,14));
		lines.add(new Line(0,5,4,11));
		lines.add(new Line(3,1,5,5));
		lines.add(new Line(3,1,5,1));
		lines.add(new Line(3,0,11,8));
		
		int[][] expectedPolygonsResults = {
				{0,0,1,0}, // 0
				{0,1,0,0}, // 1
				{1,1,0,0}, // 2
				{1,0,0,0}, // 3
				{0,0,1,0}, // 4
				{0,0,0,1}, // 5
				{0,0,0,0}, // 6
				{0,0,0,0}, // 7
				{0,0,1,1}, // 8
				{1,0,0,0}, // 9
				{0,0,0,0}, // 0
				{1,1,0,0}};// 1
		
		int[][] actualPolygonsResults = new int[lines.size()][];
		
		for(int j = 0; j < lines.size(); j++) {
			actualPolygonsResults[j] = new int[t.getPolygons().size()];
			for(int i = 0; i < t.getPolygons().size(); i++) {
				if(t.getPolygons().get(i).intersects(lines.get(j))) {
					actualPolygonsResults[j][i] = 1;
				}else {
					actualPolygonsResults[j][i] = 0;
				}
			}
		}
		
		assertArrayEquals(expectedPolygonsResults, actualPolygonsResults);
		
		int[][] expectedLinesResults = {
			//   0 1 2 3 4 5 6 7 8 9 0 1
				{0,0,0,1,1,0,0,0,0,0,0,0}, // 0
				{0,0,1,0,0,0,0,0,0,0,0,1}, // 1
				{0,1,0,1,0,0,0,0,0,1,0,0}, // 2
				{1,0,1,0,1,0,0,0,0,1,0,1}, // 3
				{1,0,0,1,0,0,0,0,0,0,0,0}, // 4
				{0,0,0,0,0,0,0,0,0,0,0,0}, // 5
				{0,0,0,0,0,0,0,0,0,0,0,0}, // 6
				{0,0,0,0,0,0,0,0,0,0,0,0}, // 7
				{0,0,0,0,0,0,0,0,0,0,0,0}, // 8
				{0,0,1,1,0,0,0,0,0,0,0,0}, // 9
				{0,0,0,0,0,0,0,0,0,0,0,1}, // 0
				{0,1,0,1,0,0,0,0,0,0,1,0}, // 1
				};
		
		int[][] actualLinesResults = new int[lines.size()][];
		
		for(int j = 0; j < lines.size(); j++) {
			actualLinesResults[j] = new int[lines.size()];
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersectsLine(lines.get(j))) {
					actualLinesResults[j][i] = 1;
				}else {
					actualLinesResults[j][i] = 0;
				}
			}
		}

		assertArrayEquals(expectedLinesResults, actualLinesResults);
	}
}
