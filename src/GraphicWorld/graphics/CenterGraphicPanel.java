package graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Complex;
import geometry.Shape;
import geometry.Triangle;

/**
 * 
 * @author Kwangju Kim
 *
 */
public class CenterGraphicPanel extends JPanel {

	/**
	 * Serial Version User ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Color tracker for individual circle object, but not really important
	 */
	private Color c;
	/**
	 * Horizontal mouse pointer which will be tracked and used by
	 * paintComponent() method
	 */
	private int mouseX;
	/**
	 * Vertical mouse pointer which will be tracked and used by paintComponent()
	 * method
	 */
	private int mouseY;

	/**
	 * The flag determines whether the image glows or not.
	 */
	public boolean flag = false;

	/**
	 * Another flag called 'drawable' determines whether the user can draw on a
	 * canvas or not.
	 */
	public boolean drawable = true;

	private final ArrayList<Shape> sl;

	/**
	 * Constructor of the panel, where the user will get a canvas
	 */
	public CenterGraphicPanel() {
		this.c = new Color(0, 0, 0);
		this.mouseX = 0;
		this.mouseY = 0;
		this.sl = new ArrayList<Shape>();
		this.setLayout(new FlowLayout());
		this.setSize(600, 600);
		this.setBackground(Color.BLACK);
		this.addMouseListener(new CursorListener1());
		this.addMouseMotionListener(new CursorListener2());
		this.setVisible(true);
	}

	/**
	 * Erase all on a canvas
	 */
	void deleteAll() {
		this.sl.clear();
	}

	/**
	 * Returns a list of shapes
	 * 
	 * @return a list of shapes
	 */
	ArrayList<Shape> getShapeList() {
		return this.sl;
	}

	/**
	 * Draw circle, random color
	 * 
	 * @param x
	 * @param y
	 * @param diam
	 */
	private void drawCircle(int x, int y, int diam) {
		this.c = generateRandomColor();
		drawCircleColorSpecify(x, y, diam, c);
	}

	/**
	 * Draw circle, specifying color
	 * 
	 * @param x
	 * @param y
	 * @param diam
	 * @param c
	 */
	private void drawCircleColorSpecify(int x, int y, int diam, Color c) {
		this.c = c;
		sl.add(new Circle(x, y, diam, c));
		repaint();
	}

	/**
	 * Generate random color using random integer, each will be assigned to R,
	 * G, and B
	 * 
	 * @return
	 */
	public Color generateRandomColor() {
		return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}
	
	
	public Color generateRandomColor2() {
		int colorflag = (int) (Math.random() * 3);
		return generateRandomColor2(colorflag);
	}
	
	public Color generateRandomColor2(int colorflag) {
		if (colorflag == 0) {
			return new Color((int) (Math.random() * 256), 0, 0);
		}
		if (colorflag == 1) {
			return new Color(0, (int) (Math.random() * 256), 0);
		}
		return new Color(0, 0, (int) (Math.random() * 256));
	}

	/**
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.LIGHT_GRAY);
		g.drawString(new Point(mouseX, mouseY).toString(), mouseX, mouseY);

		for (Shape s : sl) {
			if (flag)
				g.setColor(generateRandomColor());
			else
				g.setColor(s.getColor());
			g.fillOval(s.getX(), s.getY(), ((Circle) s).getDiameter(), ((Circle) s).getDiameter());
		}

		repaint();
	}

	/**
	 * Draw graphics of Julia set
	 */
	public void drawJulia() {
		int a = (int) (Math.random() * 3);
		for (double pixel1 = 0; pixel1 <= this.getWidth(); pixel1++) {
			double x = map(pixel1, 0, this.getWidth(), Julia.A_START, Julia.A_END);

			for (double pixel2 = 0; pixel2 <= this.getHeight(); pixel2++) {
				double y = map(pixel2, 0, this.getHeight(), Julia.B_START, Julia.B_END);
				// System.out.printf("%.2f, %.2f\n", x, y);

				// System.out.println(w);
				if (!Julia.escapes(new Complex(x, y)))
					drawCircleColorSpecify((int) pixel1, (int) pixel2, 7, generateRandomColor2(a));
			}
		}
		// System.out.println("Done drawing");
		repaint();
	}

	/**
	 * Draw graphics of Mandelbrot set
	 */
	public void drawMandelbrot() {
		int a = (int) (Math.random() * 3);
		for (double pixel1 = 0; pixel1 <= this.getWidth(); pixel1++) {
			double x = map(pixel1, 0, this.getWidth(), Mandelbrot.A_START, Mandelbrot.A_END);

			for (double pixel2 = 0; pixel2 <= this.getHeight(); pixel2++) {
				double y = map(pixel2, 0, this.getHeight(), Mandelbrot.B_START, Mandelbrot.B_END);
				// System.out.printf("%.2f, %.2f\n", x, y);

				// System.out.println(w);
				if (!Mandelbrot.escapes(new Complex(0, 0), new Complex(x, y)))
					drawCircleColorSpecify((int) pixel1, (int) pixel2, 2, generateRandomColor2(a));
			}
		}
		// System.out.println("Done drawing");
		repaint();
	}

	/**
	 * Draw fractal triangle
	 */
	public void drawTriangle() {
		Triangle t = new Triangle(this.getWidth(), this.getHeight());
		Point[] p = t.getVertex();
		ArrayList<Point> q = t.getPoints();

		for (Point x : p) {
			drawCircle(x.x, x.y, 10);
		}
		for (Point x : q) {
			drawCircle(x.x, x.y, 10);
		}
		repaint();

	}

	/**
	 * map() function implemented from Processing 2.0
	 * @param x
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	private static double map1(double x, double a, double b, double c, double d) {
		return c + ((x - a) * (d - c)) / (b - a);
	}

	/**
	 * Gets the value which will be mapped into another value in certain interval
	 * @param value
	 * @param start1
	 * @param stop1
	 * @param start2
	 * @param stop2
	 * @return
	 */
	public static double map(double value, double start1, double stop1, double start2, double stop2) {
		return map1(value, start1, stop1, start2, stop2);
	}

	/**
	 * 
	 * @author Kwangju
	 *
	 */
	public class CursorListener1 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if (drawable) {
				mouseX = arg0.getX();
				mouseY = arg0.getY();
				drawCircle(arg0.getX(), arg0.getY(), 15);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	public class CursorListener2 implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub drawCircleColorSpecify(e.getX(),
			// e.getY(), 20, Color.MAGENTA);
			if (drawable) {
				mouseX = e.getX();
				mouseY = e.getY();
				drawCircle(e.getX(), e.getY(), 20);
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseX = e.getX();
			mouseY = e.getY();
		}

	}

}
