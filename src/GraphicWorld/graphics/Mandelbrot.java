package graphics;

import geometry.Complex;

public class Mandelbrot {

	private static final int BAILOUT = 100;
	
	private static final double MAX_RADIUS = 2.0;
	
	// private static final Complex C = new Complex(0, 0);
	
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
	private static Complex f(Complex z, Complex c) {
		return Complex.add((Complex.multiply(z, z)), c);
	}
	
	/**
	 * 
	 * @param z
	 * @return
	 */
	static boolean escapes(Complex z, Complex c) {
		for (int i = 0; i < BAILOUT; i++) {
			if (z.getModulus() > MAX_RADIUS) {
				return true;
			}
			z = f(z, c);
		}
		return false;
	}
}
