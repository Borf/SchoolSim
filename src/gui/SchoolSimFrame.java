package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import data.Rooster;

public class SchoolSimFrame extends JFrame {
	private static final long serialVersionUID = 4084558452621663337L;

	Rooster rooster = new Rooster();
	
	public SchoolSimFrame()
	{
		super("School Simulator");
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTabbedPane tabPane = new JTabbedPane();
		setContentPane(tabPane);
		
		tabPane.addTab("Rooster", new RoosterPanel(this));
		tabPane.addTab("Simulator", null);
		setVisible(true);
	}
}
