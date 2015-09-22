package geometry;

import java.awt.Color;

public class Circle extends Shape {
	
	private int diam;

	public Circle(int x, int y, int diam, Color c) {
		super();
		this.x = x;
		this.y = y;
		this.diam = diam;
		this.c = c;
	}
	
	public int getDiameter() {
		return diam;
	}
	
}
