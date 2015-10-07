package geometry;

import java.awt.Color;

/**
 * 
 * @author kimk3
 *
 */
public class Circle extends Shape {
	
	/**
	 * 
	 */
	private int diam;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param diam
	 * @param c
	 */
	public Circle(int x, int y, int diam, Color c) {
		super();
		this.x = x;
		this.y = y;
		this.diam = diam;
		this.c = c;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDiameter() {
		return diam;
	}
	
}
