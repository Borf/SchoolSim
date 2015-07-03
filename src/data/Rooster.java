package data;

import java.util.ArrayList;

import data.LesDag.Dag;

public class Rooster {
	public LesWeek lesweek;
	ArrayList<Docent> docenten;
	ArrayList<Student> studenten;
	ArrayList<Klas> klassen;
	ArrayList<Lokaal> lokalen;
	
	
	public Rooster()
	{
		lokalen.add(new Lokaal("A100"));
		lokalen.add(new Lokaal("A101"));
		lokalen.add(new Lokaal("A102"));
		lokalen.add(new Lokaal("A103"));
		lokalen.add(new Lokaal("A104"));
		
		studenten.add(new Student("Student 1A"));
		studenten.add(new Student("Student 1B"));
		studenten.add(new Student("Student 1C"));
		studenten.add(new Student("Student 1D"));
		studenten.add(new Student("Student 1E"));
		studenten.add(new Student("Student 1F"));

		studenten.add(new Student("Student 2A"));
		studenten.add(new Student("Student 2B"));
		studenten.add(new Student("Student 2C"));
		studenten.add(new Student("Student 2D"));
		studenten.add(new Student("Student 2E"));
		studenten.add(new Student("Student 2F"));
		
		studenten.add(new Student("Student 3A"));
		studenten.add(new Student("Student 3B"));
		studenten.add(new Student("Student 3C"));
		studenten.add(new Student("Student 3D"));
		studenten.add(new Student("Student 3E"));
		studenten.add(new Student("Student 3F"));
	
		Klas k1 = new Klas("Klas A", 1);
		Klas k2 = new Klas("Klas A", 2);
		Klas k3 = new Klas("Klas A", 3);
		for(int i = 0; i < 6; i++)
		{
			k1.studenten.add(studenten.get(i + 0 * 6));
			k2.studenten.add(studenten.get(i + 1 * 6));
			k3.studenten.add(studenten.get(i + 2 * 6));
		}
		klassen.add(k1);
		klassen.add(k2);
		klassen.add(k3);
		
		lesweek = new LesWeek();
		
		LesDag maandag = new LesDag(Dag.Maandag);
		lesweek.dagen.add(maandag);
		
		
		
		
	}
}
