package geometry;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Triangle {

	public static final int BAILOUT = 5000;
	
	private Point[] vertex;
	private ArrayList<Point> rand;

	// public static final int DIAM = 10;
	
	public Triangle(int x, int y) {
		setupVertices();
		setupRandomPoints(x, y);
		for (int i = 0; i < BAILOUT; i++) {
			nextRandomPoint();
		}
	}
	
	public Point[] getVertex() {
		return this.vertex;
	}
	
	public ArrayList<Point> getPoints() {
		return this.rand;
	}

	public void nextRandomPoint() {
		/*
		 * Grab random vertex and last random point
		 */
		int randVertex = (int) (3 * Math.random());
		Point p1 = vertex[randVertex];
		Point p2 = rand.get(rand.size() - 1);

		/*
		 * Compute Midpoint
		 */
		int midX = (p1.x + p2.x) / 2;
		int midY = (p1.y + p2.y) / 2;

		rand.add(new Point(midX, midY));
	}

	/*
	 * Initialize the array with coordinates of the three vertices
	 */
	public void setupVertices() {
		vertex = new Point[3];
		vertex[0] = new Point(3, 465);
		vertex[1] = new Point(300, 12);
		vertex[2] = new Point(575, 465);
	}

	/*
	 * Initialize the ArrayList with the first random point
	 */
	public void setupRandomPoints(int randx, int randy) {
		rand = new ArrayList<Point>();

		Random r = new Random();
		int x = r.nextInt(randx);
		int y = r.nextInt(randy);

		rand.add(new Point(x, y));
	}
	
	public void clear() {
		this.rand = null;
		this.vertex = null;
	}

}
