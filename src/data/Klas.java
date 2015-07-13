package data;

import java.util.ArrayList;

public class Klas {
	public String naam;
	public int jaargang;
	public ArrayList<Student> studenten;

	public Klas(String naam, int jaargang) {
		this.naam = naam;
		this.jaargang = jaargang;
		studenten = new ArrayList<>();
	}
	
	public String toString()
	{
		return "Klas " + naam;
	}
	
	
}
