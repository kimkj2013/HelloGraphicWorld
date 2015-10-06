package graphics;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Shape;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CenterGraphicPanel mainframe;
	
	public Window() {
		super("Hello Graphic World");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 600));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.upperLayout();
		this.centerLayout();
		this.bottomLayout();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void upperLayout() {
		JPanel copyright = new JPanel();
		copyright.setLayout(new FlowLayout());
		copyright.add(new JLabel("(C) 2015 Kwangju Kim & Miami University. All Rights Reserved."));
		JButton credit = new JButton("Credit");
		credit.addActionListener(new BottomListener());
		copyright.add(credit);
		this.add(copyright, BorderLayout.NORTH);
	}

	private void centerLayout() {
		this.mainframe = new CenterGraphicPanel();
		this.add(mainframe, BorderLayout.CENTER);
	}

	private void bottomLayout() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new java.awt.GridLayout());
		BottomListener bl = new BottomListener();
		JButton[] bstore = new JButton[5];
		bstore[0] = new JButton("Julia");
		bstore[1] = new JButton("Mandelbrot");
		bstore[2] = new JButton("Triangle");
		bstore[3] = new JButton("Erase");
		bstore[4] = new JButton("Exit");
		for (int i = 0; i < 5; i++) {
			bstore[i].addActionListener(bl);
			buttons.add(bstore[i]);
		}

		this.add(buttons, BorderLayout.SOUTH);
	}
	
	private void eraseAll() {
		this.mainframe.deleteAll();
	}
	
	private ArrayList<Shape> getCompList() {
		return this.mainframe.getShapeList();
	}

	public class BottomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String event = arg0.getActionCommand();
			if (event.startsWith("Erase")) {
				eraseAll();
				repaint();
				return;
			}
			if (event.startsWith("Triangle")) {
				
			}
			if (event.startsWith("Exit")) {
				System.exit(0);
				return;
			}
			if (event.startsWith("Credit")) {
				JOptionPane.showMessageDialog(new Frame(),
						new String("Designed by Kwangju Kim\nMiami University Class of 2017"
								+ "\nCollege of Engineering and Computing"
								+ "\nComputer Science Major\nContact: +1 513 461 5693"
								+ "\nHomepage: http://www.users.miamioh.edu/kimk3" + "\nEmail: kimk3@miamioh.edu"
								+ "\nInspired by Professor Norman Krumpe"));
				return;
			}
			JOptionPane.showMessageDialog(new JFrame(), new String("Something went wrong. Ask the programmer."),
					"Error Message", JOptionPane.ERROR_MESSAGE);
		}

	}

}
