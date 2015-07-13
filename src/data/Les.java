package data;

public class Les {
	public Les(String naam, int beginUur, int eindUur, Klas klas, Lokaal lokaal, Docent docent) {
		this.naam = naam;
		this.beginUur = beginUur;
		this.eindUur = eindUur;
		this.docent = docent;
		this.klas = klas;
		this.lokaal = lokaal;
	}
	public String naam;
	public int beginUur;
	public int eindUur;

	
	public Docent docent;
	public Klas klas;
	public Lokaal lokaal;
	
	public String toString()
	{
		return naam + "\n" +
				beginUur + " - " + eindUur + "\n" +
				docent + "\n" + 
				klas + "\n" + 
				lokaal;
	}
	
}
