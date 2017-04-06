package freedraw;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import java.util.concurrent.TimeUnit;

public class FreeDraw extends JFrame {

	private static final long serialVersionUID = 1L;

	// variable stack -- globals

	JMenuBar mainMenuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem exitMenuItem = new JMenuItem("Exit");
	JMenu backgroundMenu = new JMenu("Background");
	JMenuItem black = new JMenuItem("Black");
	JMenuItem white = new JMenuItem("White");
	JMenuItem orange = new JMenuItem("Orange");
	
	JSlider lineWidth = new JSlider();
	
	
	JPanel drawPanel = new JPanel();
	JLabel leftColorLabel = new JLabel();
	JLabel rightColorLabel = new JLabel();
	JPanel linePanel = new JPanel();

	JPanel colorPanel = new JPanel();
	JLabel[] colorLabel = new JLabel[8];
	Graphics2D g2D;
	double xPrevious, yPrevious;
	Color drawColor, leftColor, rightColor;
	
	

	// constructor

	public FreeDraw() {

		// frame constructor
		setTitle("Drawing w/ Cameron Storm");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});

		getContentPane().setLayout(new GridBagLayout());

		// create a menu bar with menu and sub-menu content
		setJMenuBar(mainMenuBar);
		
		fileMenu.setMnemonic('F');
		mainMenuBar.add(fileMenu);
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		backgroundMenu.setMnemonic('B');
		mainMenuBar.add(backgroundMenu);
		backgroundMenu.add(white);
		backgroundMenu.add(black);
		backgroundMenu.add(orange);
		
		lineWidth.setOrientation(JSlider.VERTICAL);
		lineWidth.setPreferredSize(new Dimension(50, 130));
		lineWidth.setMaximum(100);
		lineWidth.setMinimum(5);
		linePanel.add(lineWidth);
		
		
		
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMenuItemActionPerformed(e);
			}
		});
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitMenuItemActionPerformed(e);
			}
		});
		
		white.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whiteActionPerformed(e);
			}
		});
		black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blackActionPerformed(e);
			}
		});
		orange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orangeActionPerformed(e);
			}
		});
		
		
		

		drawPanel.setPreferredSize(new Dimension(500, 400));
		drawPanel.setBackground(Color.BLACK);
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridheight = 3;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(drawPanel, gridConstraints);
		drawPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				drawPanelMousePressed(e);
			}
		});
		drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				drawPanelMouseDragged(e);
			}
		});
		drawPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				drawPanelMouseReleased(e);
			}
		});

		leftColorLabel.setPreferredSize(new Dimension(40, 40));
		leftColorLabel.setBackground(Color.BLUE); // temp, for testing
		leftColorLabel.setOpaque(true);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(leftColorLabel, gridConstraints);

		rightColorLabel.setPreferredSize(new Dimension(40, 40));
		rightColorLabel.setBackground(Color.RED); // temporary, for testing
		rightColorLabel.setOpaque(true);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(rightColorLabel, gridConstraints);

		colorPanel.setPreferredSize(new Dimension(80, 160));
		colorPanel.setBackground(Color.lightGray); // for testing
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));

		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 2;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(colorPanel, gridConstraints);

		colorPanel.setLayout(new GridBagLayout());
		int j = 0;
		for (int i = 0; i < colorLabel.length; i++) {
			colorLabel[i] = new JLabel();
			colorLabel[i].setPreferredSize(new Dimension(30, 30));
			colorLabel[i].setOpaque(true);
			gridConstraints = new GridBagConstraints();
			gridConstraints.gridx = j;
			gridConstraints.gridy = i - j * 4;
			colorPanel.add(colorLabel[i], gridConstraints);
			if (i == 3) {
				j++;
			}
			colorLabel[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					colorMousePressed(e);
				}
			});
		}
		
		

		// set color labels

		colorLabel[0].setBackground(Color.gray);
		colorLabel[1].setBackground(Color.blue);
		colorLabel[2].setBackground(Color.green);
		colorLabel[3].setBackground(Color.cyan);
		colorLabel[4].setBackground(Color.red);
		colorLabel[5].setBackground(Color.magenta);
		colorLabel[6].setBackground(Color.yellow);
		colorLabel[7].setBackground(Color.white);
		leftColor = colorLabel[0].getBackground();
		leftColorLabel.setBackground(leftColor);
		rightColor = colorLabel[7].getBackground();
		rightColorLabel.setBackground(rightColor);
		
		linePanel.setPreferredSize(new Dimension(80, 160));
		linePanel.setBackground(Color.lightGray);
		linePanel.setBorder(BorderFactory.createTitledBorder("Line"));
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		gridConstraints.gridwidth = 2;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(linePanel, gridConstraints);

		pack();
		setLocationRelativeTo(null);
		g2D = (Graphics2D) drawPanel.getGraphics();
		
		
		
	} // end of constructor

	
	/*
	 * 
	 */

	
	// method stack
	private void orangeActionPerformed(ActionEvent e){
		drawPanel.setBackground(Color.ORANGE);
	}
	
	private void whiteActionPerformed(ActionEvent e){
		drawPanel.setBackground(Color.WHITE);
	}
	
	private void blackActionPerformed(ActionEvent e){
		drawPanel.setBackground(Color.BLACK);
	}

	private void colorMousePressed(MouseEvent e) {
		// decide which color was selected and which button was used
		Component clickedColor = e.getComponent();
		// make audible tone and set drawing color
		Toolkit.getDefaultToolkit().beep();
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftColor = clickedColor.getBackground();
			leftColorLabel.setBackground(leftColor);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightColor = clickedColor.getBackground();
			rightColorLabel.setBackground(rightColor);
		}

	}

	private void drawPanelMouseReleased(MouseEvent e) {

	}

	private void drawPanelMouseDragged(MouseEvent e) {
		// if drawing, connect previous point with new point
		Line2D.Double myLine = new Line2D.Double
				(xPrevious,
				yPrevious,
				e.getX(),
				e.getY());
				g2D.setPaint(drawColor);
				g2D.draw(myLine);
				int getStroke = lineWidth.getValue();
				g2D.setStroke(new BasicStroke(getStroke));
				xPrevious = e.getX();
				yPrevious = e.getY();
				

	}

	private void drawPanelMousePressed(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
			xPrevious = e.getX();
			yPrevious = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				drawColor = leftColor;
			} else {
				drawColor = rightColor;
			}
		}

	}

	private void exitForm(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "Thank you for Drawing w/ Cameron Storm!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		// g2D.dispose();
		// exit code
		System.exit(0);

	}

	private void newMenuItemActionPerformed(ActionEvent e) {
		
		int response;
		response = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to start a new drawing?",
				"New Drawing", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
				);
		if(response == JOptionPane.YES_OPTION)
		{
			g2D.setPaint(drawPanel.getBackground());
			g2D.fill(new Rectangle2D.Double(
					0,
					0,
					drawPanel.getWidth(),
					drawPanel.getHeight())
					);
		}

	}// end of new menu item

	private void exitMenuItemActionPerformed(ActionEvent e) {

		int response;
		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Exit",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			return;
		} else {
			exitForm(null);
		}

	}

}