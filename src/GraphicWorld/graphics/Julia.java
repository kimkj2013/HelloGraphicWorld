package graphics;

import geometry.Complex;

/**
 * 
 * @author kimk3
 *
 */
public class Julia {

	private static final int BAILOUT = 100;
	
	private static final double MAX_RADIUS = 2.0;
	
	private static final Complex C = new Complex(-0.4, 0.6);
	
	static final double A_START = -2.0;
	static final double A_END = 2.0;
	static final double B_START = 2.0;
	static final double B_END = -2.0;
	
	/**
	 * 
	 * @param z
	 * @param c
	 * @return
	 */
	private static Complex f(Complex z) {
		return Complex.add((Complex.multiply(z, z)), C);
	}
	
	/**
	 * 
	 * @param z
	 * @return
	 */
	static boolean escapes(Complex z) {
		for (int i = 0; i < BAILOUT; i++) {
			if (z.getModulus() > MAX_RADIUS) {
				return true;
			}
			z = f(z);
			// System.out.println(z);
		}
		return false;
	}
}
