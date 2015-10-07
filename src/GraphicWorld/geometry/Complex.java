package geometry;

/**
 * 
 * @author kimk3
 *
 */
public class Complex {

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static final Complex add(Complex c1, Complex c2) {
		return new Complex(c1.real + c2.real, c1.imaginary + c2.imaginary);
	}
	
	public static final Complex multiply(Complex c1, Complex c2) {
		double mulReal, mulImaginary;
		// c1 = ax + b, c2 = cx + d
		// acx^2 + adx + bcx + bd
		mulReal = (c1.real * c2.real) - (c1.imaginary * c2.imaginary);
		mulImaginary = (c1.real * c2.imaginary) + (c2.real * c1.imaginary);
		return new Complex(mulReal, mulImaginary);
	}
	
	/**
	 * 
	 */
	private double real;
	/**
	 * 
	 */
	private double imaginary;
	
	/**
	 * 
	 * @param real
	 * @param imaginary
	 */
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getRealPart() {
		return this.real;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getImaginaryPart() {
		return this.imaginary;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getModulus() {
		return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
	}
	
	@Override
	/**
	 * 
	 */
	public String toString() {
		return Double.toString(this.real) + " + " + Double.toString(this.imaginary) + "i";
	}
	
}
