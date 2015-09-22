package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Shape;

public class CenterGraphicPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color c;
	private int x;
	private int y;
	private int diam;
	
	private final ArrayList<Shape> sl;
	
	public CenterGraphicPanel() {
		this.x = 0;
		this.y = 0;
		this.diam = 0;
		this.c = new Color(0, 0, 0);
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
		this.c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
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
	
	@Override
	public void paintComponent(Graphics g) {
	 	super.paintComponent(g);
	 	
	 	for (Shape s : sl) {
	 		g.setColor(s.getColor());
		 	g.fillOval(s.getX(), s.getY(), 20, 20);
	 	}
	 		 	
	 	
	}
	
	
	public class CursorListener1 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// drawCircle(arg0.getX(), arg0.getY(), 15);
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
			// TODO Auto-generated method stub drawCircleColorSpecify(e.getX(), e.getY(), 20, Color.MAGENTA);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			drawCircle(e.getX(), e.getY(), 20);
		}
		
	}
	
}
