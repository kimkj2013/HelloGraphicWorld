package graphics;

import java.awt.Color;
import java.awt.Dimension;
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
 * @author kimk3
 *
 */
public class CenterGraphicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color c;
	private int x;
	private int y;
	private int diam;
	
	private int mouseX;
	private int mouseY;

	public boolean flag = false;

	private final ArrayList<Shape> sl;

	public CenterGraphicPanel() {
		this.x = 0;
		this.y = 0;
		this.diam = 0;
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

	void deleteAll() {
		this.sl.clear();
	}

	ArrayList<Shape> getShapeList() {
		return this.sl;
	}

	private void drawCircle(int x, int y, int diam) {
		this.c = new Color((int) (Math.random() * 256),
				(int) (Math.random() * 256), (int) (Math.random() * 256));
		drawCircleColorSpecify(x, y, diam, c);
	}

	private void drawCircleColorSpecify(int x, int y, int diam, Color c) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.diam = diam;
		sl.add(new Circle(x, y, diam, c));
		repaint();
	}

	public Color generateRandomColor() {
		return new Color((int) (Math.random() * 256),
				(int) (Math.random() * 256), (int) (Math.random() * 256));
	}

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
			g.fillOval(s.getX(), s.getY(), ((Circle) s).getDiameter(),
					((Circle) s).getDiameter());
		}

		repaint();
	}

	public void drawJulia() {
		for (double pixel1 = 0; pixel1 <= this.getWidth(); pixel1++) {
			double x = map(pixel1, 0, this.getWidth(), Julia.A_START,
					Julia.A_END);

			for (double pixel2 = 0; pixel2 <= this.getHeight(); pixel2++) {
				double y = map(pixel2, 0, this.getHeight(), Julia.B_START,
						Julia.B_END);
				// System.out.printf("%.2f, %.2f\n", x, y);
				boolean w = Julia.escapes(new Complex(x, y));
				// System.out.println(w);
				if (!w)
					drawCircle((int) pixel1, (int) pixel2, 10);
			}
		}
		System.out.println("Done drawing");
		repaint();
	}

	public void drawMandelbrot() {
		for (double pixel1 = 0; pixel1 <= this.getWidth(); pixel1++) {
			double x = map(pixel1, 0, this.getWidth(), Mandelbrot.A_START,
					Mandelbrot.A_END);

			for (double pixel2 = 0; pixel2 <= this.getHeight(); pixel2++) {
				double y = map(pixel2, 0, this.getHeight(), Mandelbrot.B_START,
						Mandelbrot.B_END);
				// System.out.printf("%.2f, %.2f\n", x, y);
				boolean w = Mandelbrot.escapes(new Complex(x, y), new Complex(0, 0));
				// System.out.println(w);
				if (!w)
					drawCircle((int) pixel1, (int) pixel2, 10);
			}
		}
		System.out.println("Done drawing");
		repaint();
	}

	public void drawTriangle() {
		Triangle t = new Triangle();
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

	private static double map1(double x, double a, double b, double c, double d) {
		return c + ((x - a) * (d - c)) / (b - a);
	}
	
	public static double map(double value, double start1, double stop1,
			double start2, double stop2) {
		return map1(value, start1, stop1, start2, stop2);
	}

	public class CursorListener1 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			drawCircle(arg0.getX(), arg0.getY(), 20);
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
			mouseX = e.getX();
			mouseY = e.getY();
			drawCircle(e.getX(), e.getY(), 20);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseX = e.getX();
			mouseY = e.getY();
		}

	}

}
