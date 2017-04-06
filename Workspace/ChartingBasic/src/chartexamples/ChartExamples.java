package chartexamples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartExamples extends JFrame {

	private static final long serialVersionUID = 1L;

	// field

	JPanel myPanel = new JPanel();
	JButton lineButton = new JButton();
	JButton spiralButton = new JButton();
	JButton barButton = new JButton();
	JButton pieButton = new JButton();
	// data arrays
	double[] x = new double[200];
	double[] y = new double[200];
	double[] yd = new double[200];
	Color[] plotColor = new Color[10];
	Random myRandom = new Random();

	// constructor
	public ChartExamples() {

		setTitle("Chart Examples by Cameron Storm");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}

		});

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		myPanel.setPreferredSize(new Dimension(400, 300));
		myPanel.setBackground(Color.white);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(myPanel, c);

		lineButton.setText("Line");
		c = new GridBagConstraints();
		lineButton.setPreferredSize(new Dimension(100, 25));
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(lineButton, c);
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineButtonActionPerformed(e);
			}
		});

		spiralButton.setText("Spiral");
		c = new GridBagConstraints();
		spiralButton.setPreferredSize(new Dimension(100, 25));
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(spiralButton, c);
		spiralButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiralButtonActionPerformed(e);
			}
		});

		barButton.setText("Bar");
		c = new GridBagConstraints();
		barButton.setPreferredSize(new Dimension(100, 25));
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(barButton, c);
		barButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barButtonActionPerformed(e);
			}
		});

		pieButton.setText("Pie");
		c = new GridBagConstraints();
		pieButton.setPreferredSize(new Dimension(100, 25));
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(pieButton, c);
		pieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pieButtonActionPerformed(e);
			}
		});

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		// 
		//
		//
		//
		plotColor[0] = Color.YELLOW;
		plotColor[1] = Color.BLUE;
		plotColor[2] = Color.GREEN;
		plotColor[3] = Color.CYAN;
		plotColor[4] = Color.RED;
		plotColor[5] = Color.MAGENTA;
		plotColor[6] = Color.ORANGE;
		plotColor[7] = Color.DARK_GRAY;
		plotColor[8] = Color.GRAY;
		plotColor[9] = Color.BLACK;

	}

	private void lineButtonActionPerformed(ActionEvent e) {
		// Draws line and spiral charts
		// Create a sinusoid with 200 points
		double alpha = 0.1 - myRandom.nextDouble() * 0.2;
		double beta = myRandom.nextDouble() * 10 + 5;
		for (int i = 0; i < 200; i++) {
			// just like math class, plot y as a function of x
			// y = f(x)
			// for example, y = mx + b is a straight line
			// y = ax^2 + bx + c is a quadratic, plots as parabola
			// to square a number, multiply it by itself or use the Math class
			// Math.pow(double a, double b) which
			// returns the value of -a- raised to the power of -b-.

			x[i] = i -100; // CHANGE THIS!!

			// below is a very complicated expression for you to try
			 //y[i] = Math.exp(-alpha * i) * Math.sin(Math.PI * i/beta);

			// but also try the equations you use in your math, science,
			// or engineering classes; for example, a quadratic
			//y = ax^2 + bx + c

			double a = 2, b = 10, c = 0, d = 2, m = .5;
			//y[i] = a*x[i]*x[i]*x[i] + b*x[i]*x[i] + c*x[i] + d;

			// one way to square a number ---
			//y[i] = a*x[i]*x[i] + b*x[i] + c;

			// but this is usually the better way, for any exponent ---
			y[i] = a * Math.pow(x[i], 3.0) + b * Math.pow(x[i], 2.0) + c * x[i] + d;
			
			//y[i] = x[i];

			// yd[] is for the spiral line only, and this is a complicated
			// example
			// yd[i] = Math.exp(-alpha * i) * Math.sin(Math.PI * i/beta);
			// (Math.PI * Math.cos(Math.PI * i/beta)/beta -
			// alpha * Math.sin(Math.PI * i/beta));
		}
		// Draw Plots
		Rectangle2D.Double borderRectangle = new Rectangle2D.Double(20, 20, 360, 260);
		LineChartPanel myLineChart = new LineChartPanel();
		if (e.getActionCommand().equals(lineButton.getText())) {
			myLineChart = new LineChartPanel(borderRectangle, 200, x, y, plotColor[myRandom.nextInt(10)]);
		} else {
			myLineChart = new LineChartPanel(borderRectangle, 200, y, yd, plotColor[myRandom.nextInt(10)]);
		}
		myLineChart.setPreferredSize(new Dimension(400, 300));
		myLineChart.setBackground(Color.white);
		myPanel.removeAll();
		myPanel.add(myLineChart);
		this.pack();

	}

	private void barButtonActionPerformed(ActionEvent e) {

	}

	private void pieButtonActionPerformed(ActionEvent e) {

	}

	private void spiralButtonActionPerformed(ActionEvent e) {

	}

	private void exitForm(WindowEvent e) {
		System.exit(0);

	}
}

// methods (handlers)
