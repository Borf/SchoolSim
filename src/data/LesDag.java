package data;
import java.util.ArrayList;

public class LesDag {
	enum Dag { Maandag, Dinsdag, Woensdag, Donderdag, VrijdagO };
	public Dag dag;
	
	public LesDag(Dag dag)
	{
		this.dag = dag;
	}
	
	public ArrayList<Les> lessen = new ArrayList<>();
}
