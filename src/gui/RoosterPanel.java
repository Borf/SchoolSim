package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.Les;

public class RoosterPanel extends JPanel {
	SchoolSimFrame frame;
	public RoosterPanel(SchoolSimFrame schoolSimFrame) {
		this.frame = schoolSimFrame;
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		float barWidth = getWidth() / 5;
		
		Color[] colors = { new Color(255, 250, 250), new Color(240,240,240) };
		for(int i = 0; i < 5; i++)
		{
			g2.setColor(colors[i%2]);
			g2.fill(new Rectangle2D.Double(barWidth * i, 0, barWidth, getHeight()));
			
			ArrayList<Les> lessen = frame.rooster.lesweek.dagen.get(i).lessen;
			
			int[] perHour = new int[10];
			int[] drawnPerHour = new int[10];
			for(Les l : lessen)
				for(int ii = l.beginUur; ii <= l.eindUur; ii++)
					perHour[ii]++;
			
			g2.setColor(Color.red);
			for(Les l : lessen)
			{
				g2.fill(new Rectangle2D.Double(0, 0, 100, 100));
			}
			
			
		}
		
		
		
	}

}
