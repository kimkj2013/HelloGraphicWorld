package geometry;

import java.awt.Color;

/**
 * 
 * An abstract shape object
 * 
 * @author Kwangju Kim
 *
 */
public abstract class Shape {

	/**
	 * 
	 */
	protected int x;
	/**
	 * 
	 */
	protected int y;
	/**
	 * 
	 */
	protected Color c;

	/**
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return
	 */
	public Color getColor() {
		return c;
	}

}
