package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import data.Les;
import data.LesDag;

public class RoosterPanel extends JPanel {
	SchoolSimFrame frame;
	Les draggingLes = null;
	int dragMode = 0;
	
	HashMap<Les, Rectangle2D> rectCache = new HashMap<>();
	
	
	public RoosterPanel(SchoolSimFrame schoolSimFrame) {
		this.frame = schoolSimFrame;
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				rectCache.forEach((les,rect) -> {
					if(rect.contains(e.getPoint()))
					{
						draggingLes = les;
						dragMode = 0;
						if(Math.abs(rect.getY() - e.getY()) < 15)
							dragMode = 1;
						else if(Math.abs((rect.getY() + rect.getHeight()) - e.getY()) < 15)
							dragMode = 2;
					}
				});
				if(draggingLes == null && e.getClickCount() == 2)
				{
					int newDay = (int)(e.getX() / (float)getWidth() * 5);
					int beginUur = Math.min(9-2, (int)(10 * e.getY() / (float)getHeight()));
					int eindUur = Math.min(9,  beginUur + 2);
					frame.rooster.lesweek.dagen.get(newDay).lessen.add(new Les("Geen naam", beginUur, eindUur, frame.rooster.klassen.get(0), frame.rooster.lokalen.get(0), frame.rooster.docenten.get(0)));
					repaint();
					
				}
			}
			public void mouseReleased(MouseEvent e) {
				draggingLes = null;
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(draggingLes != null)
				{
					int lengte = draggingLes.eindUur - draggingLes.beginUur;

					if(dragMode != 2)
						draggingLes.beginUur = Math.min(9-lengte, (int)(10 * e.getY() / (float)getHeight()));
					if(dragMode != 1)
						draggingLes.eindUur = Math.min(9,  draggingLes.beginUur + lengte);
					if(dragMode == 2)
						draggingLes.eindUur = Math.min(9,  (int)(10 * e.getY() / (float)getHeight()));
				
					int newDay = (int)(e.getX() / (float)getWidth() * 5);
					int day = frame.rooster.lesweek.zoekDagVoorLes(draggingLes);
					if(day != newDay && day != -1 && newDay >= 0 && newDay < 5)
					{
						frame.rooster.lesweek.dagen.get(day).lessen.remove(draggingLes);
						frame.rooster.lesweek.dagen.get(newDay).lessen.add(draggingLes);
					}
					repaint();
				}
			}
			
		});
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		float barWidth = getWidth() / 5;
		
		rectCache.clear(); // shouldn't do this
		Color[] colors = { new Color(255, 250, 250), new Color(240,240,240) };
		for(int i = 0; i < 5; i++)
		{
			g2.setColor(colors[i%2]);
			g2.fill(new Rectangle2D.Double(barWidth * i, 0, barWidth, getHeight()));
			
			ArrayList<Les> lessen = frame.rooster.lesweek.dagen.get(i).lessen;
			
			int[] perHour = new int[10];
			int[] drawnPerHour = new int[10];
			int width = 0;
			for(Les l : lessen)
				for(int ii = l.beginUur; ii < l.eindUur; ii++)
					width = Math.max(width,  ++perHour[ii]);

			
			for(int ii = 0; ii < 10; ii++)
				drawnPerHour[ii] = 0; 
			
			for(Les l : lessen)
			{
				int max = 0;
				for(int ii = l.beginUur; ii < l.eindUur; ii++)
					max = Math.max(max, drawnPerHour[ii]);
				
				float y = l.beginUur / 10.0f * getHeight();
				float h = (l.eindUur - l.beginUur) / 10.0f * getHeight();
				float w = barWidth / width;
				float x = i * barWidth + w * max;
				
				g2.setColor(Color.darkGray);
				g2.fill(new Rectangle2D.Double(x, y, w, h));
				
				rectCache.put(l, new Rectangle2D.Double(x,y,w,h));
				g2.setColor(Color.white);
				drawStringMultiLine(g2, l.toString(), x+10, y+20);

				for(int ii = l.beginUur; ii < l.eindUur; ii++)
					drawnPerHour[ii]++;
			}
		}
	}
	
	
	
	public void drawStringMultiLine(Graphics2D g2, String text, float x, float y)
	{
		String[] lines = text.split("\n");
		for(String line : lines)
		{
			g2.drawString(line, x, y);
			y += 12;
		}
	}

}
