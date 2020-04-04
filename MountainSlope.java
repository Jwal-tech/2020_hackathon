// this java class is an example of the genetics algorithm used to find optimal distances. While not a complete this could have multiple function on mt shasta itself such as navigating the mountain and
// and creating new ski runs


import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.util.Scanner;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class MountainSlope extends JPanel{

	private final Population population;
	private final AtomicInteger generation;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	
	public MountainSlope() {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);
		this.population = new Population(Utils.MARKERS, 100);
		this.generation = new AtomicInteger(0);
	
		this.population.update();
			
		
		
	}
	
	@Override
	public void paintComponent(final Graphics graphics) {
		super.paintComponent(graphics);
		final Graphics2D g =(Graphics2D) graphics;
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString("shortest path:" + String.format("%.2f", this.population.getBestPath().calculateDistance()), 500, 15);
		drawBestChromosone(g);
		
	}
	
	private void drawBestChromosone(final Graphics2D g) {
		java.util.List<Gene> chromosone = this.population.getBestPath().getChromosone();
		g.setColor(Color.BLACK);
		for(int i = 0; i < (chromosone.size()-1); i++) {
			Gene gene = chromosone.get(i); // get the gene from the chromosone
			Gene nextGene = chromosone.get(i+1); // get the gene from the next chromosone down
			g.drawLine(gene.getX(), gene.getY(), nextGene.getX(), nextGene.getY());	 // draw a line between the two chromosones	
		}
		g.setColor(Color.RED); // set the color to red.
		
		for(Gene gene: chromosone) {
			g.fillOval(gene.getX(), gene.getY(), 10, 10);// create dots
		}
		
		
	}
	
	public static void main(String[]args) {
		
		
		
		SwingUtilities.invokeLater(()-> {
			final JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setTitle("calculate a path ");
			frame.setResizable(false);
			frame.add(new MountainSlope(), BorderLayout.CENTER);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			
		});
		
		
		
	}
	
}

	

 
